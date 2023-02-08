package br.com.tech4me.casquinha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.casquinha.model.Casquinha;

public interface CasquinhaRepository extends MongoRepository<Casquinha,String>{
    
}
