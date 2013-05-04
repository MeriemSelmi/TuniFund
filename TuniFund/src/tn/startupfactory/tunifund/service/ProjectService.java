package tn.startupfactory.tunifund.service;

import java.util.List;

import tn.startupfactoy.tunifund.domain.Project;

public interface ProjectService {

	public void add(String id, Project project);
	public void remove(String id);
	public Project getById(String id);
	public List<Project> getNewProjects();
	public List<Project> findAll();
	
}
