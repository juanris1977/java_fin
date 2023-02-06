<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.List , model.Curso"%>
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
	    <h2>Listado de cursos</h2>
	    <br>
	

		<a href="inicio.html"><strong>Volver a menu principal</strong></a>
		<br>
		<br>
		<br>
	    
		<%List<Curso> cursos=(List<Curso>)request.getAttribute("cursos");%>		  
		
		<table border="4" cellpadding="5">
			<tr><th><FONT SIZE=4>  Nombre  </FONT></th><th><FONT SIZE=4>  Precio  </FONT> </th><th><FONT SIZE=4>  Duración  </FONT><th><FONT SIZE=4>  Fecha inicio  </FONT></tr>
			<%for(Curso c: cursos){%>
				<tr>
					<td><center><%=c.getNombrecurso()%> </center></td>				
					<td><center><%=c.getPrecio()%> </center></td>
					<td><center><%=c.getDuracion()%> </center></td>
					<td><center><%=c.getFechainicio()%> </center></td>
							
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