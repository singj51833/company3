package Factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Dao.memberDao;
import Dao.porderDao;
import Model.member;
import Model.porder;

@Configuration
public class SpF2 {
	@Bean("m")
	public member getM()
	{
		member m=new member();
		m.setName("abc");
		m.setUsername("teacher");
		m.setPassword("123");
		return m;
	}
	@Bean(name="p")
	public porder getP()
	{
		return new porder();
	}
	
	@Bean(name="md")
	public memberDao getMd()
	{
		return new memberDao();
	}
	
	@Bean(name="pd")
	public porderDao getPd()
	{
		return new porderDao();
	}
	
	public Fact getF() {
		return new Fact(getM(),getP(),getMd(),getPd());
	}
}
