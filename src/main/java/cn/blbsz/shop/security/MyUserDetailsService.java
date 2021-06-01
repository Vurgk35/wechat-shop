package cn.blbsz.shop.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.blbsz.shop.entity.MyRoleEntity;
import cn.blbsz.shop.entity.MyUserEntity;
import cn.blbsz.shop.repository.IMyUserRepository;

public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	IMyUserRepository myUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 根据用户名到数据库查询是否有这个用户
		MyUserEntity myUserEntity = myUserRepository.findByUsername(username);
		if (myUserEntity == null) {
			throw new UsernameNotFoundException("not found");
		}
		
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		List<MyRoleEntity> roleEntities = myUserEntity.getRoleEntities();
		
		for (MyRoleEntity myRoleEntity : roleEntities) {
			 authorities.add(new SimpleGrantedAuthority(myRoleEntity.getName()));
			 System.err.println("username is " + username + ", 角色：" + myRoleEntity.getName());
		}
       
        return new org.springframework.security.core.userdetails.User(myUserEntity.getUsername(),
        		myUserEntity.getPassword(), authorities);

	}

}
