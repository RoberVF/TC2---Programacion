package principal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ConsultarServlet", urlPatterns = {"/ConsultarServlet"})
public class ConsultarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");

            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Document</title>");
            out.println("<script src=\"https://cdn.tailwindcss.com\"></script>");
            out.println("</head>");

            out.println("<body>");
            out.println("<div class=\"container mx-auto p-8\">");
            out.println("<div class=\"flex items-center justify-between\">");
            out.println("<h2 class=\"text-2xl font-bold mb-4\">Consultar Reservas</h2>");
            out.println("<a href=\"/TrabajoCurso2_RobertoMoralesFumero\" class=\"mr-1 text-lg\">Volver</a>");
            out.println("</div>");

            out.println("<ul class=\"grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 bg-zinc-200 p-8 rounded-xl shadow-xl gap-x-4\">");

            // Conexion a la ddbb
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String DB_URI = "jdbc:mysql://localhost:3306/trabajocurso2_robertomoralesfumero_ddbb?useSSL=false&allowPublicKeyRetrieval=true&zeroDateTimeBehavior=CONVERT_TO_NULL";
                Connection conexion = DriverManager.getConnection(DB_URI, "root", "");

                String query = "SELECT r.id_reserva, c.nombre AS cliente, c.email, c.telefono, r.fecha_clase, r.tipo_clase " +
                               "FROM reservas r " +
                               "INNER JOIN clientes c ON r.id_cliente = c.id_cliente";
                PreparedStatement statement = conexion.prepareStatement(query);
                ResultSet result = statement.executeQuery();

                // Creo los elementos de la lista
                while (result.next()) {
                    String nombre = result.getString("cliente");
                    String email = result.getString("email");
                    String telefono = result.getString("telefono");
                    String fechaClase = result.getString("fecha_clase");
                    String tipoClase = result.getString("tipo_clase");

                    out.println("<li class=\"flex justify-between p-4 bg-zinc-50 rounded-xl transition duration-500 hover:shadow-lg\">");
                    out.println("<div class=\"\">");
                    out.println("<h3 class=\"text-xl font-semibold\">" + nombre + "</h3>");
                    out.println("<div class=\"flex flex-col mt-1 text-xs text-zinc-600 gap-y-1\">");
                    out.println("<a href=\"mailto:" + email + "\">" + email + "</a>");
                    out.println("<a href=\"tel:" + telefono + "\">" + telefono + "</a>");
                    out.println("</div>");
                    out.println("</div>");
                    out.println("<div>");
                    out.println("<p class=\"text-lg font-bold text-end uppercase\">" + tipoClase + "</p>");
                    out.println("<p class=\"mt-1 text-end text-xs text-zinc-600\">" + fechaClase + "</p>");
                    out.println("</div>");
                    out.println("</li>");
                }

                conexion.close();
            } catch (Exception e) {
                out.println("<li class=\"text-red-500\">Error al obtener las reservas.</li>");
            }

            out.println("</ul>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
