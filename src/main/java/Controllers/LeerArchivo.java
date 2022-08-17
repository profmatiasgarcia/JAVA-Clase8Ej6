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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LeerArchivo extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Productos registrados</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Listado de productos</h1>");
        out.println("<table cellspacing=\"3\" cellpadding=\"3\" border=\"1\">");
        out.println("<tr>");
        out.println("<td align=\"center\">Nombre del producto</td>");
        out.println("<td align=\"center\">Descripción</td>");
        out.println("<td align=\"center\">Precio Unitario</td>");
        out.println("</tr>");
        try {
            String path = request.getServletContext().getRealPath("") + "WEB-INF/productos.txt";
            File archivo = new File(path);
            FileReader fr = new FileReader(archivo);
            BufferedReader reader = new BufferedReader(fr);
            String linea = null;
            String[] tokensLinea = null;
            String nom;
            String desc;
            String pre;
            linea = reader.readLine();
            while (linea != null) {
                tokensLinea = linea.split(",");
                nom = tokensLinea[0];
                desc = tokensLinea[1];
                pre = tokensLinea[2];
                //out.println("<p>Producto: " + nom + " Descripción: " + desc + " Precio: " + pre + "</p>");

                out.println("<tr>");
                out.println("<td>" + nom + "</td>");
                out.println("<td>" + desc + "</td>");
                out.println("<td align=\"right\">" + pre + "</td>");
                out.println("</tr>");
                
                linea = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            out.println("<h1>Hubo problemas cursando su solicitud.</h1>" + "<br><h3>Por favor, inténtelo otra vez.</h3>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.close();
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
        processRequest(request, response);

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
