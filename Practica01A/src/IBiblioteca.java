
public interface IBiblioteca {
	public void insert(String Title, String Author, Genre Genre);
	public void searchBooksByTitle(String Title);
	public Libro[] searchBookByAuthors(String Author);
	public Libro[] searchBookByGenre(Genre Genre);
}
