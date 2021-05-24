package cn.blbsz.shop.repository;

import cn.blbsz.Application;
import cn.blbsz.shop.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Lenovo on 2017/3/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    @Test
    public void test() {
        Assert.assertEquals((userRepository.findByUserId(418000000).getNickname()),"橙橙");
    }
}
