package cn.blbsz.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_user")
@Getter
@Setter
public class MyUserEntity {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String username;
	private String password;
	 @ManyToMany(fetch=FetchType.EAGER)
	 @JoinTable(name = "t_user_t_role", joinColumns = {@JoinColumn(name ="user_id" )}, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private List<MyRoleEntity> roleEntities=new ArrayList<>();
	 
	@Override
	public String toString() {
		return "MyUserEntity [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", roleEntities=" + roleEntities + "]";
	}
	
	 
	 
}
