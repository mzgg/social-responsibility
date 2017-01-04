package com.mehmetzahit.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by GUNEY on 25.11.2016.
 */
@Entity(name = "PET_RACE")
public class PetRace implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RACE_ID")
    private int raceId;

    @Column(name = "RACE_NAME")
    private String raceName;

    @Column(name = "KIND_ID")
    private int kindId;

    public PetRace() {
    }

    public PetRace(int raceId) {
        this.raceId =raceId;
    }

    public PetRace(String raceName, int kindId) {
        this.raceName = raceName;
        this.kindId = kindId;
    }

    public int getRaceId() {

        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public int getKindId() {
        return kindId;
    }

    public void setKindId(int kindId) {
        this.kindId = kindId;
    }

    @Override
    public String toString() {
        return "PetRace{" +
                "raceId=" + raceId +
                ", raceName='" + raceName + '\'' +
                ", kindId=" + kindId +
                '}';
    }
}
