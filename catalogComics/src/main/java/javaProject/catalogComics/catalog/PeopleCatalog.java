package javaProject.catalogComics.catalog;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import javaProject.catalogComics.exception.PeopleNotFoundException;
import javaProject.catalogComics.model.People;

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

    public People findBy(String username, String password) throws PeopleNotFoundException {
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

    public void update(People peopleToUptade) {
	PeopleCatalog.getInstance().findAll().removeIf(condition(peopleToUptade.getId()));
	PeopleCatalog.getInstance().findAll().add(peopleToUptade);
    }

    public void delete(int id) throws PeopleNotFoundException {
	PeopleCatalog.getInstance().findAll().removeIf(condition(id));
    }

    private Predicate<? super People> condition(int id) {
	return element -> element.getId() == id;
    }

}
