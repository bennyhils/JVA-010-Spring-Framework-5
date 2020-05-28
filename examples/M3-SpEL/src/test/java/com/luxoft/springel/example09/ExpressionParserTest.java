package com.luxoft.springel.example09;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class ExpressionParserTest {

	@Test
	public void testLiterals() {
		ExpressionParser parser = new SpelExpressionParser();

		String helloWorld = (String) parser.parseExpression("'Hello World'").getValue();
		assertEquals("Hello World", helloWorld);

		double lightSpeed = (Double) parser.parseExpression("299792.458E+3").getValue();
		assertEquals(299792458, lightSpeed, 0.01);

		int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();
		assertEquals(2147483647, maxValue);

		boolean trueValue = (Boolean) parser.parseExpression("true").getValue();
		assertEquals(true, trueValue);

		Object nullValue = parser.parseExpression("null").getValue();
		assertNull(nullValue);

		parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("'Hello World'.concat('!!!')");
		System.out.println("concat --> " + exp.getValue());
	}

	@Test
	public void testClients() {
		ExpressionParser parser = new SpelExpressionParser();

		Location location = new Location("Moscow", "Russia");
		Client client = new Client("Victor Ponedelnik", "Russian", location);

		StandardEvaluationContext ponedelnikContext = new StandardEvaluationContext(client);

		client.setAccounts(new String[] { "Account1", "Account2", "Account3" });

		String account = parser.parseExpression("accounts[1]").getValue(ponedelnikContext, String.class);
		assertEquals("Account2", account);

		Bank bank = new Bank("Alpha Bank");
		bank.addClient(client);
		StandardEvaluationContext bankContext = new StandardEvaluationContext(bank);

		String bankName = parser.parseExpression("bName").getValue(bankContext, String.class);
		assertEquals("Alpha Bank", bankName);
		
		Location ponedelnikLocation = parser.parseExpression("clients[0].location").getValue(bankContext, Location.class);
		assertEquals("Russia", ponedelnikLocation.getCountry());
		
		String country = parser.parseExpression("clients[0].location.country").getValue(bankContext, String.class);
		assertEquals("Russia", country);
		
		String account2 = parser.parseExpression("clients[0].accounts[2]").getValue(bankContext, String.class);
		assertEquals("Account3", account2);

	}
}
