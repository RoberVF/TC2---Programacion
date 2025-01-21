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
@WebServlet(name = "ReservarServlet", urlPatterns = {"/ReservarServlet"})
public class ReservarServlet extends HttpServlet {

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

        String nombreCliente = request.getParameter("nombre_cliente");
        String fechaClase = request.getParameter("fecha_clase");
        String tipoClase = request.getParameter("tipo_clase");

        try {
            // Agregamos el driver para poder conectar java con mysql manualmente
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Primero nos conectamos a la db
            String DB_URI_DIRECTION = "jdbc:mysql://localhost:3306/trabajocurso2_robertomoralesfumero_ddbb";
            String DB_URI_CONFIG = "useSSL=false&allowPublicKeyRetrieval=true&zeroDateTimeBehavior=CONVERT_TO_NULL";
            String DB_URI = DB_URI_DIRECTION + "?" + DB_URI_CONFIG;
            Connection conexion = DriverManager.getConnection(DB_URI, "root", "");

            // Buscamos el id_cliente mediante el nombre del cliente del front
            String query = "SELECT id_cliente FROM clientes WHERE nombre = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, nombreCliente);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                int idCliente = result.getInt("id_cliente");
                
                // Metemos lo que nos llega del front en la tabla 'reservas'
                String sql = "INSERT INTO reservas (id_cliente, fecha_clase, tipo_clase) VALUES (?, ?, ?)";
                PreparedStatement stmt = conexion.prepareStatement(sql);
                stmt.setInt(1, idCliente);
                stmt.setString(2, fechaClase);
                stmt.setString(3, tipoClase);
                stmt.executeUpdate();
                
                System.out.println("Reserva registrada correctamente :)");
            } else {
                System.out.println("No se ha encontrado cliente con ese nombre :(");
            }

            // Cerramos la conexion con la db
            conexion.close();

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al registrar la reserva");
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
