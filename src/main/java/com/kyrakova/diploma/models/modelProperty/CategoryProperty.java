package com.kyrakova.diploma.models.modelProperty;

import com.kyrakova.diploma.models.BaseModel;
import com.kyrakova.diploma.models.category.Category;
import com.kyrakova.diploma.models.property.Property;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CategoryProperties")
public class CategoryProperty extends BaseModel implements Serializable {
    private Category category;
    private Property property;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
