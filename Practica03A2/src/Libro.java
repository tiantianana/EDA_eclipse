
public class Libro {
	private String Title;
	private String Author;
	private String Genre;

	public Libro(String Title, String Author, String Genre) {
		setTitle(Title);
		setAuthor(Author);
		setGenre(Genre);
	}

	public Libro() {
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public String getLibro(String elLibro) {
		return elLibro = this.Title + this.Author + this.Genre;
	}

	public Libro ShowLibro(Libro l) {
		
		System.out.println("Titulo: " + l.getTitle());
		System.out.println("Autor: " + l.getAuthor());
		System.out.println("G�nero: " + l.getGenre());
		System.out.println("");
	
		return l;
	}

}