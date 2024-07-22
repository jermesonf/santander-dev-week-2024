package me.dio.service;

import me.dio.domain.model.User;

/*
 * Em interfaces criamos os métodos/funções para depois implementalos dentro de classes como no "UserServiceImpl" 
 */
public interface UserService {
	
	User findById(Long id);
	
	User create(User userToCreate);
	
	
}
