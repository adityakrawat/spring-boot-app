package com.springboot.springbootapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @Column
    private String id;

    @Column(name = "PRODUCT_NAME")
    private String name;

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringBuilder()
        .append("Product [")
        .append("id="+id)
        .append(", name="+name)
        .append("]").toString();
    }

}
