package cn.blbsz.shop.repository;

import org.springframework.data.repository.RepositoryDefinition;

import cn.blbsz.shop.entity.MyRoleEntity;

@RepositoryDefinition(domainClass = MyRoleEntity.class,idClass = Long.class)
public interface IMyRoleRepository {

}
