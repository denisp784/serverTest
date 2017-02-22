package com.kyrakova.diploma.models.category;

import com.kyrakova.diploma.models.BaseModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Categories")
public class Category  extends BaseModel implements Serializable {
    @Column(name = "categoryName")
    private String categoryName;

    @Column(name = "imageId",nullable = false)
    private Long imageId;

    private String urlName;

    private Long priority;

    private Long categoryGroupId;

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

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    @JoinColumn(name = "categoryGroupId", nullable = false)
    public Long getCategoryGroupId() {
        return categoryGroupId;
    }

    public void setCategoryGroupId(Long categoryGroupId) {
        this.categoryGroupId = categoryGroupId;
    }
}
