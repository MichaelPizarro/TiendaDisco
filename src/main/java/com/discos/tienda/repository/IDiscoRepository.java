package com.discos.tienda.repository;

import com.discos.tienda.model.Disco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiscoRepository extends JpaRepository<Disco,Integer> {
}
