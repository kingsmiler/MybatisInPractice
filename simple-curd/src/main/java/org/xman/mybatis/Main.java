package org.xman.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.xman.mybatis.db.PetDVO;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            Main main = new Main();
            // Printing pets data
            List<PetDVO> allPets = main.getAllPetsData();
            System.out.println("--- allPets ----" + allPets.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static SqlSession getSqlSession() throws Exception {
        String resource = "core-mybatis-config.xml";
        InputStream inputStream =
                Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession();
    }

    public List<PetDVO> getAllPetsData() throws Exception {
        return getSqlSession().selectList("getAllPets");
    }

    public PetDVO getPetObject(String petName) throws Exception {
        HashMap<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("name", petName);
        return (PetDVO) getSqlSession().selectOne("getPetObject", inputMap);
    }

    public List<String> getAllSpecies() throws Exception {
        return getSqlSession().selectList("getAllSpecies");
    }

    public List<PetDVO> selectPets(String sex) throws Exception {
        HashMap<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("sex", sex);
        return getSqlSession().selectList("selectPets", inputMap);
    }
}
