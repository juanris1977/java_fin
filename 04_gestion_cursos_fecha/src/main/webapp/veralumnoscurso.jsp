<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List ,model.Alumno"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alummnos</title>
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
	    <h2>Listado de alumnos del curso de <u><%=(String)request.getAttribute("curso")%></u></h2>
	    <br>
		<br>
	    
		<%List<Alumno> alumnos=(List<Alumno>)request.getAttribute("alumnos");%>		  
		
		<table border="4" cellpadding="5">
			<tr><th><FONT SIZE=4>  Nombre  </FONT></th><th><FONT SIZE=4>  Email  </FONT> </th><th><FONT SIZE=4>  Nota  </FONT></tr>
			<%for(Alumno c: alumnos){%>
				<tr>
					<td><center><%=c.getNombre()%> </center></td>					
					<td><center><%=c.getEmail()%> </center></td>
					<td><center><%=c.getNota()%> </center></td>
							
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