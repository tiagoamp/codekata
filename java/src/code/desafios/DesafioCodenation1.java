package code.desafios;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static code.desafios.InMemoryMockBD.*;

public class DesafioCodenation1  {
		
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		if (bancoDeDadosTimes.contains(time)) throw new IdentificadorUtilizadoException();
		bancoDeDadosTimes.add(time);
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		Optional<Time> time = bancoDeDadosTimes.stream().filter(t -> t.getId().longValue() == idTime.longValue()).findFirst();
		Time timeDoJogador = time.orElseThrow(TimeNaoEncontradoException::new);
		Jogador jogador = new Jogador(id, timeDoJogador, nome, dataNascimento, nivelHabilidade, salario);
		if (bancoDeDadosJogadores.contains(jogador)) throw new IdentificadorUtilizadoException();
		bancoDeDadosJogadores.add(jogador);
	}

	public void definirCapitao(Long idJogador) {
		Optional<Jogador> jogadorEncontrado = obterJogador(idJogador);
		Jogador jogador = jogadorEncontrado.orElseThrow(JogadorNaoEncontradoException::new);
		Time time = jogador.getTime();
		time.setCapitao(jogador);
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public String buscarNomeJogador(Long idJogador) {
		throw new UnsupportedOperationException();
	}

	public String buscarNomeTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public List<Long> buscarTimes() {
		throw new UnsupportedOperationException();
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		throw new UnsupportedOperationException();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		throw new UnsupportedOperationException();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		throw new UnsupportedOperationException();
	}

	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		throw new UnsupportedOperationException();
	}
	
	
	private Optional<Jogador> obterJogador(Long idJogador) {
		return bancoDeDadosJogadores.stream().filter(j -> j.getId().longValue() == idJogador).findFirst();
	}

}
