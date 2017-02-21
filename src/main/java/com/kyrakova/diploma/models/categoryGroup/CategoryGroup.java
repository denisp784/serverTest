package com.kyrakova.diploma.models.categoryGroup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrakova.diploma.models.BaseModel;
import com.kyrakova.diploma.models.category.Category;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;
import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Entity
@Table(name = "CategoryGroups")
public class CategoryGroup extends BaseModel implements Serializable {
    @Column(name = "categoryGroupName")
    private String categoryGroupName;

    private Long sectionId;

    private List<Category> categories = new ArrayList<Category>(0);

    private Long priority;

    public CategoryGroup() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public String getCategoryGroupName() {
        return categoryGroupName;
    }

    public void setCategoryGroupName(String categoryGroupName) {
        this.categoryGroupName = categoryGroupName;
    }

    @JoinColumn(name = "sectionId", nullable = false)
    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public void addCategory(Category category) {
        getCategories().add(category);
    }

    @JsonProperty(access = READ_ONLY)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "categoryGroup")
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }
}
