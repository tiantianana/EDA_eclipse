
public interface IBiblioteca {

	public void insert(Libro libro);

	public Libro getLibroByTitle(String title);

	public Libro getLibroByAuthors(String authors);

	/*
	public Libro getLibroByGenre(Genre genero);

	public void removeGenero(Libro genre);
	*/
}
