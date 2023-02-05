<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.List ,model.Contacto "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="EliminarContactoServlet">
		<h2>¿Qué contacto deseas eliminar?</h2>
		<br><br><br>		
		<select name="eliminar">
		    <option value="selecciona">Selecciona un contacto</option>
				<%List<Contacto> nombres=(List<Contacto>)request.getAttribute("nombres");
				for(Contacto s:nombres){%>
					<option value = "<%=s.getNombre()%>"><%=s.getNombre()+"-->"+s.getEmail()%></option>
				<%}%>
		</select>
			<br><br><br><br><br><br><br><br><br><br><br>
			<input type="submit" value="Eliminar contacto">
		</form>
	
	
	</center>

</body>
</html>