package code.desafios;

import static org.junit.Assert.*;
import static code.desafios.InMemoryMockBD.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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

	@Test(expected = JogadorNaoEncontradoException.class)
	public void testDefinirCapitao_nonExistingJogador_shouldThrowException() {
		desafio.incluirTime(10L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.incluirJogador(2L, 10L, "nome", LocalDate.now(), 100, new BigDecimal(100));
		desafio.definirCapitao(30L);
	}
	
	@Test
	public void testDefinirCapitao_existingJogador_shouldSetJogadorAsCapitao() {
		desafio.incluirTime(10L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.incluirJogador(2L, 10L, "nome", LocalDate.now(), 100, new BigDecimal(100));
		desafio.definirCapitao(2L);
		assertEquals(2L, bancoDeDadosTimes.get(0).getCapitao().getId().longValue());
	}
	
	@Test
	public void testDefinirCapitao_existingCapitao_shouldReplaceCapitao() {
		desafio.incluirTime(10L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.incluirJogador(2L, 10L, "nome", LocalDate.now(), 100, new BigDecimal(100));
		desafio.definirCapitao(2L);
		desafio.incluirJogador(3L, 10L, "nome", LocalDate.now(), 100, new BigDecimal(100));
		desafio.definirCapitao(3L);		
		assertEquals(3L, bancoDeDadosTimes.get(0).getCapitao().getId().longValue());
	}

	@Test(expected = CapitaoNaoInformadoException.class)
	public void testBuscarCapitaoDoTime_timeWithNoCapitao_shouldThrowException() {
		desafio.incluirTime(10L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.buscarCapitaoDoTime(10L);
	}

	@Test(expected = TimeNaoEncontradoException.class)
	public void testBuscarCapitaoDoTime_nonExistingTime_shouldThrowException() {
		desafio.buscarCapitaoDoTime(50L);
	}
	
	@Test
	public void testBuscarCapitaoDoTime_existingCapitao_shouldReturnCapitaoId() {
		desafio.incluirTime(10L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.incluirJogador(2L, 10L, "nome", LocalDate.now(), 100, new BigDecimal(100));
		desafio.definirCapitao(2L);
		Long result = desafio.buscarCapitaoDoTime(10L);
		assertEquals(2L, result.longValue());
	}
	
	@Test(expected = JogadorNaoEncontradoException.class)
	public void testBuscarNomeJogador_nonExistingJogador_shouldThrowException() {
		desafio.buscarNomeJogador(10L);
	}
	
	@Test
	public void testBuscarNomeJogador_existingJogador_shouldReturnName() {
		desafio.incluirTime(10L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.incluirJogador(2L, 10L, "nome", LocalDate.now(), 100, new BigDecimal(100));
		String result = desafio.buscarNomeJogador(2L);
		assertNotNull(result);
	}

	@Test(expected = TimeNaoEncontradoException.class)
	public void testBuscarNomeTime_nonExistingTime_shouldThrowException() {
		desafio.buscarNomeTime(10L);
	}
	
	@Test
	public void testBuscarNomeTime_existingTime_shouldReturnNome() {
		desafio.incluirTime(10L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		String result = desafio.buscarNomeTime(10L);
		assertNotNull(result);
	}
	
	@Test(expected = TimeNaoEncontradoException.class)
	public void testBuscarJogadoresDoTime_nonExistingTime_shouldThrowException() {
		desafio.buscarJogadoresDoTime(10L);
	}
	
	@Test
	public void testBuscarJogadoresDoTime_existingJogadores_shouldReturnSortedList() {
		// given
		final Long idTime = 10L;
		desafio.incluirTime(idTime, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.incluirJogador(3L, idTime, "nome", LocalDate.now(), 100, new BigDecimal(100));
		desafio.incluirJogador(2L, idTime, "nome", LocalDate.now(), 100, new BigDecimal(100));
		// when		
		List<Long> result = desafio.buscarJogadoresDoTime(idTime);
		// then		
		assertEquals(2, result.size());
		assertEquals(2L, result.get(0).longValue());
		assertEquals(3L, result.get(1).longValue());
	}
	
	@Test
	public void testBuscarJogadoresDoTime_existingTimeButNoJogadores_shouldReturnEmptyList() {
		desafio.incluirTime(10L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		List<Long> result = desafio.buscarJogadoresDoTime(10L);
		assertTrue(result.isEmpty());		
	}

	@Ignore
	@Test
	public void testBuscarMelhorJogadorDoTime() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testBuscarJogadorMaisVelho() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testBuscarTimes() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testBuscarJogadorMaiorSalario() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testBuscarSalarioDoJogador() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testBuscarTopJogadores() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testBuscarCorCamisaTimeDeFora() {
		fail("Not yet implemented");
	}

}
