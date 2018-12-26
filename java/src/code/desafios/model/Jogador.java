package code.desafios.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {

	private Long id;
	private Time time;
	private String nome;
	private LocalDate dataNascimento;
	private Integer nivelHabilidade;  // (0 a 100)
	private BigDecimal salario;
	
	
	public Jogador() { }
	
	public Jogador(Long id, Time time, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		this.id = id;
		this.time = time;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.nivelHabilidade = nivelHabilidade;
		this.salario = salario;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Jogador)) return false;
		return ((Jogador)obj).id.longValue() == this.id.longValue();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Integer getNivelHabilidade() {
		return nivelHabilidade;
	}
	public void setNivelHabilidade(Integer nivelHabilidade) {
		this.nivelHabilidade = nivelHabilidade;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
			
}
