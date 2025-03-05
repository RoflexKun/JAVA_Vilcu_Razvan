public class Student{
    private String name;
    private Project[] preferences;
    private Project projectSelected;

    public Student(String name, Project[] preferences)
    {
        this.name = name;
        this.preferences = preferences;
    }

    public String getName()
    {
        return this.name;
    }

    public void setProjectedSelected(Project project){
        this.projectSelected = project;
    }


    @Override
    public String toString(){
        String outputString = "";
        outputString = outputString.concat(this.getName());
        outputString = outputString.concat(" (");
        for(int i = 0; i < this.preferences.length; i++)
        {

            if(i != this.preferences.length - 1)
            {
                outputString = outputString.concat(preferences[i].toString());
                outputString = outputString.concat(", ");
            }
            else
            {
                outputString = outputString.concat(preferences[i].toString());
            }
        }
        outputString = outputString.concat(")");
        return outputString;
    }

}