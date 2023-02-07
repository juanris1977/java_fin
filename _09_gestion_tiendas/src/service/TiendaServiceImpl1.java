package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;



import model.Pedido;
import service.locator.ConnectionLocator;

public class TiendaServiceImpl1 implements TiendaService{


	@Override
	public void guardarPedido (List<Pedido> pedidos) {		
			
			try(Connection con = ConnectionLocator.getConnection();){
				con.setAutoCommit(false);  // Para que no se haga autocommit
				String sql="insert into pedidos(producto,unidades,fecha) values(?,?,?)";
				PreparedStatement ps=con.prepareStatement(sql);
				for (Pedido pedido:pedidos) {	
					ps.setString(1, pedido.getProducto());
					ps.setInt(2, pedido.getUnidades());
					ps.setDate(3, Date.valueOf(pedido.getFecha()));  // hay que transformar LocalDate a sqlDate
					ps.execute();
				}
				con.commit();  //  Se confirman a la base de datos todos a la vez
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
	}
	

	@Override
	public void guardarPedido(Pedido pedido) {
		try(Connection con = ConnectionLocator.getConnection();){
			String sql="insert into pedidos(producto,unidades,fecha) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, pedido.getProducto());
			ps.setInt(2, pedido.getUnidades());
			ps.setDate(3, Date.valueOf(pedido.getFecha()));  // hay que transformar LocalDate a sqlDate
			ps.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public List<Pedido> leerPedidos (String rutafichero) {
		
		Path dir= Path.of(rutafichero);
		
		try {
			return Files.lines(dir)  // Stream con las lineas del fichero
					    .map( c -> {
					                String [] datos = c.split("[,]");
			                        return new Pedido (0, 
			                        				   datos[0], 
			                        				   Integer.parseInt(datos[1]), 
			                        				   LocalDate.parse(datos[2]));							
					               })    // Stream de pedidos
					    .toList();
		} catch (IOException e) {			
			e.printStackTrace();
			return List.of();
		}
		
		
	}
}




























