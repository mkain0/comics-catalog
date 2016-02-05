package javaProject.catalogComics.model;

public class Admin implements People {

    private int id;
    private String username;
    private String password;
    private String lastName;
    private String firstName;

    public Admin(int id, String username, String password, String lastName, String firstName) {
	this.id = id;
	this.username = username;
	this.password = password;
	this.lastName = lastName;
	this.firstName = firstName;
    }

    public Admin(String username, String password, String lastName, String firstName) {
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
    public String toString() {
	return "Id: " + id + ", Username: " + username + ", Last Name: " + lastName + ", First Name: " + firstName;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Admin other = (Admin) obj;
	if (username == null) {
	    if (other.username != null)
		return false;
	} else if (!username.equals(other.username))
	    return false;
	return true;
    }

}
