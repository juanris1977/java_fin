<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List ,model.Curso"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta de alumnos por curso</title>
</head>
<body>
	<center>
		<form action="AlumnosCursoServlet">
		<h2>Elige un curso</h2>
		<br><br><br>		
		<select name="curso">
		    <option value="selecciona">Selecciona un curso</option>
				<%List<Curso> nombres=(List<Curso>)request.getAttribute("cursos");
				for(Curso s:nombres){%>
					<option value = "<%=s.getIdcurso()%>"><%=s.getNombrecurso()%></option>
				<%}%>
		</select>
			
			<input type="submit" value="Ver Alumnos">
		</form>
	
	
	</center>
	
</body>
</html>