package me.dio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.domain.model.User;

/*
 * Interface do Usuario 
 * 
 * JpaRepository<T, ID> -> T = (Nome da Classe da Entidade), ID = (Tipo do identificador) 
 * @Repository -> Especifica que é um repositorio de dados e permite que o framework forneça recursos adicionais para essas classes. 
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	boolean existsByAccountNumber(String accountNumber);

}
