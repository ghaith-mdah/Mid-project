package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import MySQLconnection.SQLconnection;
import logic.User;

class ServerLogInTest {
	User user;
	@BeforeEach
	void setUp() throws Exception {
		try {
			SQLconnection.connectToDB("jdbc:mysql://localhost/g8_db?serverTimezone=IST","youngboy55", "root");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		user=new User("","");
	}

	
	
//	@BeforeEach
//	public void setUp()
//	{
//		
//	}
	/**
	 * @author gethe
	 * input: username"koko" password"koko123"
	 *Functionality: testing not existing user in data base
	 *Expecting : "Username Not Found" String
	 **/
	@Test
	public void UserNotExistTest()
	{
		user.setUsername("koko");
		user.setPassword("koko123");
		SQLconnection.GetLogOut(user);
		String result =SQLconnection.GetUserWithPassword(user);
		String Excpected ="Username Not Found";
		assertEquals(Excpected,result);
	}
	
	/**
	 * @author gethe
	 * input: username "gethe12" password "1234"
	 *Functionality: testing CEO role existing user in data base
	 *Expecting : "CEO" String
	 **/
	@Test
	public void CEOUSERTest()
	{
		user.setUsername("gethe12");
		user.setPassword("1234");
		SQLconnection.GetLogOut(user);
		String result =SQLconnection.GetUserWithPassword(user);
		String Excpected ="CEO";
		assertEquals(Excpected,result);
	}
	
	/**
	 * @author gethe
	 * input: username "salman" password "1122"
	 *Functionality: testing HR role existing user in data base
	 *Expecting : "HR" String
	 **/
	@Test
	public void HRUSERTest()
	{
		user.setUsername("salman");
		user.setPassword("1122");
		SQLconnection.GetLogOut(user);
		String result =SQLconnection.GetUserWithPassword(user);
		String Excpected ="HR";
		assertEquals(Excpected,result);
	}
	
	/**
	 * @author gethe
	 * input: username "ibra" password "122"
	 *Functionality: testing SupplierEditor role existing user in data base
	 *Expecting : "Supplier-Editor" String
	 **/
	@Test
	public void SupplierEditorUSERTest()
	{
		user.setUsername("ibra");
		user.setPassword("122");
		SQLconnection.GetLogOut(user);
		String result =SQLconnection.GetUserWithPassword(user);
		String Excpected ="Supplier-Editor";
		assertEquals(Excpected,result);
	}
	
	/**
	 * @author gethe
	 * input: username "ibra2" password "122"
	 *Functionality: testing SupplierConfirmer role existing user in data base
	 *Expecting : "Supplier-Confirmer" String
	 **/
	@Test
	public void SupplierConfirmerUSERTest()
	{
		user.setUsername("ibra2");
		user.setPassword("122");
		SQLconnection.GetLogOut(user);
		String result =SQLconnection.GetUserWithPassword(user);
		String Excpected ="Supplier-Confirmer";
		assertEquals(Excpected,result);
	}
	
	/**
	 * @author gethe
	 * input: username "kamel" password "0101"
	 *Functionality: testing Wait for BM approval existing user in data base
	 *Expecting : "Wait for BM approval" String
	 **/
	@Test
	public void WaitForBM_ApprovalUSERTest()
	{
		user.setUsername("kamel");
		user.setPassword("0101");
		SQLconnection.GetLogOut(user);
		String result =SQLconnection.GetUserWithPassword(user);
		String Excpected ="Wait for BM approval";
		assertEquals(Excpected,result);
	}
	/**
	 * @author gethe
	 * input: username "ibra" password "1223"
	 *Functionality: testing wrong password for existing user in data base
	 *Expecting : "Wrong Password" String
	 **/
	@Test
	public void WrongPasswordForExistingUSERTest()
	{
		user.setUsername("ibra");
		user.setPassword("1223");
		SQLconnection.GetLogOut(user);
		String result =SQLconnection.GetUserWithPassword(user);
		String Excpected ="Wrong Password";
		assertEquals(Excpected,result);
	}
	
	/**
	 * @author gethe
	 * input: username "tiran" password "11234"
	 *Functionality: testing Costumer role existing user in data base
	 *Expecting : "Costumer" String
	 **/
	@Test
	public void CostumerUSERTest()
	{
		user.setUsername("tiran");
		user.setPassword("11234");
		SQLconnection.GetLogOut(user);
		String result =SQLconnection.GetUserWithPassword(user);
		String Excpected ="Costumer";
		assertEquals(Excpected,result);
	}
	
	/**
	 * @author gethe
	 * input: username "marks" password "0000"
	 *Functionality: testing BM Manager role existing user in data base ,  testing user already logged in 
	 *Expecting : "BM manager" String in first assert ,"You're Already logged in" String in second assert 
	 **/
	@Test
	public void BMManagerUSERTest()
	{
		user.setUsername("marks");
		user.setPassword("0000");
		SQLconnection.GetLogOut(user);
		String result =SQLconnection.GetUserWithPassword(user);
		String Excpected ="BM manager";
		assertEquals(Excpected,result);
		String result1=SQLconnection.GetUserWithPassword(user);
		String Excpected1 ="You're Already logged in";
		assertEquals(Excpected1,result1);
	}
	/**
	 * @author gethe
	 * input: username and password null
	 *Functionality: testing null User
	 *Expecting : "null user object" String
	 **/
	@Test
	public void NullUSERTest()
	{
		user=null;
		String result =SQLconnection.GetUserWithPassword(user);
		String Excpected ="null user object";
		assertEquals(Excpected,result);
	}
	/**
	 * @author gethe
	 * input: username and password null
	 *Functionality: testing null User
	 *Expecting : "null user object" String
	 **/
	@Test
	public void NullUsernameOrPasswordTest()
	{
		user.setUsername(null);
		user.setPassword(null);
		String result =SQLconnection.GetUserWithPassword(user);
		String Excpected ="null username or password";
		assertEquals(Excpected,result);
	}



}
