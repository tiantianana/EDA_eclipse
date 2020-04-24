package phase1;

import java.time.LocalDate;

public interface IManageNetworkList {

	public StudentsList union(StudentsList lst1, StudentsList lst2);
	public StudentsList getCampusCity(StudentsList lst, int opc);
	public StudentsList orderBy(StudentsList lst, int opc);
	public StudentsList locateByCity(StudentsList lst, String city);
	public StudentsList getStudentsByDateInterval(StudentsList lst, LocalDate start, LocalDate end);

}


