package lesson10.labs.prob1.bugreporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.util.logging.Logger;
import java.util.stream.Collectors;

import lesson10.labs.prob1.classfinder.ClassFinder;

/**
 * This class scans the package lesson10.labs.prob1.javapackage
 * for classes with annotation @BugReport. It then generates a bug report
 * bugreport.txt, formatted like this:
 *
 * Joe Smith
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *
 * Tom Jones
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *
 *
 */
public class BugReportGenerator {
	private static final Logger LOG = Logger.getLogger(BugReportGenerator.class.getName());
	private static final String PACKAGE_TO_SCAN = "lesson10.labs.prob1.javapackage";
	private static final String REPORT_NAME = "bug_report.txt";
	private static final String REPORTED_BY = "reportedBy: ";
	private static final String CLASS_NAME = "classname: ";
	private static final String DESCRIPTION = "description: ";
	private static final String SEVERITY = "severity: ";
	public final static String FILE_LOCATION = System.getProperty("user.dir")
			+ "\\src\\lesson10\\labs\\prob1\\bugreporter\\" + REPORT_NAME;
	public void reportGenerator() {
		List<Class<?>> classes = ClassFinder.find(PACKAGE_TO_SCAN);
		List<OutputReport> outputReports = new ArrayList<OutputReport>();
		for(Class<?> cl : classes) {
			if(cl.isAnnotationPresent(BugReport.class)) {
				BugReport annotation = (BugReport)cl.getAnnotation(BugReport.class);
				OutputReport outputReport = new OutputReport(annotation.assignedTo(),
						annotation.reportedBy(), 
						cl.getName(), 
						annotation.description(), 
						annotation.severity());
				outputReports.add(outputReport);
			}
		}
		File f = new File(FILE_LOCATION);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				LOG.warning("IOException thrown when creating file: " + e.getMessage());
			}
		}
		outputReports = 
				outputReports.stream().sorted(Comparator.comparing(OutputReport::getName))
				.collect(Collectors.toList());
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))){
			String name = null;
			for (OutputReport outputReport : outputReports) {
				if (name == null) {
					name = outputReport.getName();
					writer.write(name + "\n");
				}else {
					if (name.equals(outputReport.getName())){
					}else {
						writer.write(outputReport.getName() + "\n");
						name = outputReport.getName();
					}
				}
				writer.write("    " + REPORTED_BY + outputReport.getReporterName() + "\n");
				writer.write("    " + CLASS_NAME + outputReport.getClassName() + "\n");
				writer.write("    " + DESCRIPTION + outputReport.getDescription() + "\n");
				writer.write("    " + SEVERITY + outputReport.getSeverity() + "\n\n");
			}
		} catch (IOException e) {
			LOG.warning("IOException thrown when writing file: " + e.getMessage());
		}
	}
}
