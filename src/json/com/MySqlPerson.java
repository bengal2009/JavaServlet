package json.com;

/**
 * Created by Lin on 2015/5/16.
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
public class MySqlPerson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        firstMethod(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
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
