/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author miracle
 */
public class Json extends HttpServlet {
  

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
        response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
        String name=request.getParameter("val");
       
        if(name != null){
            response.setContentType("text/html");
            response.getWriter().write(getJsonInfo(name));
                   
        
        }
    }
        public String getJsonInfo(String val){
            StringBuffer add=null;
            if(val.equals("1")){
                add = new  StringBuffer("{\"id\":{");
                add.append("\"name\":\"Giridhar\",");
                add.append("\"desg\":\"Software Trainee\",");
                add.append("}}");
                    }
            else if(val.equals("2")){
                add = new  StringBuffer("{\"id\":{");
                add.append("\"name\":\"Kishore\",");
                add.append("\"desg\":\"Software Trainee\",");
                add.append("}}");
                    }
            else{
                add = new  StringBuffer("{\"id\":{");
                add.append("\"name\":\"something else\",");
                add.append("\"desg\":\"No more Information\",");
                add.append("}}");
            }
        return add.toString();
        
        }

  
        
}
