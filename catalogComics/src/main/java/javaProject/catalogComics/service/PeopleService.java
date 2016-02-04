package javaProject.catalogComics.service;

import java.security.NoSuchAlgorithmException;
import java.util.Set;

import javaProject.catalogComics.catalog.LoanCatalog;
import javaProject.catalogComics.catalog.PeopleCatalog;
import javaProject.catalogComics.exception.CanNotDeleteException;
import javaProject.catalogComics.exception.NotFoundException;
import javaProject.catalogComics.model.People;
import javaProject.catalogComics.model.User;
import javaProject.catalogComics.util.Encryption;

public class PeopleService {

    public People login(String username, String password) throws NoSuchAlgorithmException, NotFoundException {
	return PeopleCatalog.getInstance().findBy(username, Encryption.encrypted(password));
    }

    public Set<People> findAll() {
	return PeopleCatalog.getInstance().findAll();
    }

    public People findBy(int id) throws NotFoundException {
	return PeopleCatalog.getInstance().findBy(id);
    }

    public int save(User user) throws NoSuchAlgorithmException {
	user.setPassword(Encryption.encrypted(user.getPassword()));
	return PeopleCatalog.getInstance().save(user);
    }

    public void update(People people) {
	PeopleCatalog.getInstance().update(people);
    }

    public void delete(int id) throws CanNotDeleteException {
	boolean isPosibleDelete = LoanCatalog.getInstance().hasAnyPendingLoan(id);
	if (isPosibleDelete) {
	    PeopleCatalog.getInstance().delete(id);
	} else {
	    throw new CanNotDeleteException("Can not delete. User has pending loans.");
	}

    }

}
