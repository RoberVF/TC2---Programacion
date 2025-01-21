/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author rober
 */
@WebServlet(name = "RegistrarServlet", urlPatterns = {"/RegistrarServlet"})
public class RegistrarServlet extends HttpServlet {

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
        
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        
        try {
            // Agregamos el driver para poder conectar java con mysql manualmente
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Primero nos conectamos a la db
            String DB_URI_DIRECTION = "jdbc:mysql://localhost:3306/trabajocurso2_robertomoralesfumero_ddbb";     
            String DB_URI_CONFIG = "useSSL=false&allowPublicKeyRetrieval=true&zeroDateTimeBehavior=CONVERT_TO_NULL";
            String DB_URI = DB_URI_DIRECTION + "?" + DB_URI_CONFIG;
            Connection conexion = DriverManager.getConnection(DB_URI, "root", "");
            
            // Metemos lo que nos llega del front en la tabla 'clientes'
            String sql_query = "INSERT INTO clientes (nombre, email, telefono) VALUES (?, ?, ?)";
            PreparedStatement stmt = conexion.prepareStatement(sql_query);
            stmt.setString(1, nombre);
            stmt.setString(2, email);
            stmt.setString(3, telefono);
            stmt.executeUpdate();
            
            // Cerramos la conexion con la db
            conexion.close();
            
            System.out.println("Cliente registrado correctamente");
        } catch(Exception e){
            System.out.println("Ha ocurrido un error al insertar los datos del nuevo cliente");
            System.out.println(e);
        }
        
        // Redirigimos a la pagina principal
        response.sendRedirect("/TrabajoCurso2_RobertoMoralesFumero/index.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
