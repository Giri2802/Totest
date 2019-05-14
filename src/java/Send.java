/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author miracle
 */
public class Send extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter pt=response.getWriter();
       String email=request.getParameter("email");
       String pass=request.getParameter("password");
       
       boolean st=false;
       try{
       Class.forName("com.ibm.db2.jcc.DB2Driver");
       Connection con=DriverManager.getConnection("jdbc:db2://172.17.0.142:50001/itgdb", "mssusr6", "miracle6");
       System.out.println("Database Connected");
       
        PreparedStatement stmt=con.prepareStatement("select * from registration where email=? and password=?");
        stmt.setString(1, email);
        stmt.setString(2, pass);
        ResultSet rs=stmt.executeQuery();
        st=rs.next();
        System.out.println(st);
        if(st){
//        response.sendRedirect("http://www.google.com");
        
        response.sendRedirect("Registration.html");
        }else
        {
        response.sendRedirect("http://www.google.com/error.jpg");
        }
       }catch(Exception e){}
    }
}