package lesson2.labs.prob4;

import java.util.*;

public class Section {
	String courseName;
	int sectionNumber;
	List<TranscriptEntry> gradeSheet = new ArrayList<TranscriptEntry>();

	public void addTranscriptEntry(TranscriptEntry e) {
		this.gradeSheet.add(e);
	}
}
