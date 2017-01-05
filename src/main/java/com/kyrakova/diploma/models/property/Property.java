package com.kyrakova.diploma.models.property;

import com.kyrakova.diploma.models.BaseModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Properties")
public class Property extends BaseModel implements Serializable {
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
