package com.ben.customertest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.postgresql.util.PSQLException;

import com.ben.util.ConnectionFactory;

@TestInstance(Lifecycle.PER_CLASS)
public class ConnectionFactoryTest {
	
	private ConnectionFactory connectionFactory;
	
	@BeforeAll
	public void beforeAll() {
		this.connectionFactory = new ConnectionFactory();
	}
	
	
	/**
	 * this method runs before each @test
	 */
	@BeforeEach
	public void beforeEach() {
		
	}
	
	/**
	 * this method tests the Connection of the ConnectionFactory
	 */
	@ParameterizedTest
	@ValueSource ()
	public void testConnection() {
		
//		Assertions.assertSame(connectionFactory, connectionFactory);
//		Assertions.assertNotNull(connectionFactory);
//		Assertions.assertDoesNotThrow((Executable) connectionFactory);
//		Assertions.assertInstanceOf(null, connectionFactory);
//		Assertions.assertThrows(PSQLException.class, connectionFactory.getConnection());
	}
	
	/*
	 * this test happens after each @test
	 */
	@AfterEach
	public void afterEach() {
		
	}
	
	@AfterAll
	public void afterAll() {
		
	}

}
