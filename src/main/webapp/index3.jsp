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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Nuevo Producto</title>
</head>
<body>
    <%@ page import="Controllers.EscribirArchivo"%>
    <h1>Registrar Nuevo Producto</h1>
    <form action="EscribirArchivo" method="POST">
        <table cellspacing="3" cellpadding="3" border="1">
            <tr>
                <td align="right">Nombre del producto:</td>
                <td><input type="text" name="nombre"></td>
            </tr>
            <tr>
                <td align="right">Descripción:</td>
                <td><input type="text" name="descripcion"></td>
            </tr>
            <tr>
                <td align="right">Precio:</td>
                <td><input type="text" name="precio"></td>
            </tr>
        </table>
        <br>
        <input type="reset" value="Borrar"> <input type="submit" value="Enviar">
    </form>
</body>
</html>