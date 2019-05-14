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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author miracle
 */
public class Cookie extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       try (PrintWriter out = response.getWriter()) {
            String email=request.getParameter("email");
            String pass=request.getParameter("password");
            boolean st=false;
           
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            Connection con=DriverManager.getConnection("jdbc:db2://172.17.0.142:50001/itgdb", "mssusr6", "miracle6");
            System.out.println("Database Connected");
            
            PreparedStatement stmt=con.prepareStatement("select * from registration where email=? and password=?");
          //  stmt.setString
            
       
       
       
       
       
       
       
       
       
       
       
       
       
       }catch(Exception e)
       {
           
       }
    }
}