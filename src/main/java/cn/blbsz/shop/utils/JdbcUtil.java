package cn.blbsz.shop.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Lenovo on 2017/3/31.
 */
public class JdbcUtil {

    public static  List<Map<String, Object>> convertList(ResultSet resultSet) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        if (resultSet != null){
            try (ResultSet rs = resultSet) {
                ResultSetMetaData md = rs.getMetaData();
                int columnCount = md.getColumnCount();
                while (rs.next()) {
                    Map<String, Object> rowData = new HashMap<String, Object>();
                    for (int i = 1; i <= columnCount; i++) {
                        rowData.put(md.getColumnName(i), rs.getObject(i));
                    }
                    list.add(rowData);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


    public static Map<String, Object> convertMap(ResultSet resultSet) {
        Map<String, Object> map = new HashMap<String, Object>();
        try(ResultSet rs = resultSet) {
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    map.put(md.getColumnName(i), rs.getObject(i));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}