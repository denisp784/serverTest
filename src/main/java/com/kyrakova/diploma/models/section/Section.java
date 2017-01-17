package com.kyrakova.diploma.models.section;

import com.kyrakova.diploma.models.BaseModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Sections")
public class Section extends BaseModel implements Serializable {
    @Column(name="sectionName")
    private String sectionName;

    @Column(name = "imageId")
    private Long imageId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }
}
