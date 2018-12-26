package code.desafios;

import static code.desafios.InMemoryMockBD.bancoDeDadosJogadores;
import static code.desafios.InMemoryMockBD.bancoDeDadosTimes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		Jogador jogador = obterJogador(idJogador);
		Time time = jogador.getTime();
		time.setCapitao(jogador);
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		Time time = obterTime(idTime);
		if (time.getCapitao() == null) throw new CapitaoNaoInformadoException();
		return time.getCapitao().getId();
	}

	public String buscarNomeJogador(Long idJogador) {
		Jogador jogador = obterJogador(idJogador);
		return jogador.getNome();
	}

	public String buscarNomeTime(Long idTime) {
		Time time = obterTime(idTime);
		return time.getNome();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		Time time = obterTime(idTime);
		List<Long> ids = bancoDeDadosJogadores.stream()
				.filter(j -> j.getTime().getId().longValue() == time.getId().longValue())
				.sorted((j1, j2) -> j1.getId().compareTo(j2.getId()))
				.map(j -> j.getId())
				.collect(Collectors.toList());
		return ids;
		
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
	
	
	private Jogador obterJogador(Long idJogador) {
		Optional<Jogador> jogadorEncontrado = bancoDeDadosJogadores.stream().filter(j -> j.getId().longValue() == idJogador).findFirst();
		return jogadorEncontrado.orElseThrow(JogadorNaoEncontradoException::new);
	}
	
	private Time obterTime(Long idTime) {
		Optional<Time> timeEncontrado = bancoDeDadosTimes.stream().filter(t -> t.getId().longValue() == idTime).findFirst();
		return timeEncontrado.orElseThrow(TimeNaoEncontradoException::new);
	}

}
