package org.dream.controller;

import org.ael.c.annotation.Controller;
import org.ael.c.annotation.GetMapping;
import org.ael.ioc.core.annotation.Injection;
import org.dream.service.InstallService;

import java.sql.SQLException;

@Controller
public class InstallController {

    @Injection
    private InstallService installService;

    @GetMapping(value = "/install")
    public String installView() throws Exception {
        return installService.install();
    }

}
