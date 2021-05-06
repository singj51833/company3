package Dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import Model.member;

public class memberDao implements implDao{

	public static void main(String[] args) throws IOException {
		/*SqlSession session = implDao.getDB();
		
		//query系列
		//statement內要放的是 xml內的id名稱 讓他可以找到 
		List<Object> list = session.selectList("select2");
		member[] M = list.toArray(new member[list.size()]);
		
		List<member> l = session.selectList("select");
		for(member m :M) {
			System.out.println(m.getId()+" "+m.getName());
		}
		
		//新增
		member m = new member("pgo","ggg","789557","lorem20","lorem",false);
		new memberDao().add(m);
		*/
		
		//更新
		/*List<Object> list = new memberDao().queryId(3);
		member[] m = list.toArray(new member[list.size()]);
		m[0].setName("Hello");
		m[0].setUsername("world");
		new memberDao().update(m[0]);
		*/
		System.out.println(login("dddd","dddd"));
		//System.out.println(implDao.a1);
		
	}

	@Override
	public void add(Object o) throws IOException {
		SqlSession se = implDao.getDb();
		se.insert("Model.memberMapper.add", o);
		se.commit();//如果有變動到資料庫 都需要commit
	}
	
	@Override
	public List<Object> queryAll() throws IOException {
		SqlSession session = implDao.getDb();
		List<Object> l = session.selectList("Model.memberMapper.select");
		return l;
	}
	
	@Override
	public List<Object> queryAll2(String msg) throws IOException {
		SqlSession session = implDao.getDb();
		List<Object> l = session.selectList("Model.memberMapper.select2");
		return l;
	}

	@Override
	public List<Object> queryId(Integer id) throws IOException {
		SqlSession session = implDao.getDb();
		List<Object> l = session.selectList("Model.memberMapper.selectId",id);
		return l;
	}


	@Override
	public void update(Object o) throws IOException {
		SqlSession session=implDao.getDb();
		session.update("Model.memberMapper.update", o);
		session.commit();
		
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		SqlSession session=implDao.getDb();	
		session.delete("Model.memberMapper.delete", id);
		session.commit();
	}
	
	public static List<Object> login(String username,String password) throws IOException
	{
		SqlSession session=implDao.getDb();
		Map<String,Object> m=new HashMap();
		m.put("username", username);
		m.put("password", password);
		List<Object> l=session.selectList("Model.memberMapper.login", m);	
		return l;	
	}
	
	

}
