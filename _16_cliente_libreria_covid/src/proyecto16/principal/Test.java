package proyecto16.principal;

import service.ItemsService;
import service.ItemsServiceFactory;

public class Test {

	public static void main(String[] args) {
		ItemsService service = ItemsServiceFactory.getItemService();
		service.paises().forEach(System.out::println);

	}

}
