package lesson10.labs.prob1.bugreporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.logging.Logger;

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
			+ "\\src\\lesson10\\labs\\prob1\\bugreporter\\bug_report.txt";
	public void reportGenerator() {
		List<Class<?>> classes = ClassFinder.find(PACKAGE_TO_SCAN);

		//sample code for reading annotations -- you will need to change
		//this quite a bit to solve the problem
		//Sample code below obtains a list of names of developers assigned to bugs
		List<String> names = new ArrayList<String>();
		List<String> reporterNames = new ArrayList<String>();
		List<String> classNames = new ArrayList<String>();
		List<String> descriptions = new ArrayList<String>();
		List<Integer> severities = new ArrayList<Integer>();
		for(Class<?> cl : classes) {
			if(cl.isAnnotationPresent(BugReport.class)) {
				BugReport annotation = (BugReport)cl.getAnnotation(BugReport.class);
				String name = annotation.assignedTo();
				String reporterName = annotation.reportedBy();
				String className = cl.getName();
				String description = annotation.description();
				int severity = annotation.severity();
				names.add(name);
				reporterNames.add(reporterName);
				classNames.add(className);
				descriptions.add(description);
				severities.add(severity);
			}
		}
		names.stream().forEach(System.out::println);
		File f = new File(FILE_LOCATION);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				LOG.warning("IOException thrown when creating file: " + e.getMessage());
			}
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))){
			writer.write("");
		} catch (IOException e) {
			LOG.warning("IOException thrown when writing file: " + e.getMessage());
		}
		//System.out.println(names);

	}


}
