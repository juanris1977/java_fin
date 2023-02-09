package service.locator;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Item;

public class LocatorCovid {
	//String ruta="c:\\Ficheros\\paises.json";
	 String url="https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/";
	 Gson gson=new Gson();
	
	public  Stream<Item> getJsonStream(){
		/*   // Para acceder a un JSON en un fichero 
		try(FileReader fr=new FileReader(ruta);){
			Pais[]paises=gson.fromJson(fr, Pais[].class);
			return Arrays.stream(paises);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	*/
		
		//crear HttpRequest
		HttpRequest request=HttpRequest.newBuilder() //Builder
							.uri(URI.create(url)) //Builder
							.GET() //Builder
							.build(); //HttpRequest
		//crear HttpClient
		HttpClient client=HttpClient.newBuilder() //Builder
						.version(Version.HTTP_1_1)    // import javanet
						.build();
		//lanzar petición y objeto HttpResponse
		try {
			HttpResponse response=client.send(request, BodyHandlers.ofString());
			return Arrays.stream(gson.fromJson(response.body().toString(), Item[].class)); //Stream<Pais>
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Stream.empty();
		}
	}
}


