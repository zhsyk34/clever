package com.dnk.clever.door.controller;

import com.dnk.clever.door.entity.User;
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
 * Created by Archimedes on 2016-08-09.
 */
@Controller
@RequestMapping("/user")
public class UserController extends CommonsController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/find")
	@ResponseBody
	public EasyGrid<User> find(int page, int rows) {
		EasyGrid<User> grid = new EasyGrid<>();
		List<User> users = userService.findByPage(page, rows);
		int total = userService.count();
		grid.setRows(users);
		grid.setTotal(total);
		return grid;
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(User user) {
		System.out.println(user);

		if (StringUtils.isEmpty(user.getName())) {
			return Feedback.ERROR.toString();
		}

		if (user.getId() == null || user.getId() <= 0) {
			userService.save(user);
			return Feedback.CREATE.toString();
		}

		user.setUpdateTime(new Date());
		userService.update(user);
		return Feedback.UPDATE.toString();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public String delete(int[] ids) {
		if (ids == null || ids.length == 0) {
			logger.error("params is invalid.");
			return Feedback.ERROR.toString();
		}
		for (int id : ids) {
			System.out.println(id);
		}
		userService.deleteByIds(ids);
		return Feedback.DELETE.toString();
	}

}
