package com.luxoft.springel.example05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luxoft.springel.example05.Operators;

public class OperatorsXmlBasedTest {
	
	private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "example05/application-context.xml";
	private AbstractApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);
	}
	
	@Test
	public void testOperators() {
		Operators op = (Operators) context.getBean("operatorsBean");
//		assertTrue(op.isEqualTest());
//		assertTrue(op.isNotEqualTest());
//		assertFalse(op.isLessThanTest());
//		assertFalse(op.isLessThanOrEqualTest());
		assertFalse(op.isGreaterThanTest());
//		assertTrue(op.isGreaterThanOrEqualTest());
//
//		assertFalse(op.isAndTest());
//		assertFalse(op.isOrTest());
//		assertFalse(op.isNotTest());
//
//		assertEquals(op.getAddTest(), 250.0, 0.001);
//		assertEquals(op.getAddStringTest(), "hello@world");
//		assertEquals(op.getSubtractionTest(), 50.0, 0.001);
//		assertEquals(op.getMultiplicationTest(), 30000.0, 0.001);
//		assertEquals(op.getDivisionTest(), 3.0, 0.001);
//		assertEquals(op.getModulusTest(), 0.0, 0.001);
//		assertEquals(op.getExponentialPowerTest(), 10000.0, 0.001);
		System.out.println(op.toString());
	}
	
	@After
	public void tearDown() {
		context.close();
	}

}