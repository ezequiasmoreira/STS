package com.ezequias.apiestudo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ezequias.apiestudo.domain.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Vendedor obj WHERE obj.id = :id ")
	Vendedor obterPorId(@Param("id") Integer id);
}
