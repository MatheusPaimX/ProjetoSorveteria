package br.com.tech4me.caixadesorvete.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.caixadesorvete.model.CaixaSorvete;

public interface CaixaSorveteRepository extends MongoRepository<CaixaSorvete, String>{
    
}
