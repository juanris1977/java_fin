package singleton;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class LoggerSingleton {
	private LoggerSingleton (){};
	private static Logger Logger;
	
	public static Logger getLogger () {
		if (Logger == null) {
			Logger = Logger.getLogger("trazas");
			Handler file;
			try {
				file = new FileHandler ("c:\\ficheroseclipse\\trazas.log");
				Logger.addHandler(file);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return Logger;
	}

}
