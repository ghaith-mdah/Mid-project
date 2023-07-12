package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import gui.LoginScreenController;
import logic.User;

class ClientLoginTest {
		private String expected,result;
		private LoginScreenController login;
		private stublogin stubLogIn;
		
		@BeforeEach
		void setUp() throws Exception {
			stubLogIn=new stublogin();
			login =new LoginScreenController(stubLogIn);
		}
		
		private class stublogin implements ILogIn {
			ArrayList<User> users = new ArrayList<User>();
			ArrayList<User> LoggedInUser = new ArrayList<User>();
			ArrayList<User> WaitingForApprovalUsers = new ArrayList<User>();

			public stublogin() {
				users.add(new User("gethe12", "1234"));
				users.get(0).setRole("CEO");
				users.add(new User("marks", "0000"));
				users.get(1).setRole("BM manager");
				users.add(new User("salman", "1122"));
				users.get(2).setRole("HR");
				users.add(new User("ibra", "122"));
				users.get(3).setRole("Supplier-Editor");
				users.add(new User("ibra2", "122"));
				users.get(4).setRole("Supplier-Confirmer");
				users.add(new User("tiran", "11234"));
				users.get(5).setRole("Costumer");
				LoggedInUser.add(new User("kamel", "0101"));
				WaitingForApprovalUsers.add(new User("rabi", "1111"));

			}

			@Override
			public String GetUserWithPassword(User u) {
				if(u==null)return "null user object";
				String username = u.getUsername();
				String password = u.getPassword();
				if(username==null||password==null) return "null username or password";
				for (User user : users) {
					if (user.getUsername().equals(username))
						if (user.getPassword().equals(password)) {
//							LoggedInUser.add(user);
//							users.remove(user);
							return user.getRole();
						} else
							return "Wrong Password";
				}
				for (User user : WaitingForApprovalUsers)
					if (user.getUsername().equals(username))
						return "Wait for BM approval";
					
				for (User user : LoggedInUser)
					if(user.getUsername().equals(username))
						return "You're Already logged in";
				return "Username Not Found";

			}

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
				User user=new User("salman","1122");
				String result =login.CheckUser(user);
				String Excpected ="HR";
				assertEquals(result,Excpected);
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
				User user=new User("ibra","122");
				String result =login.CheckUser(user);
				String Excpected ="Supplier-Editor";
				assertEquals(result,Excpected);
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
				User user=new User("ibra2","122");
				String result =login.CheckUser(user);
				String Excpected ="Supplier-Confirmer";
				assertEquals(result,Excpected);
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
				User user=new User("rabi","1111");
				String result =login.CheckUser(user);
				String Excpected ="Wait for BM approval";
				assertEquals(result,Excpected);
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
				User user=new User("ibra","1223");
				String result =login.CheckUser(user);
				String Excpected ="Wrong Password";
				assertEquals(result,Excpected);
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
				User user=new User("tiran","11234");
				String result =login.CheckUser(user);
				String Excpected ="Costumer";
				assertEquals(result,Excpected);
			}
			
			/**
			 * @author gethe
			 * input: username "marks" password "0000"
			 *Functionality: testing BM Manager role existing user in data base
			 *Expecting : "BM manager" String
			 **/
			@Test
			public void BMManagerUSERTest()
			{
				User user=new User("marks","0000");
				String result =login.CheckUser(user);
				String Excpected ="BM manager";
				assertEquals(result,Excpected);
			}
			/**
			 * @author gethe
			 * input: username "gethe12" password "1234"
			 *Functionality: testing CEO role existing user in data base
			 *Expecting : "BM manager" String
			 **/
			@Test
			public void CEOUSERTest()
			{
				User user=new User("gethe12","1234");
				String result =login.CheckUser(user);
				String Excpected ="CEO";
				assertEquals(result,Excpected);
			}
			/**
			 * @author gethe
			 * input: username"koko" password"koko123"
			 *Functionality: testing not existing user in data base
			 *Expecting : "Username Not Found" String
			 **/
			@Test
			public void UserNotExistTest()
			{
				User user=new User("koko","koko123");
				String result =login.CheckUser(user);
				String Excpected ="Username Not Found";
				assertEquals(result,Excpected);
			}
			/**
			 * @author gethe
			 * input: username and password null
			 *Functionality: testing user with null username and/ or null password
			 *Expecting : null 
			 **/
			@Test
			public void NullUsernameOrPasswordTest()
			{
				User user=new User(null,null);
				String result =login.CheckUser(user);
				String Excpected ="null username or password";
				assertEquals(result,Excpected);
			}
			/**
			 * @author gethe
			 * input:  null User object
			 *Functionality: testing  null User  
			 *Expecting : null 
			 **/
			@Test
			public void NullUserTest()
			{
				User user=null;
				String result =login.CheckUser(user);
				String Excpected ="null user object";
				assertEquals(result,Excpected);
			}
			/**
			 * @author gethe
			 * input: username "kamel" password "0101"
			 *Functionality: testing already logged in user in data base
			 *Expecting : "You're Already logged in" String
			 **/
			@Test
			public void AlreadyLoggedInUserTest()
			{
				User user=new User("kamel","0101");
				String result =login.CheckUser(user);
				String Excpected ="You're Already logged in";
				assertEquals(result,Excpected);
			}


}
