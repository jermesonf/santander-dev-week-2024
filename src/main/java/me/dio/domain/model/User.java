package me.dio.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

/*
 * @author Jermeson
 */

//@Entity -> Cria tabela no banco de dados
@Entity(name = "tb_user")
public class User {

	/*
	 * Adicionado, atributo adicional "id" para que a classes tenha um identificador numerico unico.
	 * @Id -> Especifica que o atributo abaixo é o identificador da tabela (Primary key).
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) -> Especifica que será gerador valor, e esse valor será gerado automaticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	/*
	 * @OneToOne(cascade = CascadeType.ALL) -> Relacionamento/Cardinalidade, 1 para 1, e terá um efeito de cascata exemplo: se for deletado um "Usuario" a "Conta" ligada também será deletada.
	 * Isso faz com que a tabela usuario tenha um chave estrangeira para a tabela Accont e Card e se conectem. 
	 */
	@OneToOne(cascade = CascadeType.ALL)
	private Account account;
	@OneToOne(cascade = CascadeType.ALL)
	private Card card;
	
	/*
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) -> Relacionamento/Cardinalidade, 1 para N(Muitos), efeito de cascata como no exemplo acima e terá um carregamento ansioso/antecipado
	 * fetch = FetchType.EAGER -> buscada imendiatamente quando a entidade principal for buscada.
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Feature> features;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<News> news;
	
	//Getter and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public List<Feature> getFeatures() {
		return features;
	}
	public void setFeatures(List<Feature> features) {
		this.features = features;
	}
	public List<News> getNews() {
		return news;
	}
	public void setNews(List<News> news) {
		this.news = news;
	}
	
	
	
	
}
