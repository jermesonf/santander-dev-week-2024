// impl = implements, este é um pacote de implementações
package me.dio.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;

/*
 * @Service -> Especifica para que esta classe seja tratada como um service/serviço.
 * 
 */
@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User create(User userToCreate) {
		/*
		 * Primeiro, verifica se já existe um usuário com o número de conta especificado
		 * (userToCreate.getAccount().getNumber()). Se já existir, lança uma exceção do
		 * tipo IllegalArgumentException com a mensagem “This User ID already exists.”
		 * Isso significa que o número de conta fornecido já está associado a outro
		 * usuário. Caso contrário, salva o novo usuário (userToCreate) no repositório
		 * (banco de dados) usando o método userRepository.save(userToCreate).
		 */
		if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
			throw new IllegalArgumentException("This Account number already exists.");
		}
		return userRepository.save(userToCreate);
	}

}
