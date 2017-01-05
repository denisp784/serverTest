package com.kyrakova.diploma.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public abstract class BaseModel implements Serializable {
    protected Long id;
    public abstract Long getId();

    public void setId(Long id) {
        this.id = id;
    }
}
