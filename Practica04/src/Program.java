
public class Program {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		Libro libro1 = new Libro("Quijote", "Cervantes", "Novela");
		Libro libro2 = new Libro("Las cenizas de Manhattan", "Lopez", "Historia");
		Libro libro3 = new Libro("Palabras me lleven", "Ruben Rosa", "Ensayo");
		Libro libro4 = new Libro("El valle de los lobos", "Laura Gallego", "Fantasia");
		Libro libro5 = new Libro("La leyenda del rey Errante", "Laura Gallego", "Fantasia");
		Libro libro6 = new Libro("Alas negras", "Laura Gallego", "Fantasia");
		Libro libro7 = new Libro("Alas negras", "Laura Gallego", "Fantasia");

		biblioteca.insert(libro1);
		biblioteca.insert(libro2);
		biblioteca.insert(libro3);
		biblioteca.insert(libro4);
		biblioteca.insert(libro5);
		biblioteca.insert(libro6);
		biblioteca.insert(libro7);

		biblioteca.getNumBooks();

		System.out.println(" ");
		System.out.println("Buscamos el libro por titulo: ");
		biblioteca.searchBooksByTitle("Alas negras");
		System.out.println(" ");
		System.out.println("Buscamos otro libro por titulo: ");
		biblioteca.searchBooksByTitle("Campos negras");
		System.out.println("Buscamos otro libro por titulo: ");
		biblioteca.searchBooksByTitle("La leyenda del rey Errante");

		System.out.println(" ");
		System.out.println("Buscamos el libro por autor: ");
		biblioteca.searchBookByAuthors("Laura Gallego");
		System.out.println(" ");
		System.out.println("Buscamos otro libro por autor: ");
		biblioteca.searchBookByAuthors("Ruben Rosa");
		System.out.println("Buscamos el libro por genero: ");
		biblioteca.searchBookByGenre("Fantasia");
		System.out.println(" ");
		System.out.println("Buscamos otro libro por genero: ");
		biblioteca.searchBookByGenre("Historia");
		System.out.println(" ");
		System.out.println("La lista con los libros introducidos ordenados alfabeticamente: ");
		biblioteca.ShowFinalLibrary();
		
		System.out.println("La lista ordenada por autores: ");
		biblioteca.orderByAuthor();

	}
}
