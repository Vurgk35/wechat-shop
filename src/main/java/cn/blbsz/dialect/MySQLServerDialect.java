package cn.blbsz.dialect;

import org.hibernate.dialect.SQLServerDialect;
import org.hibernate.type.StandardBasicTypes;

import java.sql.Types;

/**
 * Created by Lenovo on 2017/3/31.
 */
public class MySQLServerDialect extends SQLServerDialect {
    public MySQLServerDialect() {
        super();
        registerHibernateType(Types.NVARCHAR, StandardBasicTypes.STRING.getName());
    }
}
