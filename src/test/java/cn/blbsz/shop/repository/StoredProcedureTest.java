package cn.blbsz.shop.repository;

import cn.blbsz.JdbcUtil;
import org.junit.Test;

import java.sql.*;
import java.util.*;

/**
 * Created by Lenovo on 2017/3/31.
 */
public class StoredProcedureTest {

    @Test
    public void Tests() {
        final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        final String DATABASE_URL = "jdbc:sqlserver://106.15.103.177:1433;DatabaseName=winmob3";
        final String DATABASE_USRE = "sa";
        final String DATABASE_PASSWORD = "Yi2017Dat@";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USRE, DATABASE_PASSWORD);
             CallableStatement stmt = connection.prepareCall("{call GetNewBankUserInfo(?,?)}")) {
            stmt.setInt(1, 101322);
            stmt.setInt(2, 419634227);
            stmt.execute();
//            System.out.println(JdbcUtil.convertList(stmt.getResultSet()));
            System.err.println("================> " + Arrays.toString(storedProcedureQuery(stmt).toArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Map<String, Object>> storedProcedureQuery(Statement statement) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try (Statement stmt = statement) {
            do {
                try (ResultSet rs = stmt.getResultSet()) {
                    if (rs != null && !rs.isClosed()) {
                        ResultSetMetaData md = rs.getMetaData();
                        int columnCount = md.getColumnCount();
                        while (rs.next()) {
                            Map<String, Object> rowData = new HashMap<String, Object>();
                            for (int i = 1; i <= columnCount; i++) {
                                rowData.put(md.getColumnName(i), rs.getObject(i));
                            }
                            list.add(rowData);
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } while (stmt.getMoreResults());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
