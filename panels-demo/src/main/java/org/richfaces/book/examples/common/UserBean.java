package org.richfaces.book.examples.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean {
    @Length(min=3, max=15)
	private String name = "";
    private String email = "";
    private String password = "";
    private String address;
    @Min(value=18, message="You should be over 18 years to place orders")
    private Integer age;
    private String city;
    private String job;
    private String recordStatus;
    private String zip;

    public UserBean() {
        super();
    }

    public void store() {
        this.recordStatus = "User " + this.name + " stored succesfully";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String nameItJohn() {
        setName("John");

        return null;
    }

    public String nameItMark() {
        setName("Mark");

        return null;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
