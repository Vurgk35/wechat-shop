package cn.blbsz.shop.service.impl;

import cn.blbsz.shop.service.UserService;
import cn.blbsz.shop.utils.JdbcUtil;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.hibernate.jpa.HibernateEntityManager;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 2017/3/31.
 */
@Service
public class UserServiceImpl implements UserService{
    @PersistenceContext
    private EntityManager entityManager;

    public List<Map<String, Object>> getNewBankUserInfo(Integer userID){
        final List<Map<String, Object>>[] maps = new List[1];
        Session session = entityManager.unwrap(HibernateEntityManager.class).getSession();
        session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {
                    CallableStatement callableStatement = connection.prepareCall("{call GetNewBankUserInfo(?,?)}");
                    callableStatement.setInt(1,101322);
                    callableStatement.setInt(2,419634227);
                    callableStatement.execute();
                    maps[0] = JdbcUtil.convertList(callableStatement.getResultSet());
                    while (callableStatement.getMoreResults()){
                        maps[0].addAll(JdbcUtil.convertList(callableStatement.getResultSet()));
                    }
                }
        });
        return maps[0];
    }
}
