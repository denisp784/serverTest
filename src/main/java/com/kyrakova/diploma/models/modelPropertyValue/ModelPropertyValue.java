package com.kyrakova.diploma.models.modelPropertyValue;

import com.kyrakova.diploma.models.BaseModel;
import com.kyrakova.diploma.models.model.Model;
import com.kyrakova.diploma.models.modelProperty.CategoryProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ModelPropertyValues")
public class ModelPropertyValue extends BaseModel implements Serializable {
    private String value;
    private Model model;
    private CategoryProperty categoryProperty;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public CategoryProperty getCategoryProperty() {
        return categoryProperty;
    }

    public void setCategoryProperty(CategoryProperty categoryProperty) {
        this.categoryProperty = categoryProperty;
    }
}
