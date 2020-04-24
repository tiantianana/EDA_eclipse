
public class Biblioteca {
	public DList list = new DList();
	public Libro libro = new Libro();

	public Biblioteca() {
	}

	//Obtenemos el numero de libros que hay en la biblioteca
	public int getNumBooks() {
		int i = 0;
		for (DNode nodeIt = list.getHeader().getNext(); nodeIt != list.getTrailer(); nodeIt = nodeIt.getNext())
			if (!list.isEmpty()) {
				for (i = 0; i < list.getSize(); i++) {
					i++;
				}
			}
		System.out.println("El número de libros actual en la biblioteca es: " + i);
		return i;
	}

	//Insertamos un libro
	public void insert(Libro libro) {
		int i = 0;
		if (list.contains(libro)) {
			System.out.println("el libro ya se encuentra en la biblioteca");
			return;
		}
		if (list.isEmpty()) {
			list.addFirst(libro);
			System.out.println("Se ha insertado el libro al comienzo de la lista");
			return;
		}
		for (DNode node = list.getHeader().getNext(); node != list.getTrailer(); node = node.getNext()) {
			if (libro.getTitle().compareTo(node.getlibro().getTitle()) < 0) {
				list.insertAt(i, libro);
				System.out.println("Se ha insertado el libro en la posicion: " + i);
				return;
			}
			i++;
		}
		list.addLast(libro);
		System.out.println("Se ha insertado el libro en la posicion: " + i);
	}

	public void Show() {
		for (DNode node = list.getHeader().getNext(); node != list.getTrailer(); node = node.getNext()) {
			if (!list.isEmpty()) {
				System.out.println("Titulo: " + node.getlibro().getTitle() +", " + " Autor: " + node.getlibro().getAuthor()
						+", "+ " Genero: " + node.getlibro().getGenre() + " .");
			} else {
				System.out.println("Esta libreria se encuentra vacia");
			}
		}
	}

	// Buscamos el libro por titulo
	public void searchBooksByTitle(String title) {
		for (DNode node = list.getHeader().getNext(); node != list.getTrailer(); node = node.getNext()) {
			if (node.getlibro().getTitle() == title) {
				libro.ShowLibro(node.getlibro());
				return;
			}
		}
		System.out.println("El libro no está en la coleccion");
		System.out.println("");
	}

	//Buscamos el libro por autor
	public Biblioteca searchBookByAuthors(String author) {
		Biblioteca biblio = new Biblioteca();
		for (DNode node = list.getHeader().getNext(); node != list.getTrailer(); node = node.getNext()) {
			if (node.getlibro().getAuthor() == author) {
				libro.ShowLibro(node.getlibro());
				biblio.insert(node.getlibro());
			}
		}
		return biblio;
	}

	//Buscamos el libro por genero
	public Biblioteca searchBookByGenre(String genero) {
		Biblioteca biblio2 = new Biblioteca();
		for (DNode node = list.getHeader().getNext(); node != list.getTrailer(); node = node.getNext()) {
			if (node.getlibro().getGenre() == genero) {
				libro.ShowLibro(node.getlibro());
				biblio2.insert(node.getlibro());
			}
		}
		return biblio2;
	}

	//Ordenamos el libro por autor
	public void orderByAuthor() {
		for(DNode node = list.getHeader().getNext(); node != list.getTrailer(); node = node.getNext() ) {
			for (DNode nodeIt = node.getNext(); nodeIt != list.getTrailer(); nodeIt = nodeIt.getNext()) {
				if(node.getlibro().getAuthor().compareTo(nodeIt.getlibro().getAuthor()) >= 0) {
					Libro aux = nodeIt.getlibro();
					nodeIt.setlibro(node.getlibro());
					node.setlibro(aux);
				}
				
			}			
		}
		System.out.println("\n biblioteca ordenada: ");
		ShowFinalLibrary();
	}
	
	// mostramos la libreria completa
	public void ShowFinalLibrary() {
		for (DNode node = list.getHeader().getNext(); node != list.getTrailer(); node = node.getNext()) {
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
