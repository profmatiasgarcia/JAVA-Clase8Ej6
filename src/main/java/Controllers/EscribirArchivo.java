/**
 * @author Prof Matias Garcia.
 * <p> Copyright (C) 2022 para <a href = "https://www.profmatiasgarcia.com.ar/"> www.profmatiasgarcia.com.ar </a>
 * - con licencia GNU GPL3.
 * <p> Este programa es software libre. Puede redistribuirlo y/o modificarlo bajo los términos de la
 * Licencia Pública General de GNU según es publicada por la Free Software Foundation, 
 * bien con la versión 3 de dicha Licencia o bien (según su elección) con cualquier versión posterior. 
 * Este programa se distribuye con la esperanza de que sea útil, pero SIN NINGUNA GARANTÍA, 
 * incluso sin la garantía MERCANTIL implícita o sin garantizar la CONVENIENCIA PARA UN PROPÓSITO
 * PARTICULAR. Véase la Licencia Pública General de GNU para más detalles.
 * Debería haber recibido una copia de la Licencia Pública General junto con este programa. 
 * Si no ha sido así ingrese a <a href = "http://www.gnu.org/licenses/"> GNU org </a>
 **/
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;

public class EscribirArchivo extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EscribirArchivo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EscribirArchivo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Producto registrado</title>");
        out.println("</head>");
        out.println("<body>");
        try {
            /* El path del archivo corresponde al contexto del servlet en ejecución al cual se le agrega
            la carpeta WEB-INF y dentro el nombre del archivo con su extensión.
            Si el archivo no existe, lo crea, pero si existe continua la escritura al finalizar si tiene
            permiso para hacerlo. En MS Windows cambiar la "/" por "\\". */
            String path = request.getServletContext().getRealPath("") + "WEB-INF/productos.txt";
            File archivo = new File(path);
            FileWriter fw = new FileWriter(archivo, true);
            PrintWriter writer = new PrintWriter(fw);

            // Tomar los datos recibidos del cliente y escribirlos en el fichero.
            String nom = request.getParameter("nombre");
            String desc = request.getParameter("descripcion");
            String pre = request.getParameter("precio");
            writer.println(nom + ", " + desc + ", " + pre);

            // Cerrar el fichero
            writer.close();

            out.println("<h1>Su petición ha sido registrada</h1>");
            out.println("<a href=\"LeerArchivo\">Ver Productos registrados</a>");

        } catch (IOException e) {
            out.println("<h1>Hubo problemas cursando su solicitud.</h1>" + "<br><h3>Por favor, inténtelo otra vez.</h3>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
