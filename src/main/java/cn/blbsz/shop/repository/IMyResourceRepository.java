package cn.blbsz.shop.repository;

import org.springframework.data.repository.RepositoryDefinition;

import cn.blbsz.shop.entity.MyResourceEntity;

@RepositoryDefinition(domainClass = MyResourceEntity.class,idClass = Long.class)
public interface IMyResourceRepository {

}
