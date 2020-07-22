package org.dream.service;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import org.ael.ioc.core.annotation.Service;

import java.util.List;

@Service
public class InstallService {

    public String install() throws Exception {
        List<Entity> list = Db.use().findAll(Entity.create("configuration").set("key", "install"));
        if (list.isEmpty()) {
            throw new Exception("數據庫未配置正確!");
        }
        Entity entity = list.get(0);
        Integer install = entity.getInt("value");
        return install == 0 ? "/install/install" : "/install/ok";
    }

}
