package tn.startupfactoy.tunifund.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Project {

	private String id;
	private String name;
	private String description;
	private double required;
	private double funded;
	private double fundedPercentage;
	private double pledged;
	private String country;
	private Date date;
	private int daysToGo;
	private String theme;
	private List<Image> images;
	
	private User founder;
	private Map<User, Double> donators;
	
	
	
	public Project() {
		super();
	}	

	public Project(String name, double required) {
		super();
		this.name = name;
		this.required = required;
	}

	public Project(String id, String name, String description, double required,
			double funded, double pledged, String country, Date date,
			int daysToGo, String theme, List<Image> images, User founder,
			Map<User, Double> donators) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.required = required;
		this.funded = funded;
		this.pledged = pledged;
		this.country = country;
		this.date = date;
		this.daysToGo = daysToGo;
		this.theme = theme;
		this.images = images;
		this.founder = founder;
		this.donators = donators;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRequired() {
		return required;
	}

	public void setRequired(double required) {
		this.required = required;
	}

	public double getFunded() {
		return funded;
	}

	public void setFunded(double funded) {
		this.funded = funded;
	}

	public double getPledged() {
		return pledged;
	}

	public void setPledged(double pledged) {
		this.pledged = pledged;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDaysToGo() {
		return daysToGo;
	}

	public void setDaysToGo(int daysToGo) {
		this.daysToGo = daysToGo;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public List<Image> getImageLinks() {
		return images;
	}

	public void setImageLinks(List<Image> imageLinks) {
		this.images = imageLinks;
	}

	public User getFounder() {
		return founder;
	}

	public void setFounder(User founder) {
		this.founder = founder;
	}

	public Map<User, Double> getDonators() {
		return donators;
	}

	public void setDonators(Map<User, Double> donators) {
		this.donators = donators;
	}

	public double getFundedPercentage() {
		return fundedPercentage;
	}

	public void setFundedPercentage(double fundedPercentage) {
		this.fundedPercentage = fundedPercentage;
	}
	
	
	
}
