package cn.blbsz.shop.repository;

import cn.blbsz.Application;
import cn.blbsz.JdbcUtil;
import cn.blbsz.shop.entity.UserEntity;
import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerStatement;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.hibernate.jpa.HibernateEntityManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.*;
import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

/**
 * Created by Lenovo on 2017/3/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    private EntityManager em;

    @Test
    public void test() {
        Assert.assertEquals((userRepository.findNickNameByUserId(1L).getNickName()),"张建");
    }

    @Test
    public void procedureTest() {
//        Query query = em.createNativeQuery("exec GetNewBankUserInfo @custID=N'101322',@userID=N'419634227'");
        StoredProcedureQuery getNewBankUserInfo = em.createStoredProcedureQuery("GetNewBankUserInfo")
                .registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
                .setParameter(0, 101322)
                .setParameter(1, 419634227);
//        getNewBankUserInfo.unwrap(SQLQuery.class);
        if (getNewBankUserInfo.execute()){
            do {
                List list = getNewBankUserInfo.getResultList();
                for (Object obj:
                        list) {
                    if (obj instanceof Object[]){
                        Object[] objs = (Object[]) obj;
                        for (Object object:
                                objs) {
                            System.out.println(object);
                        }
                    }
                }

            }while (getNewBankUserInfo.hasMoreResults());
        }
    }

    @Test
    public  void procedureTest2() {
        Session session = em.unwrap(HibernateEntityManager.class).getSession();
        Transaction transaction = session.beginTransaction();
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                CallableStatement callableStatement = connection.prepareCall("exec GetNewBankUserInfo @custID=N'101322',@userID=N'419634227'");
                callableStatement.execute();
                ResultSet resultSet = callableStatement.getResultSet();
                List<Map<String, Object>> maps = JdbcUtil.convertList(resultSet);
                System.out.println("+++++++" + maps);
            }
        });
        transaction.commit();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void procedureTest3() throws SQLException {
        DataSource dataSource = SessionFactoryUtils.getDataSource(em.unwrap(HibernateEntityManager.class).getSession().getSessionFactory());
        Connection connection = dataSource.getConnection();
        CallableStatement callableStatement = connection.prepareCall("{call GetNewBankUserInfo(?,?)}");
        callableStatement.setInt(1,101322);
        callableStatement.setInt(2,419634227);
        callableStatement.execute();
        System.out.println("+++++++" + JdbcUtil.convertList(callableStatement.getResultSet()));
        callableStatement.getMoreResults();
        System.out.println("+++++++" + JdbcUtil.convertList(callableStatement.getResultSet()));        callableStatement.getMoreResults();

    }
}
