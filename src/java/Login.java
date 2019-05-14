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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author miracle
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
    PrintWriter pt=response.getWriter();
        String email=request.getParameter("email");
        String pass=request.getParameter("password");
        
        boolean st= false;
        try{
            Connection con=null;
         Class.forName("com.ibm.db2.jcc.DB2Driver");
        con=DriverManager.getConnection("jdbc:db2://172.17.0.142:50001/itgdb", "mssusr6", "miracle6");
            PreparedStatement pstmt=con.prepareStatement("select * from registration where email=? and password=?");
            pstmt.setString(1, email);
            pstmt.setString(2, pass);
        ResultSet rs=pstmt.executeQuery();
        st=rs.next();
        if(st)
        {
            RequestDispatcher r=request.getRequestDispatcher("Registration.html");
            r.forward(request, response);
        
        }
        else
        {
            pt.println("Login Failed check credentials");
            RequestDispatcher r=request.getRequestDispatcher("Login.html"); 
            r.include(request, response);
       
        }
        }catch(Exception e){
        
        }
            
            
            
    
}

}
