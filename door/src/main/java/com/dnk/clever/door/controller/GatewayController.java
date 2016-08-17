package com.dnk.clever.door.controller;

import com.dnk.clever.door.entity.Build;
import com.dnk.clever.door.entity.Gateway;
import com.dnk.clever.door.util.JSONParse;
import com.dnk.clever.door.vo.EasyGrid;
import com.dnk.clever.door.vo.Feedback;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/gateway")
public class GatewayController extends CommonsController {

	@RequestMapping(value = "/list")
	@ResponseBody
	public List<Build> list(String name) {
		return null;
	}

	@RequestMapping(value = "/find")
	@ResponseBody
	public EasyGrid<Map> find(String build, String unit, String name, int page, int rows) {
		EasyGrid<Map> grid = new EasyGrid<>();
		List<Map> list = gatewayService.findList(build, unit, name, page, rows);
		int total = gatewayService.count(build, unit, name);
		grid.setRows(list);
		grid.setTotal(total);
		return grid;
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(Gateway gateway) {
		JSONParse.toJSON(gateway);
		if (gateway.getId() <= 0) {
			gatewayService.save(gateway);
			return Feedback.CREATE.toString();
		}
		gatewayService.update(gateway);
		return Feedback.UPDATE.toString();
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public String delete(long[] ids) {
		if (ids == null || ids.length == 0) {
			return Feedback.ERROR.toString();
		}
		if (gatewayService.relate(ids)) {
			return Feedback.RELATE.toString();
		}
		gatewayService.delete(ids);
		return Feedback.DELETE.toString();
	}

	@RequestMapping(value = "/exist")
	@ResponseBody
	public boolean exist(Integer id, int code) {
		//TODO
		return false;
	}
}
