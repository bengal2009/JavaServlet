package json.com;

/**
 * Created by Lin on 2015/4/29.
 */
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String address;
    private Integer age;
    private List<Student> list = new ArrayList<Student>();
    public Person() {
        super();
    }

    public Person(String name, String address, Integer age) {
        super();
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }



}