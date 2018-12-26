package code.desafios;

import static code.desafios.repo.InMemoryMockDB.bancoDeDadosJogadores;
import static code.desafios.repo.InMemoryMockDB.bancoDeDadosTimes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import code.desafios.exception.CapitaoNaoInformadoException;
import code.desafios.exception.IdentificadorUtilizadoException;
import code.desafios.exception.JogadorNaoEncontradoException;
import code.desafios.exception.TimeNaoEncontradoException;
import code.desafios.model.Jogador;
import code.desafios.model.Time;

public class Desafio1  {
		
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
				.sorted(Comparator.comparing(Jogador::getId))
				.map(j -> j.getId())
				.collect(Collectors.toList());
		return ids;
		
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		List<Long> idsJogadoresDoTime = buscarJogadoresDoTime(idTime);
		List<Jogador> jogadoresDoTime = idsJogadoresDoTime.stream().map(id -> obterJogador(id)).collect(Collectors.toList());
		Long idMelhorJogador = jogadoresDoTime.stream()
				.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed())
				.map(j -> j.getId())
				.findFirst().orElse(null);
		return idMelhorJogador;
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		List<Long> idsJogadoresDoTime = buscarJogadoresDoTime(idTime);
		List<Jogador> jogadoresDoTime = idsJogadoresDoTime.stream().map(id -> obterJogador(id)).collect(Collectors.toList());		
		Jogador jogadorMaisVelho = jogadoresDoTime.stream()
				.sorted(Comparator.comparing(Jogador::getDataNascimento).thenComparing(Jogador::getId))
				.findFirst().get();		
		return jogadorMaisVelho.getId();
	}

	public List<Long> buscarTimes() {
		List<Long> idsTimes = bancoDeDadosTimes.stream()
				.sorted(Comparator.comparing(Time::getId))
				.map(t -> t.getId())
				.collect(Collectors.toList());
		return idsTimes;		
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		List<Long> idsJogadoresDoTime = buscarJogadoresDoTime(idTime);
		List<Jogador> jogadoresDoTime = idsJogadoresDoTime.stream().map(id -> obterJogador(id)).collect(Collectors.toList());		
		Jogador jogadorComMaiorSalario = jogadoresDoTime.stream()
			.sorted(Comparator.comparing(Jogador::getSalario).reversed().thenComparing(Jogador::getId))
			.findFirst().get();			
		return jogadorComMaiorSalario.getId();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		Jogador jogador = obterJogador(idJogador);
		return jogador.getSalario();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> idsTopsJogadores = bancoDeDadosJogadores.stream()
				.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed().thenComparing(Jogador::getId))
				.limit(top.longValue())
				.map(j -> j.getId())
				.collect(Collectors.toList());
		return idsTopsJogadores;
	}

	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		Time timeCasa = obterTime(timeDaCasa);
		Time timeFora = obterTime(timeDeFora);
		return timeCasa.getCorUniformePrincipal().equals(timeFora.getCorUniformePrincipal()) ? timeFora.getCorUniformeSecundario() : timeFora.getCorUniformePrincipal();		
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
