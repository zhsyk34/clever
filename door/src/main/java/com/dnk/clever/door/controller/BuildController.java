package com.dnk.clever.door.controller;

import com.dnk.clever.door.entity.Build;
import com.dnk.clever.door.vo.EasyGrid;
import com.dnk.clever.door.vo.Feedback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * user-controller
 * Created by Archimedes on 2016-08-15.
 */
@Controller
@RequestMapping("/build")
public class BuildController extends CommonsController {

	private static final Logger logger = LoggerFactory.getLogger(BuildController.class);

	@RequestMapping(value = "/find")
	@ResponseBody
	public EasyGrid<Build> find(String name, int page, int rows) {
		EasyGrid<Build> grid = new EasyGrid<>();
		List<Build> list = buildService.findList(name, page, rows);
		int total = buildService.countList(name);
		grid.setRows(list);
		grid.setTotal(total);
		return grid;
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(Build build) {
		System.out.println(build);

		if (StringUtils.isEmpty(build.getName())) {
			return Feedback.ERROR.toString();
		}

		Integer code = build.getCode();
		if (code == null || code <= 0) {
			return Feedback.ERROR.toString();
		}
		if (buildService.exist(build.getId(), code)) {
			return Feedback.EXIST.toString();
		}

		Integer id = build.getId();
		if (id == null || id <= 0) {
			buildService.save(build);
			return Feedback.CREATE.toString();
		}

		build.setUpdateTime(new Date());
		buildService.update(build);
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
		return buildService.exist(id, code);
	}

}
