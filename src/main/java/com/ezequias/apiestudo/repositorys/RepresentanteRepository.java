package com.ezequias.apiestudo.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezequias.apiestudo.domain.Representante;
import com.ezequias.apiestudo.domain.Vendedor;

@Repository
public interface RepresentanteRepository extends JpaRepository<Representante, Integer>{

}
