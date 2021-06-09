package cn.blbsz.shop.repository;

import cn.blbsz.shop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

/**
 * Created by Lenovo on 2017/3/27.
 */
@RepositoryDefinition(domainClass = UserEntity.class,idClass = Long.class)
public interface UserRepository{
    public UserEntity findNickNameByUserId(Long id);
}
