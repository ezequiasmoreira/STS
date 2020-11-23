package com.ezequias.apiestudo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ezequias.apiestudo.domain.Salario;

@Repository
public interface SalarioRepository extends JpaRepository<Salario, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Salario obj WHERE obj.id = :id ")
	Salario obterPorId(@Param("id") Integer id);
}
