package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;

import model.Pedido;
import singleton.LoggerSingleton;

public class PedidosService {
	String dir ="C:\\ficheroseclipse\\pedidos.txt";
	SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
	
	public void nuevoPedido (String producto, Date fecha, double precio) {
		
		LoggerSingleton.getLogger().log(Level.INFO, "va a guardar "+producto);
		String datos=producto+"|"+fm.format(fecha)+"|"+precio;
		
		try (FileOutputStream fos = new FileOutputStream (dir, true);
				 PrintStream out= new PrintStream (fos);) {
			out.println(datos);
				
			}
			catch (FileNotFoundException ex) {
				ex.printStackTrace();
			}
			catch(IOException ex) {
				ex.printStackTrace();
				LoggerSingleton.getLogger().log(Level.SEVERE, "error al guardar "+producto);
			}
		
	}
	
	public Pedido pedidoReciente () {
		Pedido pedido= null;
		Date fechaReciente=new Date(0);
		
		try (FileReader    fr =new FileReader(dir);
			BufferedReader bf= new BufferedReader(fr);){
				
				String fila;      
				//Recorremos el fichero linea a linea y convertimos cada linea en un pedido
				//Despues comprobamos si ese pedido es posterior al más reciente hasta ahora
				while ((fila= bf.readLine())!=null) {
					String[] linea=fila.split("[|]");  // el separador era |  , metemos cada contenido de la linea en un array con 3 posiciones
					Pedido p = new Pedido(linea[0],fm.parse(linea[1]),Double.parseDouble(linea[2]));
					if (p.getFecha().after(fechaReciente)) {
						fechaReciente= p.getFecha();
						pedido = p;
					}
				}
			}
			catch (FileNotFoundException ex) {
				ex.printStackTrace();
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
			catch (ParseException ex) {
			ex.printStackTrace();
			}
		return pedido;
		
	}
	
	public ArrayList<Pedido> mostrarPedidos () {   // voy a devolver un array de pedidos con todos sus datos 
		ArrayList<Pedido> resultado=new ArrayList<>();
			
		try (FileReader    fr =new FileReader(dir);
				BufferedReader bf= new BufferedReader(fr);){

			String fila;      
			//Recorremos el fichero linea a linea y convertimos cada linea en un pedido
			//Despues comprobamos si ese pedido es posterior al más reciente hasta ahora
			while ((fila= bf.readLine())!=null) {
				String[] linea=fila.split("[|]");  // el separador era |  , metemos cada contenido de la linea en un array con 3 posiciones
				Pedido p = new Pedido(linea[0],fm.parse(linea[1]),Double.parseDouble(linea[2]));
				resultado.add(p);

			}
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		catch (ParseException ex) {
			ex.printStackTrace();
		}
		return resultado;

		
	}
}
