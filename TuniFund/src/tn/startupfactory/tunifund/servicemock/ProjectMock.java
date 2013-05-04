package tn.startupfactory.tunifund.servicemock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import tn.startupfactory.tunifund.service.ProjectService;
import tn.startupfactoy.tunifund.domain.Project;
import tn.startupfactoy.tunifund.domain.Theme;
import tn.startupfactoy.tunifund.domain.User;

public class ProjectMock implements ProjectService {

	private static ProjectMock PROJECTMOCK;
	private UserMock userMock;
	List<Project> projects; 
	
	
	private ProjectMock() {
		userMock = UserMock.getInstance();
		projects = new ArrayList<Project>();
		projects.add(new Project("Projet1", "Blablabladescription", 300.000, 300, Theme.SCIENCE, userMock.getById(1), "Qayrawen"));
		projects.add(new Project("Projet2", "Blablabladescription2", 300.000, 300, Theme.TECHNOLOGY, userMock.getById(1), "Gabes"));
		projects.add(new Project("Projet3", "Blablabladescription3", 300.000, 300, Theme.ART, userMock.getById(2), "Tataouine"));
	}

	@Override
	public void add(int idFounder, Project project) {
		User founder = userMock.getById(idFounder);
		founder.getFundedProjects().add(project);
		project.setFounder(founder);
		projects.add(project);
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void donate(int idDonator, int idProject, double amount) {
		User donator = userMock.getById(idDonator);
		//project.pledged w user.account////////////////////////////////////////////////
		Project project = getById(idProject);
		project.getDonators().put(donator, amount);
		donator.getDonatedProjects().put(project, amount);
		

	}

	@Override
	public Project getById(int id) {
		for (Project project : projects) {
			if(id == project.getId()){
				return project;
			}
		}
		return null;
	}

	@Override
	public List<Project> getNewProjects() {
		Date date = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(date); 
		c.add(Calendar.DATE, -1);
		date = c.getTime();
		List<Project> newProject = new ArrayList<Project>();
		for (Project project : projects) {
			if(project.getDate().after(date)){
				newProject.add(project);
			}
		}
		return newProject;
	}

	@Override
	public List<Project> findAll() {
		return projects;
	}

	public static ProjectMock getInstance(){
		if(PROJECTMOCK == null){
			PROJECTMOCK = new ProjectMock();
		}
		return PROJECTMOCK;
	}
}
