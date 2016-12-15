package com.mehmetzahit.persistence.dao;

import com.mehmetzahit.model.Advertisement;
import com.mehmetzahit.model.Search;

import java.util.List;

/**
 * Created by GUNEY on 7.12.2016.
 */
public interface SearchDAO {
    List<Advertisement> searchList(Search search);
}
