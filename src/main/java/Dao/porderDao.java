package Dao;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Factory.Fact;
import Model.porder;

public class porderDao implements implDao{

	public static void main(String[] args) throws IOException {
		
		
	}

	@Override
	public void add(Object o) throws IOException {
		SqlSession se=implDao.getDb();		
		se.insert("Model.porderMapper.add", o);
		se.commit();
		
	}


	@Override
	public List<Object> queryId(Integer id) throws IOException {
		SqlSession session=implDao.getDb();		
		List<Object> l=session.selectList("Model.porderMapper.selectId", id);
		
		return l;
	}

	@Override
	public void update(Object o) throws IOException {
		SqlSession session=implDao.getDb();	
		session.update("Model.porderMapper.update", o);
		session.commit();
		
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		SqlSession session=implDao.getDb();	
		session.delete("Model.porderMapper.delete", id);
		session.commit();
		
	}

	@Override
	public List<Object> queryAll() throws IOException {
		SqlSession session=implDao.getDb();		
		List<Object> l=session.selectList("Model.porderMapper.select");
		return l;
	}

	@Override
	public List<Object> queryAll2(String msg) throws IOException {
		SqlSession session=implDao.getDb();		
		List<Object> l=session.selectList(msg);
		return l;
	}
	

}
