
public class Biblioteca implements IBiblioteca {
	private final int numMaxLibros = 1000;
	private Libro[] arrLibro;
	
	public Biblioteca() {
		arrLibro = new Libro[numMaxLibros];
		for (int i = 0; i< arrLibro.length; i++) {
			if (arrLibro[i] == null)
				{
					arrLibro[i] = new Libro(arrLibro[i].getTitle(), arrLibro[i].getAuthor(), arrLibro[i].getGenre());
				}
			}
	}
	
	@Override
	public void insert(String Title, String Author, Genre Genre) {
		boolean esta;
		for (int i = 0; i< arrLibro.length; i++)
		{
			if(arrLibro[i].getTitle() == Title)
			{
				esta = true;
			}
			else if (arrLibro[i] != null )
			{
				esta = true;
			}
			else 
			{
				esta = false;
			}
		}
	}
	
	@Override
	public void searchBooksByTitle(String Title) {
	for (int i = 0; i< arrLibro.length; i++){
		if (arrLibro[i].getTitle() == Title)
		{
			System.out.println(arrLibro);
		}
		else
			{
				System.out.print("El libro no fue encontrado");
			}
		}
	}
	
	@Override
	public Libro[] searchBookByAuthors(String Author) {
		Libro[] msg1 = null;
		for (int i = 0; i< arrLibro.length; i++)
		{
			if(Author == arrLibro[i].getAuthor())
			{
				msg1= arrLibro;
			}
		}
		return msg1;
	}
	
	@Override
	public Libro[] searchBookByGenre(Genre Genre) {
		Libro[] msg2 = null;
		for (int i = 0; i< arrLibro.length; i++)
		{
			
			if(Genre == arrLibro[i].getGenre())
			{
				msg2 = arrLibro;
			}
		}
		return msg2;
	}
}



