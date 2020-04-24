package phase1;

import java.time.LocalDate;

public class ManageNetworkList implements IManageNetworkList {

	public StudentsList union(StudentsList lst1, StudentsList lst2) {

		StudentsList resultList = new StudentsList();

		if (lst1 != null && lst2 != null) {
			if (lst1.size == 0)
				resultList = lst2;
			else if (lst2.size == 0)
				resultList = lst1;
			else {

				for (DNode aux = lst1.header.next; aux != lst1.trailer; aux = aux.next)
					resultList.addLast(aux.elem);

			}

			for (DNode aux2 = lst2.header.next; aux2 != lst2.trailer; aux2 = aux2.next) {
				resultList.addLast(aux2.elem);
			}
		}
		return resultList;

	}

	public StudentsList getCampusCity(StudentsList lst, int opc) {
		StudentsList l = new StudentsList();

		if (opc == 1) {
			for (DNode aux = lst.header.next; aux != lst.trailer; aux = aux.next) {
				if (aux.elem.city.equals(aux.elem.campus.toString())) {
					l.addLast(aux.elem);
				}
			}
			return l;
		}
		if (opc == 2) {
			for (DNode aux = lst.header.next; aux != lst.trailer; aux = aux.next) {
				if (!aux.elem.city.equals(aux.elem.campus.toString())) {
					l.addLast(aux.elem);
				}
			}
			return l;
		} else {
			System.out.println("No se han encontrado estudiantes con esos requisitos");
			return null;
		}
	}

	public StudentsList orderBy(StudentsList lst, int opc) {

		StudentsList sortedList = new StudentsList();

		if (lst != null) {
			for (DNode nodeIt = lst.header.next; nodeIt != lst.trailer; nodeIt = nodeIt.next) {
				sortedInsert(sortedList, nodeIt.elem, opc);
			}
		}

		return sortedList;
	}

	public static void sortedInsert(StudentsList lst, Student newStudent, int opc) {
		if (lst != null && lst.size == 0) // si aun no se han añadido elems a la nueva lista, lo añadimos en la primera
			// pos (tb valdria un addlast)
			lst.addFirst(newStudent);
		else {
			boolean positioned = false;
			int pos = 0;
			DNode node = lst.header.next; // empezamos a recorrer la lista que estamos creando por el primer elemento
			if (opc == 1) { // orden ascendente
				while (!positioned) {
					if (newStudent.email.compareToIgnoreCase(node.elem.email) < 1) { // comparamos newStudent con los elementos de
																			// la lista hasta que encontramos
																			// uno mayor, entonces lo insertamos en la
																			// posición anterior a dicho el.
						lst.insertAt(pos, newStudent);
						lst.size++;
						positioned = true;
						break;
					} else {
						node = node.next;
						pos++;
					}
				} // while1
			} else if (opc == 2) { // orden descendente
				while (!positioned) {
					if (newStudent.email.compareToIgnoreCase(node.elem.email) > 1) { // comparamos newStudent con los
																						// el. de la lista hasta que
																						// encontramos
						// uno mayor, entonces lo insertamos en la posición anterior a dicho el.
						lst.insertAt(pos, newStudent);
						lst.size++;
						positioned = true;
						break;
					} else {
						node = node.next;
					}
				} // while2
			}

			else {
				System.out.println("No has elegido una opción posible (1 o 2)");
			}

		}
	}

	public StudentsList locateByCity(StudentsList lst, String city) {

		StudentsList l = new StudentsList();
		if (lst != null) {
			for (DNode aux = lst.header.next; aux != lst.trailer; aux = aux.next) {
				if (aux.elem.city.equals(city)) {
					l.addLast(aux.elem);
				}
			}
		}
		return l;

	}

	public StudentsList getStudentsByDateInterval(StudentsList lst, LocalDate start, LocalDate end) {
		StudentsList resultList = new StudentsList();

		if (lst != null && start.compareTo(end) < 1) {
			for (DNode node = lst.header.next; node != lst.trailer; node = node.next) {
				if (start.compareTo(node.elem.date_sign_in) <= 0 && end.compareTo(node.elem.date_sign_in) >= 0) {
					resultList.addLast(node.elem);
				}
			}
		}
		return resultList;

	}

	public static void main(String[] args) {

	}

}
