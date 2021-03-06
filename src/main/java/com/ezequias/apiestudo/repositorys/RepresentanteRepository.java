package com.ezequias.apiestudo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ezequias.apiestudo.domain.Representante;

@Repository
public interface RepresentanteRepository extends JpaRepository<Representante, Integer>{

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Representante obj WHERE obj.id = :id ")
	Representante obterPorId(@Param("id") Integer id);
}
