package br.com.everton.bateconta.batecontacloud.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.everton.bateconta.batecontacloud.model.Conta;

@Repository
public interface ContaRepository extends MongoRepository<Conta, String>{

	List<Conta> findContaByProduto(String produto);

	List<Conta> findContaByUsuario(String usuario);
}
