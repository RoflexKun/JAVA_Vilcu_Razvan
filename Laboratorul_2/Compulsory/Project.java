public class Project{
    private Types projectType;
    private String projectName;

    public Project(String projectName, Types typeProject)
    {
        this.projectName = projectName;
        this.projectType = typeProject;
    }

    public String getProjectName()
    {
        return this.projectName;
    }

    public String getProjectType()
    {
        return this.projectType.name();
    }

    @Override
    public String toString(){
        return this.getProjectName() + ": " + this.getProjectType();
    }

}