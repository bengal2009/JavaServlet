package lin.com;

import java.io.PrintWriter;

import java.sql.*;

import java.util.*;


/**
 * Created by Lin on 2015/4/27.
 * http://caoyu-google.iteye.com/blog/2008327
 */
public class JsonService {
    public static List<Person> getListPerson(){



        String a,b,allString ="";
        int c = 0;

        List<Person> mLists = new ArrayList<Person>();

//      List<Person> mLists = new ArrayList<Person>();

//      mLists.add(new Person(“??”, “北京”, 20));

        System.out.println(mLists);

        try {

            Class.forName("com.mysql.jdbc.Driver");//?接?据?
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/json", "root" , "123456");

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from people");//遍??据?



            Person p = null;



            while(rs.next())

            {



                System.out.println(rs.getString(1) + "\t"

                        + rs.getString(2) + "\t"

                + rs.getInt(3));

                a = rs.getString(1);

                b = rs.getString(2);

                c = rs.getInt(3);



                mLists.add(new Person(a, b, c));//添加到List中

            }

            System.out.println(mLists);



        }catch(Exception e){

            System.out.println(e);

            e.printStackTrace();

            return mLists;

        }

//      finally{

//          return mLists;

//      }

        System.out.println(mLists);

        return mLists;



    }

    //??用主函?

    public static void main(String[] args) throws Exception

    {

        String str[] = null;



        JsonService con = new JsonService();

        List<Person> temp = con.getListPerson();



//      System.out.println(temp.);



//      str = temp.split(” “);

//      for(int i = 0 ; i < str.length ; i++){

//          System.out.println(str[i]);

//      }

//      System.out.println(str.length);

    }



}
