
public class Biblioteca {
	public SList list = new SList();
	public Libro libro = new Libro();

	public Biblioteca() {
		
	}
	
	// insertamos un libro
	public Libro insert(Libro libro) {
		if (!list.contains(libro)) {
			list.addLast(libro);
		} else {
			System.out.println("el libro ya se encuentra en la biblioteca");
		}
		return libro;
	}

	//Buscamos el libro por titulo
	public void searchBooksByTitle(String title) {
		for (SNode node = list.getfirst(); node != null; node = node.getNext()) {
			if (node.getlibro().getTitle() == title) {
				libro.ShowLibro(node.getlibro());
				return ;
			}
		}
		System.out.println("El libro no fue encontrado");
		System.out.println("");
	}

	//buscamos el libro por autor
	public Biblioteca searchBookByAuthors(String author) {
		Biblioteca biblio = new Biblioteca();
		for (SNode node = list.getfirst(); node != null; node = node.getNext()) {
			if (node.getlibro().getAuthor() == author) {
				 libro.ShowLibro(node.getlibro());
				 biblio.insert(node.getlibro());
			}
		}
		return biblio;
	}

	//buscamos el libro por genero
	public Biblioteca searchBookByGenre(String genero) {
		Biblioteca biblio2 = new Biblioteca();
		for (SNode node = list.getfirst(); node != null; node = node.getNext()) {
			if (node.getlibro().getGenre() == genero) {
				libro.ShowLibro(node.getlibro());
				 biblio2.insert(node.getlibro());
			}
		}
		return biblio2;
	}

	public void removeGenero(String genero) {
		for (SNode node = list.getfirst(); node != null; node = node.getNext()) {
			if (genero == node.getlibro().getGenre()) {
				list.removeAll(genero);
				return;
			}
		}
	}

	// mostramos la libreria completa
	public void ShowFinalLibrary() {
		for (SNode node = list.getfirst(); node != null; node = node.getNext()) {
			if (!list.isEmpty()) {
				System.out.println("Titulo: " + node.getlibro().getTitle());
				System.out.println("Autor: " + node.getlibro().getAuthor());
				System.out.println("Género: " + node.getlibro().getGenre());
				System.out.println("");
			} else {
				System.out.println("Esta libreria se encuentra vacia");
			}
		}
	}


}
