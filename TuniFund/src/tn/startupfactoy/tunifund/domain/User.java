package tn.startupfactoy.tunifund.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
	
	private static int ID=0;
	private int id;
	private String cin;
	private String name;
	private String lastName;
	private String email;
	private String telephone;
	private String address;
	private String password;
	private double account;
	private List<Project> fundedProjects;
	private Map<Project, Double> donatedProjects;
	
	public User() {
		super();
		this.id = ID++;
		this.account =  100000;
		this.fundedProjects = new ArrayList<Project>();
		this.donatedProjects = new HashMap<Project, Double>();
	}
	
	public User(String cin, String name, String lastName, String email,
			String telephone, String address, String password) {
		super();
		this.id = ID++;
		this.account =  1000;
		this.cin = cin;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
		this.password = password;
		this.account = 1000;
		this.fundedProjects = new ArrayList<Project>();
		this.donatedProjects = new HashMap<Project, Double>();
	}

	public User(String cin, String password) {
		super();
		this.cin = cin;
		this.password = password;
	}

	public User(int id, String cin, String name, String lastName,
			String email, String telephone, String address, String password,
			List<Project> fundedProjects, Map<Project, Double> donatedProjects) {
		super();
		this.id = id;
		this.cin = cin;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
		this.password = password;
		this.fundedProjects = fundedProjects;
		this.donatedProjects = donatedProjects;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Project> getFundedProjects() {
		return fundedProjects;
	}

	public void setFundedProjects(List<Project> fundedProjects) {
		this.fundedProjects = fundedProjects;
	}

	public Map<Project, Double> getDonatedProjects() {
		return donatedProjects;
	}

	public void setDonatedProjects(Map<Project, Double> donatedProjects) {
		this.donatedProjects = donatedProjects;
	}

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}
	
	
	
	
}
