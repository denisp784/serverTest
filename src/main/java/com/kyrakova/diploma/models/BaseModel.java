package com.kyrakova.diploma.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public abstract class BaseModel implements Serializable {
    protected long id;

    public abstract long getId();

    public void setId(long id) {
        this.id = id;
    }
}
