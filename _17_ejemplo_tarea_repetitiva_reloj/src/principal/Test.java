package principal;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// tarea que cada segundo muestre la hora
		ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
	
			exec.scheduleAtFixedRate( () -> System.out.println(LocalTime.now()), 0, 1, TimeUnit.SECONDS);  //  es un runnable que se ejecuta desde ya , cada 1 segundo 
	//	exec.scheduleAtFixedRate( () -> System.out.println(LocalTime.now()), 10, 1, TimeUnit.SECONDS);  //  es un runnable que se ejecuta dentro de 10 sg, cada 1 segundo 
		
		Thread.sleep(5000);
		exec.shutdownNow() ;  //Cierra de inmediato
	}
	
	
	

}
