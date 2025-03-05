public class Main{
    public static void main(String[] args){
        Project proiect1 = new Project("proiect1", Types.THEORETICAL);
        Project proiect2 = new Project("proiect2", Types.PRACTICAL);

        Project[] p = {proiect1, proiect2};
        Student student1 = new Student("numeRandom", new Project[]{proiect1, proiect2});
        Student student2 = new Student("altNumeRandom", new Project[]{proiect1});
        System.out.println(student1.toString());
        System.out.println(student2.toString());

            }
}