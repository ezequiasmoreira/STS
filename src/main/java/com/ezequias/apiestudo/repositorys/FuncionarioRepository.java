package com.ezequias.apiestudo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ezequias.apiestudo.domain.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Funcionario obj WHERE obj.id = :id ")
	Funcionario obterPorId(@Param("id") Integer id);
}
