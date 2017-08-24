package com.XMLReader.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.XMLReader.entities.report.ConvertReportPOJO;

@Controller
@RequestMapping ("/")
public class WelcomeController {
	
	@RequestMapping(method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        return "welcome";
    }
	
	@RequestMapping(path= "/welcome", method = RequestMethod.GET)
	public String sayWelcome(ModelMap model) {
		return "welcome";
	}
	
	@NotifyClients
	@RequestMapping(value = "/ideas", method = RequestMethod.POST)
	public @ResponseBody ConvertReportPOJO convert(@RequestBody String path) {
		ConvertReportPOJO out = new ConvertReportPOJO();
	    return out;
	}

}
