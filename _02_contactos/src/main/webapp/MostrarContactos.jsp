<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.List ,model.Contacto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	table {
	  font-family: arial, sans-serif;
	  border-collapse: collapse;
	  width: 60%;
	}
	
	
	tr:nth-child(even) {
	  background-color: #dddddd;
	}
</style>
<body>
<center>
		
		<br>
		<br>
	    <br>
	    <h2>Listado de contactos</h2>
	    <br>
	

		<a href="inicio.html"><strong>Volver a menu principal</strong></a>
		<br>
		<br>
		<br>
	    
		<%List<Contacto> contactos=(List<Contacto>)request.getAttribute("nombres");%>		  
		
		<table border="4" cellpadding="5">
			<tr><th><FONT SIZE=4>  Nombre  </FONT></th><th><FONT SIZE=4>  Email  </FONT> </th><th><FONT SIZE=4>  Edad  </FONT></tr>
			<%for(Contacto c: contactos){%>
				<tr>
					<td><center><%=c.getNombre()%> </center></td>					
					<td><center><%=c.getEmail()%> </center></td>
					<td><center><%=c.getEdad()%> </center></td>
							
				</tr>		
			<%}%>   
		</table>
		<br>
		<br>
	    <br>
		<br>
		<a href="inicio.html"><strong>Volver a menu principal</strong></a>
 </center>	

</body>
</html>