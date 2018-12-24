package code.desafios;

import static org.junit.Assert.*;
import static code.desafios.TimeInMemoryBD.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DesafioCodenation1Test {

	private DesafioCodenation1 desafio;
	
	@Before
	public void setup() {
		desafio = new DesafioCodenation1();
		bancoDeDadosTimes.clear();
		bancoDeDadosJogadores.clear();
	}
	
	@After
	public void tearDown() {
		desafio = null;
	}
	
	@Test
	public void testIncluirTime_differentTimes_shouldInsertBoth() {
		desafio.incluirTime(10L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.incluirTime(20L, "other_nome", LocalDate.now(), "other_corUniformePrincipal", "other_corUniformeSecundario");
		assertEquals(2, bancoDeDadosTimes.size());
	}
	
	@Test(expected=IdentificadorUtilizadoException.class)
	public void testIncluirTime_timeAlreadyExists_shouldThrowException() {
		desafio.incluirTime(10L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.incluirTime(10L, "other_nome", LocalDate.now(), "other_corUniformePrincipal", "other_corUniformeSecundario");
	}

	@Test
	public void testIncluirJogador_newJogadores_shouldInsertBoth() {
		// given
		desafio.incluirTime(10L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		// when
		desafio.incluirJogador(2L, 10L, "nome", LocalDate.now(), 100, new BigDecimal(100));
		desafio.incluirJogador(3L, 10L, "nome", LocalDate.now(), 100, new BigDecimal(100));
		// then
		assertEquals(2, bancoDeDadosJogadores.size());
	}
	
	@Test(expected = TimeNaoEncontradoException.class)
	public void testIncluirJogador_nonExistingTime_shouldThrowException() {
		desafio.incluirTime(10L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.incluirJogador(2L, 20L, "nome", LocalDate.now(), 100, new BigDecimal(100));
	}
	
	@Test(expected = IdentificadorUtilizadoException.class)
	public void testIncluirJogador_sameJogadorId_shouldThrowException() {
		desafio.incluirTime(10L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.incluirJogador(2L, 10L, "nome", LocalDate.now(), 100, new BigDecimal(100));
		desafio.incluirJogador(2L, 10L, "nome", LocalDate.now(), 100, new BigDecimal(100));
	}

	@Test
	public void testDefinirCapitao() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarCapitaoDoTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarNomeJogador() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarNomeTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarJogadoresDoTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarMelhorJogadorDoTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarJogadorMaisVelho() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarTimes() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarJogadorMaiorSalario() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarSalarioDoJogador() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarTopJogadores() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarCorCamisaTimeDeFora() {
		fail("Not yet implemented");
	}

}
