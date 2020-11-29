package com.ezequias.apiestudo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ezequias.apiestudo.domain.Meta;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Meta obj WHERE obj.id = :id ")
	Meta obterPorId(@Param("id") Long id);

}
