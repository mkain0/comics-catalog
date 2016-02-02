package javaProject.catalogComics.model;

public class User implements People {

    private int id;
    private String username;
    private String password;
    private String lastName;
    private String firstName;

    public User(int id, String username, String password, String lastName, String firstName) {
	this.id = id;
	this.username = username;
	this.password = password;
	this.lastName = lastName;
	this.firstName = firstName;
    }

    public User(String username, String password, String lastName, String firstName) {
	this.username = username;
	this.password = password;
	this.lastName = lastName;
	this.firstName = firstName;
    }

    @Override
    public int getId() {
	return id;
    }

    @Override
    public void setId(int id) {
	this.id = id;
    }

    @Override
    public String getUsername() {
	return username;
    }

    @Override
    public void setUsername(String username) {
	this.username = username;
    }

    @Override
    public String getPassword() {
	return password;
    }

    @Override
    public void setPassword(String password) {
	this.password = password;
    }

    @Override
    public String getLastName() {
	return lastName;
    }

    @Override
    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
	return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    @Override
    public void displayMenu() {
	// TODO Auto-generated method stub

    }

    @Override
    public String toString() {
	return "Id: " + id + ", Username: " + username + ", Last Name: " + lastName + ", First Name: " + firstName;
    }

}
