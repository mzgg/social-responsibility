package com.mehmetzahit.persistence.dao;

import com.mehmetzahit.model.District;

import java.util.List;

/**
 * Created by GUNEY on 27.11.2016.
 */
public interface DistrictDAO {
    List<District> districtList(int cityId);
}
