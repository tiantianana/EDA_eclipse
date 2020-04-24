
public class Program {

	public static void main(String[] args) {
		SBiblioteca biblioteca = new SBiblioteca();
		Libro libro1 = new Libro("Quijote", "Cervantes", Genre.Novela);
		Libro libro2 = new Libro("Las cenizas de Manhattan", "Lopez", Genre.Historia);
		Libro libro3 = new Libro("Palabras me lleven", "Ruben Rosa", Genre.Ensayo);

		biblioteca.insert(libro1);
		biblioteca.insert(libro2);
		biblioteca.insert(libro3);

		SBiblioteca Title = new SBiblioteca();
		String Title1 = "Quijote";
		String Title2 = "Las cenizas de Manhattan";
		String Title3 = "Palabras me lleven";
		String Title4 = "Crimen y castigo";
		Title.getLibroByTitle(Title1);
		Title.getLibroByTitle(Title2);
		Title.getLibroByTitle(Title3);
		Title.getLibroByTitle(Title4);
		
		
		SBiblioteca Autores= new SBiblioteca();
		String Author1 = "Cervantes";
		String Author2 = "Lopez";
		String Author3 = "Ruben Rosa";
		
		Autores.getLibroByAuthors(Author1);
		Autores.getLibroByAuthors(Author2);
		Autores.getLibroByAuthors(Author3);
		
		/*
		SBiblioteca Genero = new SBiblioteca();
		Genre Genre1= Genre.Novela;
		Genre Genre2= Genre.Novela;
		Genre Genre3= Genre.Novela;
		
		Genero.getLibroByGenre(Genre1);
		Genero.getLibroByGenre(Genre2);
		Genero.getLibroByGenre(Genre3);
		
		SBiblioteca eliminarGenero = new SBiblioteca();
		Genre Genero1= Genre.Novela;
		Genre Genero2= Genre.Novela;
		Genre Genero3= Genre.Novela;
		
		eliminarGenero.removeGenero(Genero1);;
		eliminarGenero.removeGenero(Genero2);
		eliminarGenero.removeGenero(Genero3);
		*/
		
	}
}
