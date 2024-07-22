package me.dio.controller;

import java.net.URI;

import me.dio.domain.model.User;
import me.dio.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
/*
 * @RestController - Especifica que a classe é um controlador
 * @RequestMapping("/users") - Especifica que para acessar esta rota deve colocar no navegador (localhost:8080/users)
 */
@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService)
	{
		this.userService = userService;
	}
	
	
	/*
	 * @PathVariable - captura o "id" da rota do navegador (localhost:8080/users/{id}) e lança o valor para dentro do metodo
	 */
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		var user = userService.findById(id);
		return ResponseEntity.ok(user);
	}
	
	

	/*
	 * @PostMapping("/{id}") - Envia a requisição para o endpoint ({id}).
	 * @RequestBody - Converte as informações para o tipo que for especificado.
	 * URI - Cria endereçamentos, ao fazer um perfil a URI(Uniform Resource Identifier) cria um endereçamento fixo e unico para este usuario, tipo o perfil de alguem que se cadastrou em alguma rede social.
	 */
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User userToCreate){
		var userCreated = userService.create(userToCreate);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(userCreated.getId())
				.toUri();
		//acessar a url criada pelo (URI) e mostra o usuario
		return ResponseEntity.created(location).body(userCreated);
	}
}
