package tn.startupfactory.tunifund.servicemock;

import java.util.List;
import tn.startupfactory.tunifund.service.UserService;
import tn.startupfactoy.tunifund.domain.User;

public class UserMock implements UserService {

	private static UserMock USERMOCK;
	List<User> users; 
	
	private UserMock() {
		super();
		users.add(new User("cin1", "Mariem", "Nfaiedh", "mariem@nfaiedh.com", "12345", "Tunis", "mariem"));
		users.add(new User("cin2", "Balkis", "Khouni", "balkis@khouni.com", "12345", "Tunis", "balkis"));
		users.add(new User("cin3", "Meriem", "Selmi", "meriem@selmi.com", "12345", "Tunis", "meriem"));
	}

	@Override
	public long add(User user) {
		for (User userIt : users) {
			if(userIt.getCin().equals(userIt.getCin())){
				return -1;
			}
		}
		users.add(user);
		return 1; 
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User login(String cin, String password) {
		for (User user : users) {
			if(cin.equals(user.getCin()) && password.equals(user.getPassword())){
				return user;
			}
		}
		return null;   ///////////////////////////////////////////////////////////////
	}

	@Override
	public User getById(int id) {
		for (User user : users) {
			if(id == user.getId()){
				return user;
			}
		}
		return null; ////////////////////////////////////////////////////////////////
	}

	@Override
	public void debit(int id, double amount) {
		User user = getById(id);
		if(user != null ){
			if(user.getAccount() > amount){
				user.setAccount(user.getAccount() - amount);
			}else{
				//////////////////////////////////////////
			}
		}
	}

	@Override
	public void credit(int id, double amount) {
		User user = getById(id);
		if(user != null ){
			user.setAccount(user.getAccount() + amount);
		}
	}

	@Override
	public List<User> findAll() {
		return users;
	}

	public static UserMock getInstance(){
		if(USERMOCK == null){
			USERMOCK = new UserMock();
		}
		return USERMOCK;
	}
}
