package org.example;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class employee {
    @Id
    private int id;
    private String name;

    private int salary;



    public department getD() {
        return d;
    }

    public role getR() {
        return r;
    }

    public void setD(department d) {
        this.d = d;
    }

    public void setR(role r) {
        this.r = r;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    department d;
    @ManyToOne
    role r;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public int getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", d=" + d +
                ", r=" + r +
                '}';
    }
}
