package com.kyrakova.diploma.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public abstract class BaseModel implements Serializable {
    protected int id;
    public abstract int getId();

    public void setId(int id) {
        this.id = id;
    }
}
