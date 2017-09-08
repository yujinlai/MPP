package prob2A.extpackage;

import prob2A.GradeReport;
import prob2A.Student;

public class Main {

	public static void main(String[] args) {
		Student student = new Student("Bob");
		// not possible to create instance of GradeReport outside of a Student
		// --this is what is meant by "Student owns the relationship"
		// new GradeReport(student) -- compiler error
		System.out.println("Bob's grade report: " + student.getGradeReport().getReport());

		// You can navigate from a grade report to its owner
		GradeReport gradeReport = student.getGradeReport();
		System.out.println("Owner of gradeReport: " + gradeReport.getStudent());
	}
}
