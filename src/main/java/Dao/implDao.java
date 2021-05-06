package Dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Factory.SpF2;

public interface implDao {
	static ApplicationContext a1=new ClassPathXmlApplicationContext("SpF1.xml");
	static ApplicationContext a2=new AnnotationConfigApplicationContext(SpF2.class);
	
	static SqlSession getDb() throws IOException
	{
		InputStream res=Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf=new SqlSessionFactoryBuilder().build(res);
		SqlSession session=sf.openSession();
		
		return session;
	}
	
	//新增
	void add(Object o) throws IOException;
	
	//刪除
	void delete(Integer id) throws Exception;
	
	//修改
	public void update(Object o) throws IOException;
	
	
	//查詢 
	List<Object> queryAll() throws IOException;
	List<Object> queryAll2(String msg) throws IOException;
	List<Object> queryId(Integer id) throws IOException;
}
