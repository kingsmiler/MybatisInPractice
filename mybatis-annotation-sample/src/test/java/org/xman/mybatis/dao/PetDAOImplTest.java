package org.xman.mybatis.dao;


import org.junit.Test;
import org.xman.mybatis.db.PetDVO;

import java.util.Date;
import java.util.List;

public class PetDAOImplTest {
    private PetDAOImpl petDAOImpl = new PetDAOImpl();

    @Test
    public void getPetObject() throws Exception {
        PetDVO pet = petDAOImpl.getPetObject("Fluffy");
        System.out.println("----- pet ------" + pet);
    }

    @Test
    public void getAllPetsData() throws Exception {
        List<PetDVO> allPets = petDAOImpl.getAllPetsData();
        System.out.println("----- size ------" + allPets.size());
    }

    @Test
    public void selectPets() throws Exception {
        List<PetDVO> allPetsData = petDAOImpl.selectPets("f");
        System.out.println("----- size ------" + allPetsData.size());
    }

    @Test
    public void selectAllPets() throws Exception {
        List<PetDVO> allPetsData = petDAOImpl.selectAllPets();
        System.out.println("----- size ------" + allPetsData.size());
    }

    @Test
    public void updatePetData() throws Exception {
        PetDVO petDataObj = new PetDVO();
        petDataObj.setName("Slimmmy");
        petDataObj.setSex("m");
        petDataObj.setBirth(new Date());

        petDAOImpl.updatePetData(petDataObj);
    }

    @Test
    public void updateData() throws Exception {
        PetDVO petDataObj = new PetDVO();
        petDataObj.setName("Slimmmy");
        petDataObj.setSex("m");
        petDataObj.setBirth(new Date());

        petDAOImpl.updateData(new Date(), "m", "Slim");
    }

    @Test
    public void deletePet() throws Exception {
        PetDVO petDVO = new PetDVO();
        petDVO.setName("Slimmmy1");
        petDVO.setSpecies("snake");

        petDAOImpl.deletePet(petDVO);
    }

    @Test
    public void insertPet() throws Exception {
        PetDVO petObj = new PetDVO();
        petObj.setName("Slimmy");
        petObj.setOwner("Danny");
        petObj.setSpecies("snake");
        petObj.setSex("f");
        petObj.setBirth(new Date());

        petDAOImpl.insertPet(petObj);
    }
}
