package lin.com;

/**
 * Created by Lin on 2015/4/27.
 */
import java.io.IOException;

import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class JsonServlet extends HttpServlet  {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType("text/html");

        response.setCharacterEncoding("UTF-8");



        try{

            PrintWriter out = response.getWriter();

            List<Person> persons = JsonService.getListPerson();//��^JsonService��?�u



            StringBuffer sb = new StringBuffer();//?�u?�s

            sb.append('[');


            for (Person person : persons) {//person.getName(),person.getAddress()?�o�m�W�A�a�}�A�@�ǲ�????char

                //?�w?�X=> {"name":"�m�W","address":"�a�}","age":�~?},

                sb.append('{').append("\"name\":").append("\""+person.getName()+"\"").append(",");

                sb.append("\"address\":").append("\""+person.getAddress()+"\"").append(",");

                sb.append("\"age\":").append(person.getAge());

                sb.append('}').append(",");

            }

            sb.deleteCharAt(sb.length() - 1);

            sb.append(']');

                    out.write(new String(sb));

            out.flush();

            out.close();//??

        }catch(Exception e){

            System.out.println(e);

            e.printStackTrace();

        }

    }



    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);

    }






}
