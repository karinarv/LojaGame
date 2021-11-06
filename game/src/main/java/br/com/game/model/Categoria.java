package br.com.game.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Modela as informações do Banco de dados

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_categoria;

	@NotBlank(message = "O valor não pode ser nulo e nem pode conter espaço")
	@Size(min = 2, max = 50, message = "Nesse texto o mínimo é 2 e o máximo 50 caracteres")
	private String genero;

	@NotBlank(message = "O valor não pode ser nulo e nem pode conter espaço")
	@Size(min = 2, max = 20, message = "Nesse texto o mínimo é 2 e o máximo 20 caracteres")
	private String plataforma;

	@NotBlank(message = "O valor não pode ser nulo e nem pode conter espaço")
	@Size(min = 2, max = 50, message = "Nesse texto o mínimo é 2 e o máximo 50 caracteres")
	private String condicao;

	// mappedBy -> De onde eu estou mapeando
	// Cascate -> O que uma tabela fizer, funcionará na outras

	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria") // Mostra apenas a categoria que foi mostrada
	private List<Produto> produto; // Trás o produto

	public long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

}
