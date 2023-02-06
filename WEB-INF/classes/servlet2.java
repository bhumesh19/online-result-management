import java.io.*;
import java.sql.*;
import javax.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class servlet2 extends HttpServlet{

    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {  
      try
        {
         
       

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("name");
        String branch = req.getParameter("branch");
        String rollno=req.getParameter("rollno");
        int m1 = Integer.parseInt( req.getParameter("m1"));
        int phy = Integer.parseInt( req.getParameter("phy"));
        int chem =Integer.parseInt( req.getParameter("chem"));
        int eng = Integer.parseInt( req.getParameter("eng"));
        int java = Integer.parseInt( req.getParameter("java"));
        
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe","system","bhumesh5678");
        PreparedStatement ps = con.prepareStatement("insert  into student1  values (?,?,?,?,?,?,?,?)");
        ps.setString(1,name );
        ps.setString(2,branch );
        ps.setString(3,rollno);
        ps.setInt(4,m1 );
        ps.setInt(5,phy );
        ps.setInt(6,chem );
        ps.setInt(7,eng );
        ps.setInt(8,java );
         //ResultSet rs = ps.executeQuery("select * from student");
        int i=ps.executeUpdate();
         out.println("<h1>Inserted successfully</h1>");
     if(i==1)
     {
      res.sendRedirect("cart.html");
     }
     else{
      out.println("<h1>Inncorrect data</h1>");
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
 //  while(rs.next())
      //  {
      //   int dm=rs.getInt(1);
      //   String dm1=rs.getString(2);
      //   String dm2=rs.getString(3);
      //   System.out.println("roll"+dm+"name"+dm1+"branch"+dm2);
      //  }
       
            
      //    if(rollno==dm)
      //    {
      //    // res.sendRedirect("index.html");
      //       //res.sendRedirect("alert.js");
      //       out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3));
      //    }
        
         
      //  else
      //    {
      //       res.sendRedirect("cart.html");
      //    }
      //    rs.close();
      
       
