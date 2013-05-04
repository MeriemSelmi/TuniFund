package tn.startupfactory.tunifund.servicemock;

import java.util.List;

import tn.startupfactory.tunifund.service.ProjectService;
import tn.startupfactoy.tunifund.domain.Project;
import tn.startupfactoy.tunifund.domain.User;

public class ProjectMock implements ProjectService {

	private static ProjectMock PROJECTMOCK;
	private UserMock userMock;
	List<Project> projects; 
	
	
	
	private ProjectMock() {
		super();
		userMock = UserMock.getInstance();
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
		Project project = getById(idProject);
		donator.getDonatedProjects().put(key, value)

	}

	@Override
	public Project getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getNewProjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public static ProjectMock getInstance(){
		if(PROJECTMOCK == null){
			PROJECTMOCK = new ProjectMock();
		}
		return PROJECTMOCK;
	}
}
