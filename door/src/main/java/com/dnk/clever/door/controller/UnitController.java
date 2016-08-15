package com.dnk.clever.door.controller;

import com.dnk.clever.door.entity.Unit;
import com.dnk.clever.door.util.JSONParse;
import com.dnk.clever.door.vo.EasyGrid;
import com.dnk.clever.door.vo.Feedback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * user-controller
 * Created by Archimedes on 2016-08-15.
 */
@Controller
@RequestMapping("/unit")
public class UnitController extends CommonsController {

	private static final Logger logger = LoggerFactory.getLogger(UnitController.class);

	@RequestMapping(value = "/find")
	@ResponseBody
	public EasyGrid<Map> find(String build, String unit, int page, int rows) {
		EasyGrid<Map> grid = new EasyGrid<>();
		List<Map> list = unitService.findList(build, unit, page, rows);
		int total = unitService.countList(build, unit);
		grid.setRows(list);
		grid.setTotal(total);
		return grid;
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(Unit unit) {
		System.out.println(JSONParse.toJSON(unit));

		Integer code = unit.getCode();
		if (code == null || code <= 0) {
			return Feedback.ERROR.toString();
		}
		Integer id = unit.getId();
		if (unitService.exist(id, code)) {
			return Feedback.EXIST.toString();
		}

		if (id == null || id <= 0) {
			unitService.save(unit);
			return Feedback.CREATE.toString();
		}

		unit.setUpdateTime(new Date());
		unitService.update(unit);
		return Feedback.UPDATE.toString();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public String delete(int[] ids) {
		if (ids == null || ids.length == 0) {
			return Feedback.ERROR.toString();
		}
		logger.info("ids", ids);
		userService.deleteByIds(ids);
		return Feedback.DELETE.toString();
	}

	@RequestMapping(value = "/exist")
	@ResponseBody
	public boolean exist(Integer id, int code) {
		System.out.println(id);
		System.out.println(code);
		return unitService.exist(id, code);
	}

}
