package com.XMLReader.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.XMLReader.entities.report.ConvertReportPOJO;
import com.XMLReader.io.LogUtil;
import com.XMLReader.web.bean.ConvertRequest;

@Controller
@RequestMapping ("/")
public class WelcomeController extends LogUtil {
	
	@RequestMapping(method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        return "welcome";
    }
	
	@RequestMapping(path= "/welcome", method = RequestMethod.GET)
	public String sayWelcome(ModelMap model) {
		return "welcome";
	}
	
	@NotifyClients
	@RequestMapping(value = "/convert", method = RequestMethod.POST)
	public @ResponseBody ConvertReportPOJO convert(@RequestBody ConvertRequest request) {
		ConvertReportPOJO out = new ConvertReportPOJO();
		
		info("In WelcomeController");
		
	    return out;
	}

}
