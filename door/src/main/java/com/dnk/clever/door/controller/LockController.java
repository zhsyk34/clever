package com.dnk.clever.door.controller;

import com.dnk.clever.door.entity.Build;
import com.dnk.clever.door.entity.Lock;
import com.dnk.clever.door.util.JSONParse;
import com.dnk.clever.door.vo.EasyGrid;
import com.dnk.clever.door.vo.Feedback;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lock")
public class LockController extends CommonsController {

	@RequestMapping(value = "/list")
	@ResponseBody
	public List<Build> list(String name) {
		return null;
	}

	@RequestMapping(value = "/find")
	@ResponseBody
	public EasyGrid<Map> find(String build, String unit, String house, String name, int page, int rows) {
		EasyGrid<Map> grid = new EasyGrid<>();
		List<Map> list = lockService.findList(build, unit, house, name, page, rows);
		int total = lockService.count(build, unit, house, name);
		grid.setRows(list);
		grid.setTotal(total);
		return grid;
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(Lock lock) {
		JSONParse.toJSON(lock);
		if (lock.getId() <= 0) {
			lockService.save(lock);
			return Feedback.CREATE.toString();
		}
		lockService.update(lock);
		return Feedback.UPDATE.toString();
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public String delete(long[] ids) {
		if (ids == null || ids.length == 0) {
			return Feedback.ERROR.toString();
		}
		if (lockService.relate(ids)) {
			return Feedback.RELATE.toString();
		}
		lockService.delete(ids);
		return Feedback.DELETE.toString();
	}

	@RequestMapping(value = "/exist")
	@ResponseBody
	public boolean exist(Integer id, int code) {
		return false;
	}
}
