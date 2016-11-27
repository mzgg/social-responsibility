package com.mehmetzahit.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by GUNEY on 25.11.2016.
 */
@Entity(name = "PET_KIND")
public class PetKind implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KIND_ID")
    private int kindId;

    @Column(name = "KIND_NAME")
    private String kindName;


    public PetKind() {
    }

    public PetKind(String kindName) {

        this.kindName = kindName;
    }

    public int getKindId() {
        return kindId;
    }

    public void setKindId(int kindId) {
        this.kindId = kindId;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    @Override
    public String toString() {
        return "PetKind{" +
                "kindId=" + kindId +
                ", kindName='" + kindName + '\'' +
                '}';
    }
}
