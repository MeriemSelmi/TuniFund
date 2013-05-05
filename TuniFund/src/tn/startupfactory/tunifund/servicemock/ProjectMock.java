package tn.startupfactory.tunifund.servicemock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.util.Log;
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
		projects.add(new Project("Lithoprim", "This unit can produce prototype castings, parts metal or plastic items. The method used is the stereo lithography photocuring. The products are manufactured at the request of companies before start of production on an industrial scale.", 2057.000, 300, Theme.SCIENCE, userMock.getById(1), "Qayrawen"));
		projects.add(new Project("PhosphatFactory", "Manufacturing unit of mono and bi-calcium phosphate for medical and veterinary use and to agricultural use (feeding poultry and livestock)",2312.000, 300, Theme.TECHNOLOGY, userMock.getById(1), "Gabes"));
		projects.add(new Project("Awled Tounes Album", "The album includes children from different conservatories from southern Tunisia. Funds raised will be used for charitatives works.", 200.000, 300, Theme.ART, userMock.getById(2), "Tataouine"));
	}

	@Override
	public void add(int idFounder, Project project) {
		project.setDate(new Date());
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
	public void donate(int idDonator, int idProject, double amount) throws Exception {
		Log.d("tag", idDonator+" "+idProject);
		User donator = userMock.getById(idDonator);
		
		userMock.debit(donator.getId(), amount);
		Project project = getById(idProject);
		project.setFunded(project.getFunded() + amount);
		if(project.getFunded() > project.getRequired()){
			double profit = (project.getFunded() - project.getRequired())/100*5;
			project.setTunifundProfit(profit);
			project.setFunded(project.getFunded()-profit);
		}
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
