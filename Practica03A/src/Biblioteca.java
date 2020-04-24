
public class Biblioteca {
	public SList list = new SList();

	public void insert(Libro libro) {
		if (!list.contains(libro)) {
			list.addLast(libro);
		} else {
			System.out.println("el libro ya se encuentra en la biblioteca");
		}
	}

	public void searchBooksByTitle(String title) {
		for (SNode node = list.getfirst(); node != null; node = node.getNext()) {
			if (node.getlibro().getTitle() == title) {
				ShowLibro(node.getlibro());
				return;
			}
		}
		System.out.println("El libro no fue encontrado");
	}

	public void searchBookByAuthors(String author) {
		for (SNode node = list.getfirst(); node != null; node = node.getNext()) {
			if (node.getlibro().getTitle() == author) {
				ShowLibro(node.getlibro());
				return;
			}
		}
	}

	public void searchBookByGenre(String genero) {
		for (SNode node = list.getfirst(); node != null; node = node.getNext()) {
			if (node.getlibro().getGenre() == genero) {
				ShowLibro(node.getlibro());
				return;
			}
		}
	}

	public void removeGenero(String genero) {
		for (SNode node = list.getfirst(); node != null; node = node.getNext()) {
			if (genero == node.getlibro().getGenre()) {
				list.removeAll(genero);
				return;
			}
		}
	}

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

	public void ShowLibro(Libro l) {
		System.out.println("Titulo: " + l.getTitle());
		System.out.println("Autor: " + l.getAuthor());
		System.out.println("Género: " + l.getGenre());
		System.out.println("");
	}

}

