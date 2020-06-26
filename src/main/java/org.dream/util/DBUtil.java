package org.dream.util;

import org.ael.orm.annotation.Value;
import org.ael.plugin.ioc.Compent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Compent
public class DBUtil {

    @Value(name = "jdbc.username")
    private String username;

    @Value(name = "jdbc.password")
    private String password;

    @Value(name = "jdbc.driverClassName")
    private String driverClassName;

    @Value(name = "jdbc.url")
    private String url;

    private Connection connection;

    public Connection newConnection() {
        if (null == connection) {
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }

}
