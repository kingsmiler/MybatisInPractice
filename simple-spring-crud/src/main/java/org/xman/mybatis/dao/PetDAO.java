package org.xman.mybatis.dao;

import org.xman.mybatis.db.PetDVO;

import java.util.List;

public interface PetDAO {

    List<PetDVO> getAllPetsData();
}