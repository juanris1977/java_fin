<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List ,model.Alumno, model.Curso "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="AltaAlumnoCursoServlet">
		<h2>¿En qué curso quieres dar de alta el nuevo alumno?</h2>
		<br><br><br>		
		<select name="curso">
		    <option value="selecciona">Selecciona un curso</option>
				<%List<Curso> nombres=(List<Curso>)request.getAttribute("cursos");
				for(Curso s:nombres){%>
					<option value = "<%=s.getIdcurso()%>"><%=s.getNombrecurso()%></option>
				<%}%>
		</select>
			<br><br><br><br><br><br><br><br>
			<h3> Datos del nuevo alumno</h3>
			<br><br>
			Dni:<input type="text" name="dni"><br><br>
			Nombre:<input type="text" name="nombre"><br><br>
			Email:  <input type="email" name="email"><br><br>
			Nota:  <input type="text" name="nota"><br><br>
			<input type="submit" value="Grabar">
		</form>
	
	
	</center>
	
</body>
</html>