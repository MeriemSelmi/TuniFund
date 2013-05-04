package tn.startupfactory.tunifund.service;

import java.util.List;

import tn.startupfactoy.tunifund.domain.Project;

public interface ProjectService {

	public void add(int idFounder, Project project);
	public void remove(int id);
	public void donate(int idDonator, int idProject, double amount) throws Exception;
	public Project getById(int id);
	public List<Project> getNewProjects();
	public List<Project> findAll();
	
}
