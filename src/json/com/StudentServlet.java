package json.com;
//http://android-zhang.iteye.com/blog/1734805
/**
 * Created by Lin on 2015/4/29.
 */
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class StudentServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        firstMethod(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    // ======第一种方法============
    public void firstMethod(HttpServletRequest request,
                            HttpServletResponse response) {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try {
            PrintWriter out = response.getWriter();
            // List<Person> persons = JsonService.getListPerson();//
            // 返回JsonService的?据
            List<Person> persons = new ArrayList<Person>();
            for (int i = 0; i < 5; i++) {
                Person p = new Person("?" + i + "?", "北京" + i + "?", i);



                persons.add(p);

            }

            StringBuffer sb = new StringBuffer();// ?据?存
            sb.append('[');

            for (Person person : persons) {// person.getName(),person.getAddress()?得姓名，地址，一些符????char
                // ?定?出=> {"name":"姓名","address":"地址","age":年?},
                sb.append('{').append("\"name\":").append(
                        "\"" + person.getName() + "\"").append(",");
                sb.append("\"address\":").append(
                        "\"" + person.getAddress() + "\"").append(",");
                sb.append("\"age\":").append(person.getAge());
                sb.append('}').append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(']');
            out.write(new String(sb));
            out.flush();
            out.close();// ??

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // ======第二种方法============
    public void secondMethod(HttpServletRequest request,
                             HttpServletResponse response) {
        // ?置??格式
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("pargma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            List<Person> persons = new ArrayList<Person>();
            for (int i = 0; i < 5; i++) {
                Person p = new Person("?小胖" + i + "?", "北京昌平?" + i + "?", i);

                List<Student> list = new ArrayList<Student>();
                for(int j = 0;j<2;j++){
                    Student mStudent = new Student("??小和尚","清?大?",20);
                    list.add(mStudent);
                }
                p.setList(list);


                persons.add(p);
            }
            Gson gson = new Gson();
            String reslut = gson.toJson(persons);
            System.out.println("reslut:" + reslut);
            out.println(reslut);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}