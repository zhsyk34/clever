package com.dnk.clever.door.controller;

import com.dnk.clever.door.entity.House;
import com.dnk.clever.door.util.JSONParse;
import com.dnk.clever.door.vo.EasyGrid;
import com.dnk.clever.door.vo.Feedback;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/house")
public class HouseController extends CommonsController {

	@RequestMapping(value = "/list")
	@ResponseBody
	public List<House> list(Long unitId) {
		return unitId == null ? null : houseService.findList(unitId, null, -1, -1);
	}

	@RequestMapping(value = "/find")
	@ResponseBody
	public EasyGrid<Map> find(String build, String unit, String house, int page, int rows) {
		EasyGrid<Map> grid = new EasyGrid<>();
		List<Map> list = houseService.findList(build, unit, house, page, rows);
		int total = houseService.count(build, unit, house);
		grid.setRows(list);
		grid.setTotal(total);
		return grid;
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(House house) {
		System.out.println(JSONParse.toJSON(house));
		if (house.getId() <= 0) {
			houseService.save(house);
			return Feedback.CREATE.toString();
		}

		house.setUpdateTime(new Date());
		houseService.update(house);
		return Feedback.UPDATE.toString();
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public String delete(long[] ids) {
		if (ids == null || ids.length == 0) {
			return Feedback.ERROR.toString();
		}
		if (houseService.relate(ids)) {
			return Feedback.RELATE.toString();
		}
		houseService.delete(ids);
		return Feedback.DELETE.toString();
	}

	@RequestMapping(value = "/exist")
	@ResponseBody
	public boolean exist(Integer id, int code) {
		return houseService.exist(id, code);
	}
}
