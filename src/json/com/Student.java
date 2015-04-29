package json.com;

/**
 * Created by Lin on 2015/4/29.
 */
public class Student {
    private String name;
    private int age;
    private String school;


    public Student(){
        super();
    }
    public Student(String name,String school,int age){
        this.name = name;
        this.school = school;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }


}