package principal;

import java.util.List;

public class test {

	public static void main(String[] args) {
	
			List<Integer> lista=List.of(3,6,2,11,6,3,8,90,16,34,2,11);
			lista.parallelStream()
						.distinct()
						.forEach(System.out::println);
						
			System.out.println("---------------------");
			//mostrar los números de la lista, sin repetidos
			lista.parallelStream()//Stream parallel
			.distinct()//Stream parallel
			.sequential()//Stream normal
			.forEach(System.out::println);
			System.out.println("---------------------");
			
			lista.parallelStream()
			.peek(System.out::println)
			.anyMatch(n->n>10);
			
			System.out.println("---------------------");

			
			lista.parallelStream()
			.peek(System.out::println)
			.sequential()
			.anyMatch(n->n>10);

		}

	}
