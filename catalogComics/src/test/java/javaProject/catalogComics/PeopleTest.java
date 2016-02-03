package javaProject.catalogComics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import javaProject.catalogComics.catalog.PeopleCatalog;
import javaProject.catalogComics.exception.PeopleNotFoundException;
import javaProject.catalogComics.model.Admin;
import javaProject.catalogComics.model.People;

public class PeopleTest {

    @BeforeClass
    public static void setUp() throws Exception {
	PeopleCatalog.getInstance().save(new Admin("Sheldon", "Bazinga", "Sheldon", "Cooper"));
    }

    @Test
    public void register() {
	assertEquals(1, PeopleCatalog.getInstance().save(new Admin("Sheldon", "Bazinga", "Sheldon", "Cooper")));
    }

    @Test
    public void modify() throws PeopleNotFoundException {
	People people = PeopleCatalog.getInstance().find(1);
	people.setFirstName("Paul");
	PeopleCatalog.getInstance().update(people);
	assertEquals("Paul", PeopleCatalog.getInstance().find(1).getFirstName());
    }

    @Test(expected = PeopleNotFoundException.class)
    public void peopleNotFoundException() throws PeopleNotFoundException {
	People people = PeopleCatalog.getInstance().find(2);
	assertEquals(2, people.getId());
    }

    @Test
    public void delete() throws PeopleNotFoundException {
	fail("Not implemented yet");
    }

    @Test
    public void list() {
	assertEquals(new ArrayList<People>(), PeopleCatalog.getInstance().findAll());
    }

}
