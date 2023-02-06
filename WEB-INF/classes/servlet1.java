import java.io.*;
import java.sql.*;
import javax.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class servlet1 extends HttpServlet{

    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {  
      try
        {
        String dm = null;
        int dm1 = 0;
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("username");
        int pass =Integer.parseInt( req.getParameter("password"));
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe","system","bhumesh5678");
        PreparedStatement ps = con.prepareStatement("select * from emp2 where name=? and pass=?");
        ps.setString(1,name );
        ps.setInt(2,pass );
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
          dm = rs.getString(1);
          dm1 = rs.getInt(2);
        }
        if(name.equals(dm)&&pass==dm1)
        {
           res.sendRedirect("cart.html");
           //res.sendRedirect("alert.js");
        }
        else
        {
           res.sendRedirect("login.html");
        }
       }
       catch(Exception e)
       {System.out.print(e);}

    }
}
