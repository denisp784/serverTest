package com.kyrakova.diploma.models.categoryProperty;

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
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "category")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "property")
    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
