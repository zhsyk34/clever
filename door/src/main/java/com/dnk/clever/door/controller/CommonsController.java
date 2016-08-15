package com.dnk.clever.door.controller;

import com.dnk.clever.door.service.BuildService;
import com.dnk.clever.door.service.HouseService;
import com.dnk.clever.door.service.UnitService;
import com.dnk.clever.door.service.UserService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Archimedes on 2016-08-09.
 */
public class CommonsController {
	@Resource
	protected UserService userService;
	@Resource
	protected BuildService buildService;
	@Resource
	protected UnitService unitService;
	@Resource
	protected HouseService houseService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

}
