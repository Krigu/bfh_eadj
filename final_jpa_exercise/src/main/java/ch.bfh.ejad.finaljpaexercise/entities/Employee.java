package ch.bfh.ejad.finaljpaexercise.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Employee extends BaseEntity {

    private String name;

    private BigDecimal salary;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;

    @ManyToOne(cascade = CascadeType.REFRESH, optional = false)
    private Department department;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employee_id")
    private List<Phone> phones;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Employee boss;

    @OneToMany(mappedBy = "boss", cascade = CascadeType.REFRESH)
    private Set<Employee> subordinates = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProjectCollaboration> projects = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    public Set<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public Set<ProjectCollaboration> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectCollaboration> projects) {
        this.projects = projects;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
