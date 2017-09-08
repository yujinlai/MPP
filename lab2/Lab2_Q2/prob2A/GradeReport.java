package prob2A;

public class GradeReport {
	private Student student;
	
	//package level
	GradeReport(Student student) {
		this.student = student;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public String getReport() {
		return student.toString();
	}
}
