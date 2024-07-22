package me.dio.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_account")
public class Account {

	/*
	 * Adicionado, atributo adicional "id" para que a classes tenha um identificador numerico unico.
	 * @Id -> Especifica que o atributo abaixo é o identificador da tabela (Primary key).
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) -> Especifica que será gerador valor, e esse valor será gerado automaticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*
	 * @Column(unique = true) -> Ao gerar está coluna a informação(number) será unica ou seja não podera ter duas informções iguais.
	 * Com isso faz com que gera uma constraint (restrição/regra).
	 */
	@Column(unique = true)
	private String number;
	
	private String agency;
	
	/*
	 * @Column(scale = 13, precision = 2) -> Ao gerar está coluna a informação(balance e limit), terá uma
	 * 13 números e 2 números depois da virgula exemplo: 1234567890123,12.
	 * 
	 * obs: em alguns bancos de dados a palavra "limit" é reservada e por isso utilizamos o parametro (name = "nome_da_coluna").
	 * pode incrementar o parametro (nullable = false) -> assim não sera aceitos valores nulos.
	 */
	@Column(precision = 13, scale = 2)
	private BigDecimal balance;
	@Column(name = "additional_limit", precision = 13, scale = 2)
	private BigDecimal limit;
	
	//Getter and Setters
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public Number getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Number getLimit() {
		return limit;
	}
	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}
	
	
}
