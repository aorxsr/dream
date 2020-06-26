package org.dream;

import cn.hutool.extra.template.engine.thymeleaf.ThymeleafEngine;
import org.ael.Ael;
import org.ael.route.exception.NoMappingException;
import org.ael.server.netty.exception.ExcInfo;
import org.ael.server.netty.exception.ExecuteException;
import org.dream.thymeleafconfig.ThymeleafConfig;
import org.dream.util.DBUtil;

public class App {

    public static void main(String[] args) {

        Ael ael = new Ael();
        ael.addResourcesMapping("/statics", "/statics/");
        ael.addResourcesMapping("/public", "/public/");
        // 异常配置
        ExecuteException executeException = ael.getExecuteException();
        executeException.addException(NoMappingException.class, new ExcInfo("org.ael.exception.Exceptions", "noMapping"));
        // 配置页面为 Thymeleaf
        ael.setAelTemplate(new ThymeleafConfig());
        // 设置DBUtil
        DBUtil.password = ael.getEnvironment().getString("jdbc.password");
        DBUtil.username = ael.getEnvironment().getString("jdbc.username");
        DBUtil.url = ael.getEnvironment().getString("jdbc.url");
        // 启动
        ael.start();
    }

}
