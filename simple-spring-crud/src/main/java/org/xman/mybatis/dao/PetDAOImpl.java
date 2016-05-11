package org.xman.mybatis.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.xman.mybatis.db.PetDVO;

import java.util.List;

public class PetDAOImpl implements PetDAO {
    private SqlSessionTemplate sqlSessionTemplate;

    public List<PetDVO> getAllPetsData() {
        return sqlSessionTemplate.selectList("getAllPets");
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
}