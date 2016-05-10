package org.xman.mybatis;

import org.junit.Test;
import org.xman.mybatis.db.PetDVO;

import java.util.Date;
import java.util.List;

public class PetDaoTest {
    PetDao petDao = new PetDao();

    @Test
    public void testCreatePet() throws Exception {
        PetDVO pet = new PetDVO();
        pet.setName("Slimmmy");
        pet.setOwner("Suk");
        pet.setSpecies("snake");
        pet.setBirth(new Date());
        pet.setSex("m");

        petDao.createPet(pet);
    }

    @Test
    public void testGetAllPetsData() throws Exception {
        List<PetDVO> allPets = petDao.getAllPetsData();
        System.out.println("--- allPets ----" + allPets.size());
    }

}
