package tn.startupfactory.tunifund.service;

import java.util.List;

import tn.startupfactoy.tunifund.domain.User;

public interface UserService {

	public long add(User user);
	public void remove(int id);
	public User login(String cin, String password);
	public User getById(int id);
	public void debit(int id, double amount) throws Exception;
	public void credit(int id, double amount);
	public List<User> findAll();
}
