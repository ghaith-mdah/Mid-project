package unitTests;


import gui.ConnectFormController;
import gui.LoginScreenController;
import logic.Request;
import logic.User;

public class realLogin implements ILogIn{

	@Override
	public String GetUserWithPassword(User u) {
		// TODO Auto-generated method stub
		ConnectFormController.chat.accept(new Request("Login", u));
		return LoginScreenController.role;
	}

}
