package com.kyrakova.diploma.models.category;

import com.kyrakova.diploma.models.BaseModel;
import com.kyrakova.diploma.models.categoryGroup.CategoryGroup;
import com.kyrakova.diploma.models.image.Image;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Categories")
public class Category  extends BaseModel implements Serializable {
    @Column(name = "categoryName")
    private String categoryName;

    @Column(name = "imageId", nullable = false)
    private Long imageId;

    private CategoryGroup categoryGroup;

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

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "categoryGroupId", nullable = false)
    public CategoryGroup getCategoryGroup() {
        return categoryGroup;
    }

    public void setCategoryGroup(CategoryGroup categoryGroup) {
        this.categoryGroup = categoryGroup;
    }
}
