package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;

@Entity

public class department {

    @Id
    private int id;

    private String dname;
    @OneToMany(mappedBy = "d")
    ArrayList<employee> arr;

    public int getId() {
        return id;
    }

    public String getName() {
        return dname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String dname) {
        this.dname = dname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public ArrayList<employee> getArr() {
        return arr;
    }

    public void setArr(ArrayList<employee> arr) {
        this.arr = arr;
    }
}
