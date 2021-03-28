package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestEntity {
    @Id
    private int a;

    public TestEntity(){

    }

    public TestEntity(int a){
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
