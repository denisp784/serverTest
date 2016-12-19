package com.kyrakova.diploma.models.role;

import com.kyrakova.diploma.models.BaseDao;
import com.kyrakova.diploma.models.BaseModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Roles")
public class Role extends BaseModel implements Serializable {
    private String name;
    private String options;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
