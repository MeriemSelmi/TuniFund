package tn.startupfactory.tunifund.service;

import java.util.List;

import tn.startupfactoy.tunifund.domain.User;

public interface UserService {

	public void add(User user);
	public void remove(String id);
	public User login(String cin, String password);
	public User getById(String id);
	public User debit(String id, double amount);
	public User credit(String id, double amount);
	public List<User> findAll();
}
