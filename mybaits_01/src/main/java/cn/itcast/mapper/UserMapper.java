package cn.itcast.mapper;

import org.apache.ibatis.annotations.Select;

import cn.itcast.po.User;

public interface UserMapper {
	
	//根据用户Id查询用户
	User queryUserById(Integer id);
	
	//添加用户
	void insertUser(User user);
	
	//根据用户
	@Select("select * from `user` where id=#{id}")
	User queryUserById_01(Integer id);
}
