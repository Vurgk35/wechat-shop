package cn.blbsz.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_resource")
@Getter
@Setter
public class MyResourceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String url;
	@ManyToMany(mappedBy = "resourceEntities")
	private List<MyRoleEntity> roleEntities=new ArrayList<>();
	
	@Override
	public String toString() {
		return "MyResourceEntity [id=" + id + ", url=" + url + "]";
	}
	
	
}
