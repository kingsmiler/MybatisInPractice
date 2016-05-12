package org.xman.mybatis.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.xman.mybatis.db.PetDVO;
import org.xman.mybatis.mapper.PetMapper;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class PetDAOImpl {
    // Loads the configuration settings, creates a sql session.
    private static SqlSession getSqlSession() throws Exception {
        String resource = "java-mybatis-config.xml";
        InputStream inputStream =
                Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        sqlSessionFactory.getConfiguration().
                addMapper(PetMapper.class);

        return sqlSessionFactory.openSession();
    }

    public List<PetDVO> getAllPetsData() throws Exception {
        PetMapper mapper = getSqlSession().getMapper(PetMapper.class);
        return mapper.getAllPetsData();
    }

    public PetDVO getPetObject(String petName) throws Exception {
        PetMapper mapper = getSqlSession().getMapper(PetMapper.class);
        return mapper.getPetObject(petName);
    }

    public List<PetDVO> selectAllPets() throws Exception {
        PetMapper mapper = getSqlSession().getMapper(PetMapper.class);
        return mapper.selectAllPets();
    }

    public List<PetDVO> selectPets(String sex) throws Exception {
        PetMapper mapper = getSqlSession().getMapper(PetMapper.class);
        return mapper.selectPets(sex);
    }

    public void updatePetData(PetDVO petDVO) throws Exception {
        SqlSession sqlSession = getSqlSession();
        PetMapper mapper = sqlSession.getMapper(PetMapper.class);
        mapper.updatePetData(petDVO);
        sqlSession.commit();
    }

    public void updateData(Date birth, String sex, String name) throws Exception {
        SqlSession sqlSession = getSqlSession();
        PetMapper mapper = sqlSession.getMapper(PetMapper.class);
        mapper.updateData(birth, sex, name);
        sqlSession.commit();
    }

    public void deletePet(PetDVO petDVO) throws Exception {
        SqlSession sqlSession = getSqlSession();
        PetMapper mapper = sqlSession.getMapper(PetMapper.class);
        mapper.deletePet(petDVO);
        sqlSession.commit();
    }

    public void insertPet(PetDVO petDVO) throws Exception {
        SqlSession sqlSession = getSqlSession();
        PetMapper mapper = sqlSession.getMapper(PetMapper.class);
        mapper.insertPet(petDVO);
        sqlSession.commit();
        // Printing the generated key value
        System.out.println("--- Id value ---" + petDVO.getId());
    }
}