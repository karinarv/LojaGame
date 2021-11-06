package br.com.game.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")

public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_produto;

	@NotBlank(message = "O valor não pode ser nulo e nem pode conter espaço")
	@Size(min = 4, max = 100, message = "O texto deve conter o mínimo de 4 caracteres e o máximo de 100")
	private String titulo;

	@NotBlank(message = "O valor não pode ser nulo e nem pode conter espaço")
	private double preco;

	@ManyToOne // N : 1
	@JsonIgnoreProperties("categoria") // Não permite repetir informações[Não repetir o nome do Jogo várias vezes]
	private Categoria categoria;

	public long getId_produto() {
		return id_produto;
	}

	public void setId_produto(long id_produto) {
		this.id_produto = id_produto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
