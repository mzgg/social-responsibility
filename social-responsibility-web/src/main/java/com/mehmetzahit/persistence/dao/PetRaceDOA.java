package com.mehmetzahit.persistence.dao;

import com.mehmetzahit.model.PetRace;
import java.util.List;


/**
 * Created by GUNEY on 25.11.2016.
 */

public interface PetRaceDOA {

    List<PetRace> petRaceList();
    List<PetRace> findRaceByKind(int kindId);

}
