package javaProject.catalogComics.exception;

public class DuplicateUsernameException extends Exception {

    public DuplicateUsernameException() {
	super();
    }

    public DuplicateUsernameException(String message) {
	super(message);
    }
}
