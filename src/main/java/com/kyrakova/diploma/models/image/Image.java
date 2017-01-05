package com.kyrakova.diploma.models.image;

import com.kyrakova.diploma.models.BaseModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Images")
public class Image extends BaseModel implements Serializable {
    private String name;
    private byte[] image;

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
