package lesson2.labs.prob4;

import java.util.*;

public class Student {
	String name;
	String id;
	List<TranscriptEntry> grades = new ArrayList<TranscriptEntry>();

	public Transcript getTranscript() {
		return new Transcript(grades, this);
	}

	public void addTranscriptEntry(TranscriptEntry e) {
		this.grades.add(e);
	}
}
