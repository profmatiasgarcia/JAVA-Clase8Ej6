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
    <title>Lectura de Archivos</title>
</head>
<body>
    <%
        //String path = "/home/profmatiasgarcia/data/texto.txt";
        String path = request.getServletContext().getRealPath("") + "WEB-INF/texto.txt";
       // BufferedReader reader = new BufferedReader(new FileReader(path));
        File archivo = new File(path);
        FileReader  fr = new FileReader(archivo);
        BufferedReader reader = new BufferedReader(fr);
        
        out.println("<h1>Lectura de Archivo </h1>");
        out.println(request.getServletContext().getRealPath("") + "WEB-INF/texto.txt" + "<br><hr>");
        String line = null;
        while((line = reader.readLine()) != null)
        {
            out.println(line+"<br>");
        }
        reader.close();
    %>
</body>
</html>