package com.kyrakova.diploma.models.category;

import com.kyrakova.diploma.models.BaseModel;
import com.kyrakova.diploma.models.image.Image;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Categories")
public class Category  extends BaseModel implements Serializable {
    @Column(name = "categoryName")
    private String categoryName;
    private Image image;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
