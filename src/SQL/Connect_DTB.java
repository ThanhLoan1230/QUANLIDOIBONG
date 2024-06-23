/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect_DTB {

    public static Connection openConnection() throws Exception {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost; database=QuanLyDoiBong";
        String dbusername = "sa";
        String password = "123456";

        Connection con = DriverManager.getConnection(connectionUrl, dbusername, password);

        return con;
    }

}
