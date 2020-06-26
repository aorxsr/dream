package org.dream.controller;

import org.ael.c.annotation.Controller;
import org.ael.c.annotation.GetMapping;
import org.ael.ioc.core.annotation.Injection;
import org.ael.template.ModelAndView;
import org.dream.util.DBUtil;

import java.rmi.MarshalledObject;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    public ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addModelData("a", "aa");

        return modelAndView;
    }

}
