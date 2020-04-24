public class Program {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		Libro libro1 = new Libro("Quijote", "Cervantes", "Novela");
		Libro libro2 = new Libro("Las cenizas de Manhattan", "Lopez", "Historia");
		Libro libro3 = new Libro("Palabras me lleven", "Ruben Rosa", "Ensayo");
		Libro libro4 = new Libro("El valle de los lobos", "Laura Gallego", "Fantasia");
		Libro libro5 = new Libro("La leyenda del rey Errante", "Laura Gallego", "Fantasia");
		Libro libro6 = new Libro("Alas negras", "Laura Gallego", "Fantasia");

		biblioteca.insert(libro1);
		biblioteca.insert(libro2);
		biblioteca.insert(libro3);
		biblioteca.insert(libro4);
		biblioteca.insert(libro5);
		biblioteca.insert(libro6);
		
		System.out.println("Buscamos el libro por titulo");
		biblioteca.searchBooksByTitle("Alas negras");
		biblioteca.searchBooksByTitle("Campos negras");
		biblioteca.searchBooksByTitle("La leyenda del rey Errante");
		
		System.out.println("Buscamos el libro por autor");
		biblioteca.searchBookByAuthors("Laura Gallego");
		System.out.println("Buscamos el libro por genero");
		biblioteca.searchBookByGenre("Fantasia");
		
		System.out.println("La lista con los libros introducidos: ");
		biblioteca.ShowFinalLibrary();
		
		System.out.println("La lista con libros excepto el genero fantasia: ");
		biblioteca.removeGenero("Fantasia");
		biblioteca.ShowFinalLibrary();

	}
}

