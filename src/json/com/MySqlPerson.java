package json.com;

/**
 * Created by Lin on 2015/5/16.
 */


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class MySqlPerson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        firstMethod(req, resp);
        firstMethod(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    public void SecondMethod(HttpServletRequest request,
                            HttpServletResponse response) {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        JSONObject json      = new JSONObject();
        JSONArray addresses = new JSONArray();
        JSONObject address;
        try
        {
            int count = 15;

            for (int i=0 ; i<count ; i++)
            {
                address = new JSONObject();
                address.put("CustomerName"     , "Decepticons" + i);
                address.put("AccountId"        , "1999" + i);
                address.put("SiteId"           , "1888" + i);
                address.put("Number"            , "7" + i);
                address.put("Building"          , "StarScream Skyscraper" + i);
                address.put("Street"            , "Devestator Avenue" + i);
                address.put("City"              , "Megatron City" + i);
                address.put("ZipCode"          , "ZZ00 XX1" + i);
                address.put("Country"           , "CyberTron" + i);
                addresses.add(address);
            }
            json.put("Addresses", addresses);
//            response.setContentType("application/json");

            response.getWriter().write(json.toString());
        }

        catch (Exception E)
        {

        }


    }
    public void firstMethod(HttpServletRequest request,
                            HttpServletResponse response) {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try {
            PrintWriter out = response.getWriter();
            Class.forName("com.mysql.jdbc.Driver");// ?接?据?
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/benny", "benny", "bengal");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("call lookperson;");// 遍??据?
            StringBuffer sb = new StringBuffer();// ?据?存
            sb.append('[');

            while (rs.next()) {
//                out.write(rs.getString(1)+ "\t"+rs.getString(2)+ "\t"+rs.getString(3)+ "\t");
                sb.append('{').append("\"ID\":").append(
                        "\"" + rs.getString(1) + "\"").append(",");
                sb.append("\"name\":").append(
                        "\"" + rs.getString(2) + "\"").append(",");
                sb.append("\"address\":").append(
                        "\"" + rs.getString(3) + "\"").append(",");
                sb.append("\"age\":").append(rs.getString(4));
                sb.append('}').append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(']');
            out.write(new String(sb));
            out.flush();
            out.close();


        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();

        }
    }
}
