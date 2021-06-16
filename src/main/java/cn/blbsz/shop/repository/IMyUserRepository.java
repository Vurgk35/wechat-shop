package cn.blbsz.shop.repository;

import org.springframework.data.repository.RepositoryDefinition;

import cn.blbsz.shop.entity.MyUserEntity;
import cn.blbsz.shop.entity.UserEntity;

@RepositoryDefinition(domainClass = MyUserEntity.class,idClass = Long.class)
public interface IMyUserRepository {
	 public MyUserEntity findByUsername(String username);
}
