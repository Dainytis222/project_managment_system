package org.example.service;

import java.util.List;

import org.example.domain.Project;
import org.example.repository.ProjectRepository;

public class ProjectService {

  public List<Project> getAllProjects() {
    ProjectRepository projectRepository = new ProjectRepository();
    return projectRepository.findAll();
  }
}
