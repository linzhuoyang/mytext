package cn.itcast.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.po.User;

public class Test01 {
	
	
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
	public void queryUserById() {
		//创建sqlSession,true:为自动提交事务，默认为false
		SqlSession sqlSession = sqlSessionFactory .openSession(true);
		User user = sqlSession.selectOne("test.queryUserById", 1);
		System.out.println(user);
		
		//关闭资源
		sqlSession.close();
	}
	
	@Test
	public void queryUserLikeUserName() {
		//创建sqlSession,true:为自动提交事务，默认为false
		SqlSession sqlSession = sqlSessionFactory .openSession(true);
		List<User> list = sqlSession.selectList("test.queryUserLikeUserName", "小");
		for (User user : list) {
			System.out.println(user);
		}
		
		//关闭资源
		sqlSession.close();
	}
	
	@Test
	public void insertUser() {
		//创建sqlSession,true:为自动提交事务，默认为false
		SqlSession sqlSession = sqlSessionFactory .openSession(true);
		int i = sqlSession.insert("test.insertUser", new User(null, "小名", new Date(), "1", "南沙"));
		System.out.println(i);
		
		//关闭资源
		sqlSession.close();
	}
	
	@Test
	public void updateUser() {
		//创建sqlSession,true:为自动提交事务，默认为false
		SqlSession sqlSession = sqlSessionFactory .openSession(true);
		int i = sqlSession.update("test.updateUser", new User(35, "小花", null, "1", "广州"));
		System.out.println(i);
		
		//关闭资源
		sqlSession.close();
	}
	
	@Test
	public void deleteUserById() {
		//创建sqlSession,true:为自动提交事务，默认为false
		SqlSession sqlSession = sqlSessionFactory .openSession(true);
		int i = sqlSession.delete("test.deleteUserById", 35);
		System.out.println(i);
		
		//关闭资源
		sqlSession.close();
	}
	
	@Test
	public void nextId() {
		//创建sqlSession,true:为自动提交事务，默认为false
		SqlSession sqlSession = sqlSessionFactory .openSession(true);
		int i = sqlSession.insert("text.nextId");
		System.out.println(i);
		
		//关闭资源
		sqlSession.close();
	}

}
