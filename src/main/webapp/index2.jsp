<%--
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
--%>
<%@page import="java.io.*,java.net.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Escritura de Archivos</title>
</head>
<body>
    <%
        //String path = "/home/profmatiasgarcia/data/texto.txt";
        String path = request.getServletContext().getRealPath("") + "WEB-INF/texto.txt";
        File archivo = new File(path);
        FileWriter fw = new FileWriter(archivo, true);
        PrintWriter writer = new PrintWriter(fw);
        /*En GNU Linux se requiere que el archivo tenga permisos para poder grabar en el, 
        ya que escribe Tomcat y no el user que creo dicho archivo
        Se puede dar permiso con el comando "sudo chmod 777 <<nombre archivo>>" desde la carpeta del mismo*/
        out.println("<h1>Escritura del Archivo </h1>");
        out.println(request.getServletContext().getRealPath("") + "WEB-INF/texto.txt" + "<br><hr>");
        writer.println("TW: @profmatiasg");
        writer.println("IG: profmatiasg");
        writer.close();
    %>
    <form action="index.jsp" method="GET">
        <input type="submit" value="Ver Archivo">
    </form>
</body>
</html>
