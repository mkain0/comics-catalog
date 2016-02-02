package javaProject.catalogComics.catalog;

import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

import javaProject.catalogComics.exception.PeopleNotFoundException;
import javaProject.catalogComics.model.People;
import javaProject.catalogComics.util.Encryption;

public class PeopleCatalog {

    private static PeopleCatalog uniqueInstance;
    private static int counter;
    private Set<People> peoples = new HashSet<>();

    private PeopleCatalog() {
	counter = 0;
    }

    public static synchronized PeopleCatalog getInstance() {
	if (uniqueInstance == null) {
	    return uniqueInstance = new PeopleCatalog();
	}
	return uniqueInstance;
    }

    public static synchronized int getNext() {
	return ++counter;
    }

    public People findBy(String username, String password) throws NoSuchAlgorithmException, PeopleNotFoundException {
	password = Encryption.encrypted(password);
	boolean userValid;
	for (People people : peoples) {
	    userValid = people.getUsername().equals(username) && people.getPassword().equals(password);
	    if (userValid) {
		return people;
	    }
	}
	throw new PeopleNotFoundException("The username or password is incorrect.");
    }

    public Set<People> findAll() {
	return peoples;
    }

    public static int add(People people) {
	people.setId(PeopleCatalog.getNext());
	PeopleCatalog.getInstance().findAll().add(people);
	return people.getId();
    }

    public People find(int id) throws PeopleNotFoundException {
	for (People people : peoples) {
	    if (people.getId() == id) {
		return people;
	    }
	}
	throw new PeopleNotFoundException("People not found.");
    }

    public static void update(People peopleToUptade) {
	for (People people : PeopleCatalog.getInstance().findAll()) {
	    if (people.getId() == peopleToUptade.getId()) {
		PeopleCatalog.getInstance().findAll().remove(people);
		PeopleCatalog.getInstance().findAll().add(people);
	    }
	}
    }

    public static boolean delete(int id) throws PeopleNotFoundException {
	for (People people : PeopleCatalog.getInstance().findAll()) {
	    if (people.getId() == id) {
		return PeopleCatalog.getInstance().findAll().remove(people);
	    }
	}
	throw new PeopleNotFoundException("People not found.");
    }

}
