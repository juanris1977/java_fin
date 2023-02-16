package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import model.Pedido;
import service.locator.ConectionLocator;

public class PedidosServiceImpl1 implements PedidosService {
	@Override			
	public void guardarPedido (Pedido pedido) {
		
			try(Connection con = ConectionLocator.getConnection();){
				con.setAutoCommit(false);  // Para que no se haga autocommit
				String sql="insert into pedidos(producto,unidades,fecha, tienda) values(?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(sql);
				
					ps.setString(1, pedido.getProducto());
					ps.setInt(2, pedido.getUnidades());
					ps.setDate(3,  Date.valueOf(LocalDate.now()));  // hay que transformar LocalDate a sqlDate
					ps.setString(4, pedido.getTienda());
				
					ps.execute();
			
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
}

