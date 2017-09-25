package lesson10.labs.prob1.bugreporter;

public class OutputReport {
	private String name;
	private String reporterName;
	private String className;
	private String description;
	private int severity;
	
	public OutputReport(String name, String reporterName, String className, String description, int severity) {
		this.name = name;
		this.reporterName = reporterName;
		this.className = className;
		this.description = description;
		this.severity = severity;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReporterName() {
		return reporterName;
	}

	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSeverity() {
		return severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}	
}
