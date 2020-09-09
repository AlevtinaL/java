package ru.stqa.pft.testslavr;

public class ProjectData {
  private final String nameProject;
  private final String description;

  public ProjectData(String nameProject, String description) {
    this.nameProject = nameProject;
    this.description = description;
  }

  public String getNameProject() {
    return nameProject;
  }

  public String getDescription() {
    return description;
  }
}
