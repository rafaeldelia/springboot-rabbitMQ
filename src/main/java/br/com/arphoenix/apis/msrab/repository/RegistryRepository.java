package br.com.arphoenix.apis.msrab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arphoenix.apis.msrab.model.Registry;

@Repository
public interface RegistryRepository extends JpaRepository<Registry, Long> {

}
