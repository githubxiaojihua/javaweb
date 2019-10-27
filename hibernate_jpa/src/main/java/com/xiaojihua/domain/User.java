package com.xiaojihua.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// 多对多关系 用户  N
@Entity
@Table(name="sys_user")
public class User 
{
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long user_id;// '用户id',
	@Column(name="user_code")
	private String user_code;// '用户账号',
	@Column(name="user_name")
	private String user_name;// '用户名称',
	@Column(name="user_password")
	private String user_password;// '用户密码',
	@Column(name="user_state")
	private String user_state;//'1:正常,0:暂停',	
	
	// 有Role的集合
	// 配置多对多的关系
	// 有Role的集合
	@ManyToMany(targetEntity=Role.class,cascade = CascadeType.PERSIST)
	// 维护外键
	/*name: 中间表的名称
	joinColumns: 自己在中间表的配置
	inverseJoinColumns:	对方在中间表的配置
	*/
	@JoinTable(name="sys_user_role",
			joinColumns={
					// name:自己在中间表的外键字段名
					// referencedColumnName: 指向自己的主键字段名
				@JoinColumn(name="user_id",referencedColumnName="user_id")
				},
				inverseJoinColumns={
							/*name:对方在中间表的外键字段名
							referencedColumnName:指向对方的主键字段名*/
						@JoinColumn(name="role_id",referencedColumnName="role_id")
				})
	private Set<Role> roles=new HashSet<Role>();
	
	
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_state() {
		return user_state;
	}
	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}
	
	
}
