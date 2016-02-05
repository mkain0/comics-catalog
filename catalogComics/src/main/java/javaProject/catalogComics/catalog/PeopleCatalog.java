package javaProject.catalogComics.catalog;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import javaProject.catalogComics.exception.NotFoundException;
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

    public People findBy(String username, String password) throws NotFoundException {
	boolean userValid;
	for (People people : peoples) {
	    userValid = people.getUsername().equals(username) && people.getPassword().equals(password);
	    if (userValid) {
		return people;
	    }
	}
	throw new NotFoundException("The username or password is incorrect.");
    }

    public People findBy(String username) throws NotFoundException {
	for (People people : peoples) {
	    if (people.getUsername().equals(username)) {
		return people;
	    }
	}
	throw new NotFoundException("User not found.");
    }

    public Set<People> findAll() {
	return peoples;
    }

    public int save(People people) {
	if (people == null) {
	    throw new IllegalArgumentException();
	}
	people.setId(PeopleCatalog.getNext());
	PeopleCatalog.getInstance().findAll().add(people);
	return people.getId();
    }

    public People findBy(int id) throws NotFoundException {
	for (People people : peoples) {
	    if (people.getId() == id) {
		return people;
	    }
	}
	throw new NotFoundException("User not found.");
    }

    public void update(People peopleToUptade) {
	if (peopleToUptade == null) {
	    throw new IllegalArgumentException();
	}
	PeopleCatalog.getInstance().findAll().removeIf(condition(peopleToUptade.getId()));
	PeopleCatalog.getInstance().findAll().add(peopleToUptade);
    }

    public void delete(int id) {
	PeopleCatalog.getInstance().findAll().removeIf(condition(id));
    }

    private Predicate<? super People> condition(int id) {
	return element -> element.getId() == id;
    }

    public boolean isRegister(People user) {
	return PeopleCatalog.getInstance().findAll().stream().anyMatch(people -> {
	    return people.getUsername().equals(user.getUsername());
	});
    }

}
