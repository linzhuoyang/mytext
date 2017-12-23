package cn.itcast.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mapper.UserMapper;
import cn.itcast.po.User;

public class Test02 {
	
	private SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void init() {
		InputStream inputStream = null;
		try {
			//加载配置文件
			inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
			//读取配置文件的内容
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			sqlSessionFactory = builder.build(inputStream);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test1() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.queryUserById(1);
		System.out.println(user);
	}
	
	@Test
	public void test2() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		mapper.insertUser(new User(null, "小李", new Date(), "1", "中国"));
	}
	
	@Test
	public void test3() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.queryUserById_01(1);
		System.out.println(user);
	}

}
