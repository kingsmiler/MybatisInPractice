package org.xman.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xman.mybatis.dao.PetDAO;
import org.xman.mybatis.db.PetDVO;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({@ContextConfiguration(
        locations = {"classpath*:applicationContext.xml"}
)})
public class PetDaoTest {
    @Autowired
    private PetDAO petDAO;

    @Test
    public void testCreatePet() throws Exception {
        PetDVO pet = new PetDVO();
        pet.setName("Sunny");
        pet.setOwner("Wang");
        pet.setSpecies("snake");
        pet.setBirth(new Date());
        pet.setSex("m");

        List<PetDVO> list = petDAO.getAllPetsData();
        System.out.println(list.size());
    }

}
