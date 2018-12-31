package code.desafio;

import static code.desafios.model.InMemoryMockDB.bancoDeDadosJogadores;
import static code.desafios.model.InMemoryMockDB.bancoDeDadosTimes;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.desafios.Desafio1;
import code.desafios.model.CapitaoNaoInformadoException;
import code.desafios.model.IdentificadorUtilizadoException;
import code.desafios.model.JogadorNaoEncontradoException;
import code.desafios.model.TimeNaoEncontradoException;

public class Desafio1Test {

	private Desafio1 desafio;
	
	@Before
	public void setup() {
		desafio = new Desafio1();
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

	@Test(expected = TimeNaoEncontradoException.class)
	public void testBuscarMelhorJogadorDoTime_nonExistingTime_shouldThrowException() {
		desafio.buscarMelhorJogadorDoTime(10L);
	}
	
	@Test
	public void testBuscarMelhorJogadorDoTime_existingTime_shouldReturnJogador() {
		// given
		final Long idTime = 10L;
		final Long idBestPlayer = 2L;
		desafio.incluirTime(idTime, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.incluirJogador(3L, idTime, "nome", LocalDate.now(), 50, new BigDecimal(100));
		desafio.incluirJogador(idBestPlayer, idTime, "nome", LocalDate.now(), 70, new BigDecimal(100));
		// when		
		Long result = desafio.buscarMelhorJogadorDoTime(idTime);
		// then		
		assertEquals(idBestPlayer.longValue(), result.longValue());
	}
	
	@Test
	public void testBuscarMelhorJogadorDoTime_emptyTime_shouldReturnJogador() {
		// given
		final Long idTime = 10L;
		desafio.incluirTime(idTime, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		// when		
		Long result = desafio.buscarMelhorJogadorDoTime(idTime);
		// then		
		assertNull(result);
	}

	@Test(expected = TimeNaoEncontradoException.class)
	public void testBuscarJogadorMaisVelho_nonExistingTime_shouldThrowException() {
		desafio.buscarJogadorMaisVelho(10L);
	}
	
	@Test
	public void testBuscarJogadorMaisVelho_noAgeDraw_should() {
		// given
		final Long idTime = 10L;
		final Long idOldestPlayer = 2L;
		desafio.incluirTime(idTime, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.incluirJogador(3L, idTime, "nome", LocalDate.now(), 50, new BigDecimal(100));
		desafio.incluirJogador(idOldestPlayer, idTime, "nome", LocalDate.now().minusDays(5L), 70, new BigDecimal(100));
		// when		
		Long result = desafio.buscarJogadorMaisVelho(idTime);
		// then		
		assertEquals(idOldestPlayer.longValue(), result.longValue());
	}
	
	@Test
	public void testBuscarJogadorMaisVelho_ageDraw_should() {
		// given
		final Long idTime = 10L;
		final Long idOldestPlayer = 2L;
		desafio.incluirTime(idTime, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.incluirJogador(4L, idTime, "nome", LocalDate.now(), 50, new BigDecimal(100));
		desafio.incluirJogador(3L, idTime, "nome", LocalDate.now().minusDays(5L), 50, new BigDecimal(100));
		desafio.incluirJogador(idOldestPlayer, idTime, "nome", LocalDate.now().minusDays(5L), 70, new BigDecimal(100));
		// when		
		Long result = desafio.buscarJogadorMaisVelho(idTime);
		// then		
		assertEquals(idOldestPlayer.longValue(), result.longValue());
	}

	@Test
	public void testBuscarTimes_nonExistingTime_shouldReturnEmptyList() {
		List<Long> result = desafio.buscarTimes();
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void testBuscarTimes_existingTime_shouldReturnSortedList() {
		desafio.incluirTime(20L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.incluirTime(10L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		List<Long> result = desafio.buscarTimes();
		assertEquals(2L,  result.size());
		assertEquals(10L, result.get(0).longValue());
		assertEquals(20L, result.get(1).longValue());
	}

	@Test(expected = TimeNaoEncontradoException.class)
	public void testBuscarJogadorMaiorSalario_nonExistingTime_shouldThrowException() {
		desafio.buscarJogadorMaiorSalario(10L);
	}
	
	@Test
	public void testBuscarJogadorMaiorSalario_noSalaryDraw_shouldReturnJogadorId() {
		// given
		desafio.incluirTime(10L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.incluirJogador(4L, 10L, "nome", LocalDate.now(), 50, new BigDecimal(100));
		desafio.incluirJogador(5L, 10L, "nome", LocalDate.now(), 50, new BigDecimal(200));
		// when
		Long result = desafio.buscarJogadorMaiorSalario(10L);
		// then 
		assertEquals(5L, result.longValue());
	}
	
	@Test
	public void testBuscarJogadorMaiorSalario_salaryDraw_shouldReturnLowerJogadorId() {
		// given
		desafio.incluirTime(10L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.incluirJogador(5L, 10L, "nome", LocalDate.now(), 50, new BigDecimal(100));
		desafio.incluirJogador(4L, 10L, "nome", LocalDate.now(), 50, new BigDecimal(100));
		// when
		Long result = desafio.buscarJogadorMaiorSalario(10L);
		// then 
		assertEquals(4L, result.longValue());
	}

	@Test(expected = JogadorNaoEncontradoException.class)
	public void testBuscarSalarioDoJogador_nonExistingJogador_shouldThrowException() {
		desafio.buscarSalarioDoJogador(10L);
	}
	
	@Test
	public void testBuscarSalarioDoJogador_existingJogador_shouldReturnSalario() {
		// given
		desafio.incluirTime(10L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.incluirJogador(5L, 10L, "nome", LocalDate.now(), 50, new BigDecimal(100));
		// when
		BigDecimal result = desafio.buscarSalarioDoJogador(5L);
		// then 
		assertTrue(new BigDecimal(100).compareTo(result) == 0);
	}

	@Test
	public void testBuscarTopJogadores_noRegisteredJogadores_shouldReturnEmptyList() {
		List<Long> result = desafio.buscarTopJogadores(10);
		assertTrue(result.isEmpty());		
	}
	
	@Test
	public void testBuscarTopJogadores_noDraw_shouldReturnTopParamItems() {
		// given
		desafio.incluirTime(10L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.incluirJogador(5L, 10L, "nome", LocalDate.now(), 50, new BigDecimal(100));  // middle
		desafio.incluirJogador(3L, 10L, "nome", LocalDate.now(), 0, new BigDecimal(100));   // worst
		desafio.incluirJogador(4L, 10L, "nome", LocalDate.now(), 100, new BigDecimal(100)); // best
		// when
		List<Long> result = desafio.buscarTopJogadores(2);
		// then 
		assertEquals(2, result.size());
		assertEquals(4L, result.get(0).longValue());
		assertEquals(5L, result.get(1).longValue());
	}
	
	@Test
	public void testBuscarTopJogadores_drawCondition_shouldReturnTopParamItems() {
		// given
		desafio.incluirTime(10L, "nome", LocalDate.now(), "corUniformePrincipal", "corUniformeSecundario");
		desafio.incluirJogador(5L, 10L, "nome", LocalDate.now(), 50, new BigDecimal(100));  // middle
		desafio.incluirJogador(3L, 10L, "nome", LocalDate.now(), 50, new BigDecimal(100));   // worst
		desafio.incluirJogador(4L, 10L, "nome", LocalDate.now(), 100, new BigDecimal(100)); // best
		// when
		List<Long> result = desafio.buscarTopJogadores(2);
		// then 
		assertEquals(2, result.size());
		assertEquals(4L, result.get(0).longValue());
		assertEquals(3L, result.get(1).longValue());
	}

	@Test
	public void testBuscarCorCamisaTimeDeFora_differentColors_shouldReturnCorCamisaPrincipal() {
		// given
		desafio.incluirTime(10L, "nome", LocalDate.now(), "amarelo", "azul");
		desafio.incluirTime(20L, "nome", LocalDate.now(), "vermelho", "roxo");
		// when
		String result = desafio.buscarCorCamisaTimeDeFora(10L, 20L);
		// then
		assertEquals("vermelho", result.toString());
	}
	
	@Test
	public void testBuscarCorCamisaTimeDeFora_sameColors_shouldReturnCorCamisaSecundario() {
		// given
		desafio.incluirTime(10L, "nome", LocalDate.now(), "amarelo", "azul");
		desafio.incluirTime(20L, "nome", LocalDate.now(), "amarelo", "roxo");
		// when
		String result = desafio.buscarCorCamisaTimeDeFora(10L, 20L);
		// then
		assertEquals("roxo", result.toString());
	}

}
