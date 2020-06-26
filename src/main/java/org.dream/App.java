package org.dream;

import cn.hutool.extra.template.engine.thymeleaf.ThymeleafEngine;
import org.ael.Ael;
import org.ael.route.exception.NoMappingException;
import org.ael.server.netty.exception.ExcInfo;
import org.ael.server.netty.exception.ExecuteException;
import org.dream.thymeleafconfig.ThymeleafConfig;

public class App {

    public static void main(String[] args) {

        Ael ael = new Ael();

        ael.addResourcesMapping("/statics", "/statics/");

        ExecuteException executeException = ael.getExecuteException();
        executeException.addException(NoMappingException.class, new ExcInfo("org.ael.exception.Exceptions", "noMapping"));

        // 配置页面为 Thymeleaf
        ael.setAelTemplate(new ThymeleafConfig());

        ael.start();

    }

}
