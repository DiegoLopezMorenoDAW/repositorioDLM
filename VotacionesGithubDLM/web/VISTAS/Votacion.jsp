<%-- 
    Document   : Votacion
    Created on : 19-dic-2015, 13:44:29
    Author     : pc
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilo.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="contenedor">
            <form name="form2" action = "../dispatcher" enctype ="multipart/form-data">
                <table>
                    <tr>
                        <th>Logo</th>
                        <th>Nombre</th>
                        <th>Elige el partido</th>
                    </tr>
                    <%
                        ArrayList sesvota = (ArrayList) session.getAttribute("partidos");
                        for (int i = 0; i < sesvota.size(); i += 3) {
                    %>
                    <tr>
                        <td>
                            <img src="
                                 <%
                                     out.print(sesvota.get(i + 1));
                                 %>
                                 " alt="logo" width="113"  height="109">
                        </td>
                        <td>
                            <%
                                out.print(sesvota.get(i));
                            %>
                        </td>
                        <td>
                            <input type="radio" name="radiob" value="<%
                                out.print(sesvota.get(i));
                                   %>">
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>
                <br/>
                <input type="submit" name="opcion" value="Votacion" />
            </form>
            <br/>
            <button value="volver" id="volver" onclick="location.href = '../index.html'">Volver</button>
        </div>
    </body>
</html>
