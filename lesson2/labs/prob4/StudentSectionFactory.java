package lesson2.labs.prob4;

public class StudentSectionFactory {
	
	public Section createSection(int secNum, String courseName) {
		Section sec = new Section();
		sec.sectionNumber = secNum;
		sec.courseName = courseName;
		return sec;
	}

	public Student createStudent(String id, String name) {
		Student stu = new Student();
		stu.id = id;
		stu.name = name;
		return stu;
	}

	public void newTranscriptEntry(Student s, Section sect, String grade) {
		TranscriptEntry tentry = new TranscriptEntry();
		tentry.grade = grade;
		tentry.section = sect;
		tentry.student = s;
		s.addTranscriptEntry(tentry);
		sect.addTranscriptEntry(tentry);
	}
}
