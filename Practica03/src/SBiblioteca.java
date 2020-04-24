
public class SBiblioteca implements IBiblioteca {
	public SNode first;
	public SNode last;
	int size;
	public Libro libro;

	public void insert(Libro libro) {
		SNode node = new SNode(libro);
		if (last == null) {
			first = node;
			last = node;
		} else {
			last.setNext(node);
			last = node;
		}
		size++;
	}

	@Override
	public Libro getLibroByTitle(String title) {
		
		for (SNode node = first; node != null; node = node.getNext()) {
			if (node.getlibro().getTitle().equals(title)) {
				return node.getlibro();
			} else {
				System.out.println("El libro no fue encontrado");

			}
		}
		return null;
	}

	@Override
	public Libro getLibroByAuthors(String author) {
		for (SNode node = first; node != null; node = node.getNext()) {
			if (node.getlibro().getTitle().equals(author)) {
				return node.getlibro();
			}
		}
		return null;
	}

	/*
	@Override
	public Libro getLibroByGenre(Genre genero) {
		for (SNode node = first; node != null; node = node.getNext()) {
			if (node.getlibro().getGenre().equals(genero)) {
				return node.getlibro();
			}

		}
		return null;
	}

	@Override
	public void removeGenero(Libro genre) {
		SNode prev = null;
		for (SNode node = first; node != null; node = node.getNext()) {
			if (genre.equals(node.getlibro())) {
				if (prev != null) {
					prev.setNext(node.getNext());
				} else {
					first = node.getNext();
				}
				if (node == last) {
					last = prev;
				}
				size--;
			} else {
				prev = node;
			}
		}

	}
	*/

}
