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
public class RegistrationPage extends HttpServlet {

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
        
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String password=request.getParameter("pass");
        String conpassword=request.getParameter("conpassword");
        boolean st = false;
        try{
         Connection con= null;
         Class.forName("com.ibm.db2.jcc.DB2Driver");
         con=DriverManager.getConnection("jdbc:db2://172.17.0.142:50001/itgdb", "mssusr6", "miracle6");
            PreparedStatement pstmt=con.prepareStatement("insert into Registration values(?,?,?,?)");
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, password);
                pstmt.setString(4, conpassword);
                
                int c = pstmt.executeUpdate();
                System.out.println(c);

        
        }catch(Exception e){
            
        }

    
    
    
    
    
    
    }
}
