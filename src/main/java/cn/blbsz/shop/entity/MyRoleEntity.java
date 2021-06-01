package cn.blbsz.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "t_role")
@Getter
@Setter
public class MyRoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	 @ManyToMany
	 @JoinTable(name = "t_role_t_resource", joinColumns = {@JoinColumn(name ="role_id" )}, inverseJoinColumns = { @JoinColumn(name = "resource_id") })
	private List<MyResourceEntity> resourceEntities=new ArrayList<>();
	 @ManyToMany(mappedBy = "roleEntities")
	private List<MyUserEntity> userEntities;
	 
	@Override
	public String toString() {
		return "MyRoleEntity [id=" + id + ", name=" + name + ", resourceEntities=" + resourceEntities + "]";
	}
	
	 
	 
}
