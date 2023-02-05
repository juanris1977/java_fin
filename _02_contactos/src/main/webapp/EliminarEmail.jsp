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
		<form action="EliminarEmailServlet">
		<h2>¿Qué contacto deseas modificar?</h2>
		<br><br><br>		
		<select name="modificar">
		    <option value="selecciona">Selecciona un contacto</option>
				<%List<Contacto> nombres=(List<Contacto>)request.getAttribute("nombres");
				for(Contacto s:nombres){%>
					<option value = "<%=s.getNombre()%>"><%=s.getNombre()+"-->"+s.getEmail()%></option>
				<%}%>
		</select>
			<br><br><br><br><br>
			 Introduce el nuevo email:  <input type="email" name="email"><br>
			
			<br><br><br><br><br><br>
			<input type="submit" value="Modificar email del contacto">
		</form>
	
	
	</center>

</body>
</html>