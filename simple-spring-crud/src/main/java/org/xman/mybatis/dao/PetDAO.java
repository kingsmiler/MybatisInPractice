package org.xman.mybatis.dao;

import org.xman.mybatis.db.PetDVO;

import java.util.List;

public interface PetDAO {

    List<PetDVO> getAllPetsData();
    List<String> getAllSpecies();
    List<PetDVO> selectPets(String sex);
    PetDVO getPetObject(String petName);
    int createPet(PetDVO petDVO);
}