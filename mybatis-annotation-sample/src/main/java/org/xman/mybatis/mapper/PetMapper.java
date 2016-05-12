package org.xman.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import org.xman.mybatis.db.PetDVO;

import java.util.Date;
import java.util.List;

public interface PetMapper {
    // Selecting a single pet
    @Select("SELECT ID as id, NAME as name, OWNER as owner,SPECIES as" +
            " species, SEX as sex, " +
            " BIRTH as birth, DEATH as death " +
            " FROM pet where name = #{name} ")
    public PetDVO getPetObject(String petName);

    // Selecting all pets
    @Select("SELECT * FROM PET")
    @Results(value = {
            @Result(property = "id", column = "ID"),
            @Result(property = "name", column = "NAME"),
            @Result(property = "owner", column = "OWNER"),
            @Result(property = "species", column = "SPECIES"),
            @Result(property = "sex", column = "SEX")
    })
    List<PetDVO> selectAllPets();

    // Selecting all pets
    @Select(" SELECT ID as id, NAME as name, OWNER as owner, SPECIES as " +
            " species,SEX as sex, BIRTH as birth, DEATH as death FROM pet")
    public List<PetDVO> getAllPetsData();

    // Select all matching pets based on a criteria
    @Select(" SELECT ID as id, NAME as name, OWNER as owner, SPECIES as" +
            " species, SEX as sex, BIRTH as birth, DEATH as death" +
            " FROM pet where sex = #{sex} ")
    public List<PetDVO> selectPets(String sex);

    // Updating pet data
    @Update("UPDATE pet p SET p.birth = #{birth}, p.sex = #{sex} WHERE "
            + " p.name = #{name} ")
    public void updatePetData(PetDVO petDVO);

    // Updating pet data
    @Update(" UPDATE pet SET birth = #{birth}, sex = #{sex} " + " WHERE name = #{name} ")
    public void updateData(@Param("birth") Date birth,
                           @Param("sex") String sex,
                           @Param("name") String name);

    // Deleting pet data
    @Delete(" DELETE FROM pet WHERE name = #{name} " +
            " AND species = #{species} ")
    public void deletePet(PetDVO petDVO);

    // Inserting a new record
    @Insert(" INSERT INTO pet (ID, NAME, OWNER, SPECIES, SEX, BIRTH) " +
            " VALUES (#{id}, #{name}, #{owner}, #{species}, #{sex}, " +
            " #{birth}) ")
    @SelectKey(statement = "SELECT PET_ID_SEQ.nextval AS id FROM dual",
            keyProperty = "id",
            before = true,
            resultType = int.class)
    public void insertPet(PetDVO petDVO);
}