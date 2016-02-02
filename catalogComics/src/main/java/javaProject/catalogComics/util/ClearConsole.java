package javaProject.catalogComics.util;

import java.io.IOException;

public class ClearConsole {

    public final static void clear() throws IOException {

	final String os = System.getProperty("os.name");
	if (os.contains("Windows")) {

	    Runtime.getRuntime().exec("cls");

	} else {
	    Runtime.getRuntime().exec("clear");
	}

    }

}
