package com.dnk.clever.door.controller;

import com.dnk.clever.door.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

class CommonsController {

	protected static final Logger logger = LoggerFactory.getLogger(CommonsController.class);

	@Resource
	protected UserService userService;
	@Resource
	protected BuildService buildService;
	@Resource
	protected UnitService unitService;
	@Resource
	protected HouseService houseService;
	@Resource
	protected GatewayService gatewayService;
	@Resource
	protected LockService lockService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

}
