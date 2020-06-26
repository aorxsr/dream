package org.dream.controller;

import org.ael.c.annotation.Controller;
import org.ael.c.annotation.GetMapping;
import org.ael.c.annotation.RequestMapping;

@Controller
public class InstallController {

    @GetMapping(value = "/install")
    public String installView() {

        return "/install/install";
    }

}
