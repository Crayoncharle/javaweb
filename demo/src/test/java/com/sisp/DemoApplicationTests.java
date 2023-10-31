package com.sisp;

import com.sisp.common.utils.UUIDUtil;
import com.sisp.dao.UserEntityMapper;
import com.sisp.dao.entity.UserEntity;
import com.sisp.service.UserService;
import com.sisp.dao.ProjectEntityMapper;
import com.sisp.dao.entity.ProjectEntity;
import com.sisp.service.ProjectService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;


import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.io.IOException;

import java.io.InputStream;
import java.util.List;
import org.apache.log4j.Logger;

//@SpringBootTest
class DemoApplicationTests {
//    @Test
//    void contextLoads() {

	//    }
	Logger log = Logger.getLogger(DemoApplicationTests.class);
	//@Test
	public void queryUserList() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
		//调用userMapper的方法
		UserEntity userEntity = new UserEntity();
		List<UserEntity> list = userEntityMapper.queryUserList(userEntity);
		if(CollectionUtils.isEmpty(list)){
			// 记录error级别的信息
		}else{
			System.out.println(list);
			// 记录info级别的信息
			log.info(">>queryUserList用户列表查询测试成功");
		}
	}

	//@Test
	public void selectUserInfo() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
		//调用userMapper的方法
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername("admin");
		userEntity.setPassword("123");
		List<UserEntity> list = userEntityMapper.selectUserInfo(userEntity);
		if(CollectionUtils.isEmpty(list)){
			// 记录error级别的信息
		}else{
			System.out.println(list);
			// 记录info级别的信息
			log.info(">>qselectUserInfo用户登录测试成功");
		}
	}

	//@Test
	public void insert() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
		//调用userMapper的方法
		UserEntity userEntity = new UserEntity();
		userEntity.setId(UUIDUtil.getOneUUID());
		userEntity.setStatus("1");
		userEntity.setUsername("LS");
		userEntity.setPassword("123");
		int i = userEntityMapper.insert(userEntity);
		if(i==0){
			// 记录error级别的信息
		}else{
			System.out.println(i);
			// 记录info级别的信息
			log.info(">>insert用户插入测试成功");
		}
	}

	//@Test
	public void deleteUserByName() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserEntityMapper userEntityMapper = sqlSession.getMapper(UserEntityMapper.class);
		//调用userMapper的方法
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername("aaaaa");
		int i = userEntityMapper.deleteUserByName(userEntity);
		if(i==0){
			// 记录error级别的信息
		}else{
			System.out.println(i);
			// 记录info级别的信息
			log.info(">>delete用户删除测试成功");
		}
	}
	//@Test
	public void queryProjectList() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
		//调用userMapper的方法
		ProjectEntity projectEntity = new ProjectEntity();
		List<ProjectEntity> list = projectEntityMapper.queryProjectList(projectEntity);
		if(CollectionUtils.isEmpty(list)){
			// 记录error级别的信息
		}else{
			System.out.println(list);
			// 记录info级别的信息
			log.info(">>queryProjectList项目列表查询测试成功");
		}
	}

	//@Test
	public void modifyProjectInfo() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
		//调用userMapper的方法
		ProjectEntity projectEntity = new ProjectEntity();
		projectEntity.setProjectname("aaaaa");
		int i = projectEntityMapper.deleteProjectById(projectEntity);
		if(i==0){
			// 记录error级别的信息
		}else{
			System.out.println(i);
			// 记录info级别的信息
			log.info(">>delete项目删除测试成功");
		}
	}

	//@Test
	public void selectProjectInfo() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
		//调用userMapper的方法
		ProjectEntity projectEntity = new ProjectEntity();
		//测试时对方法进行修改
		projectEntity.setProjectname("admin");
		projectEntity.setPassword("123");
		List<ProjectEntity> list = projectEntityMapper.selectProjectInfo(projectEntity);
		if(CollectionUtils.isEmpty(list)){
			// 记录error级别的信息
		}else{
			System.out.println(list);
			// 记录info级别的信息
			log.info(">>qselectProjectInfo项目选择测试成功");
		}
	}

	//@Test
	public void insert1() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
		//调用userMapper的方法
		ProjectEntity projectEntity = new ProjectEntity();
		projectEntity.setId(UUIDUtil.getOneUUID());
		projectEntity.setStatus("1");
		projectEntity.setProjectname("LS");
		projectEntity.setPassword("123");
		int i = projectEntityMapper.insert(projectEntity);
		if(i==0){
			// 记录error级别的信息
		}else{
			System.out.println(i);
			// 记录info级别的信息
			log.info(">>insert项目插入测试成功");
		}
	}

	//@Test
	public void deleteProjectById() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		ProjectEntityMapper projectEntityMapper = sqlSession.getMapper(ProjectEntityMapper.class);
		//调用userMapper的方法
		ProjectEntity projectEntity = new ProjectEntity();
		projectEntity.setProjectname("aaaaa");
		int i = projectEntityMapper.deleteProjectById(projectEntity);
		if(i==0){
			// 记录error级别的信息
		}else{
			System.out.println(i);
			// 记录info级别的信息
			log.info(">>delete项目删除测试成功");
		}
	}


}
