import java.io.*;
import java.sql.*;

import javax.sql.*;

import jakarta.servlet.*;

import jakarta.servlet.http.*;

 

public class servlet extends HttpServlet{

 

    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException

    {  

      try

        {

         
int a=0,b=0,c=0,d=0,e=0;
String m=null,n=null,k=null;

       

 
String cssTag="<link rel='stylesheet' type='text/css' href='css/style.css'>";
// String js="<script language='text/javascript' src='scripts/function.js'>";
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        String rollno=req.getParameter("rollno");

        // String name = req.getParameter("name");

        

       //out.println("working1");

        Class.forName("oracle.jdbc.OracleDriver");

        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe","system","bhumesh5678");

        PreparedStatement ps = con.prepareStatement("select * from student1 where rollno=?");

        //out.println("working2");

       
        ps.setString(1,rollno);
        //out.println("working4");
        // ps.setString(3,branch);

         ResultSet rs = ps.executeQuery();

        //ps.executeUpdate();
        //out.println("updated successfully");

        //  out.println(i+"inserted successfully");
while(rs.next())
{
    n=rs.getString(1);
    m=rs.getString(2);
    k=rs.getString(3);
    a=rs.getInt(4);
    b=rs.getInt(5);
    c=rs.getInt(6);
    d=rs.getInt(7);
    e=rs.getInt(8);

    // out.println(n+""+m+""+k);
    // out.println("updated successfully");
}

if(rollno.equals(k))
{
    // out.println("rollno= "+n+" name= "+m+" branch= "+k);
    out.println("<html>");
    out.println("<head><title>memo</title>"+cssTag+"</head>");
    out.print("<body>");
    out.print("<table>");
    out.print("<tr><td>name</td><td>"+n+"</td></tr>");
    out.print("<tr><td>branch</td><td>"+m+"</td></tr>");
    out.print("<tr><td>rollno</td><td>"+k+"</td></tr>");
    out.print("<tr><td>m1</td><td>"+a+"</td></tr>");
    out.print("<tr><td>phy</td><td>"+b+"</td></tr>");
    out.print("<tr><td>chem</td><td>"+c+"</td></tr>");
    out.print("<tr><td>eng</td><td>"+d+"</td></tr>");
    out.print("<tr><td>java</td><td>"+e+"</td></tr>");
    out.println("</table>");
    out.print("<button onclick='printFunction()'>print</button>");
    // out.print(js);
    out.print("<script>function printFunction(){window.print();}</script>");
    out.println("</body></html>");

}
else{
  
  res.sendRedirect("student.html");
  
}
     

 

          con.close();

        }catch(SQLException e)

        {

          System.err.format("sql state %s\n%S",e.getSQLState(),e.getMessage());

        }

       catch(Exception e)

       {System.out.print(e);}

 

    }

}

