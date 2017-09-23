package lesson10.labs.prob2;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class NewFileIO {
	private static final Logger LOG = Logger.getLogger(NewFileIO.class.getName());
	public final static String FILE_LOCATION = "file:src/lesson10/labs/prob2/output.txt";
	public final static String TO_PRINT = "This is the string to print to file.";

	void writeText(URL url, String text) {
		try (PrintWriter pw = new PrintWriter(new File(url.getFile()))){
			pw.write(text);
		} catch(IOException e) {
			LOG.warning("IOException attempting to write a file: " + e.getMessage());
		}
	}
	public static void main(String[] args) {
		try {
			URL url = new URL(FILE_LOCATION);
			NewFileIO newIO = new NewFileIO();
			newIO.writeText(url, TO_PRINT);
		} catch (MalformedURLException e) {
			LOG.warning("MalformedURLException attempting to handle a URL: " + e.getMessage());
		}
	}
}
