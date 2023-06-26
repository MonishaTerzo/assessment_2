package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;

@Entity
public class role {
    @Id
    private int id;
    private String rname;
    @OneToMany(mappedBy = "r")
    ArrayList<employee> arr;


    public int getId() {
        return id;
    }

    public String getRname() {
        return rname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public ArrayList<employee> getArr() {
        return arr;
    }

    public void setArr(ArrayList<employee> arr) {
        this.arr = arr;
    }
}
