
public class Libro {
	private String Title;
	private String Author;
	private Genre Genre;
	
	protected Libro(String Title, String Author, Genre Genre)
	{
		setTitle(Title);
		setAuthor(Author);
		setGenre(Genre);
	}
	
	protected String getTitle() {
		return Title;
	}

	protected void setTitle(String title) {
		Title = title;
	}

	protected String getAuthor() {
		return Author;
	}

	protected void setAuthor(String author) {
		Author = author;
	}

	protected Genre getGenre() {
		return Genre;
	}

	protected void setGenre(Genre genre) {
		Genre = genre;
	}

	
	protected String getLibro(String elLibro) {
		return elLibro = this.Title + this.Author + this.Genre;
	}
	
}


