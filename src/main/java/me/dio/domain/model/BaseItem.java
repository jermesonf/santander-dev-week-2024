package me.dio.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/*
 * As classes Feature e News usam o mesmo Código e de acordo com o conceito 
 * DRY - Don't Repeater Yourself - Não duplicar codigos em um sistema.
 * Criamos um nova classe abstrata(abstract) e utilizamos @MappedSuperclass para que as outras classes
 * possam herdar(extends) BaseItem.
 */
@MappedSuperclass
public abstract class BaseItem {

	/*
	 * Adicionado, atributo adicional "id" para que a classes tenha um identificador numerico unico.
	 * @Id -> Especifica que o atributo abaixo é o identificador da tabela (Primary key).
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) -> Especifica que será gerador valor, e esse valor será gerado automaticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	private String icon;
	private String description;
		
	//Getter and Setters
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
		
	
}
