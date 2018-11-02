package testing;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.hcl.javaSeBasic.training.operations.Addition;

public class OperacionesSumasTest {

	private Addition operation;

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
		operation = new Addition();
		
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}
	
	// test de la clase Addition
	@Test
	@Category(CalculatorGoodTestCategory.class)
	public void Suma2numerosEnterosTest() {
		double num1 = 3;
		double num2 = 5;
		
		operation.performOperation(num1, num2);
		String exp = "The resoult by adding "+num1 +" + "+ num2 + " = "+(num1+num2);
		//assertTrue(exp, outContent.toString());
		
	}
	@Test
	public void Suma2NumerosDoubleTest(){
		//fail("not yet implemented");
	}
	
	@Test
	public void Suma2NumerosNegativosTest(){
		//fail("Not yet implemented");
	
	}
	
	@After
	public void restoreStreams() {

		System.setOut(originalOut);
		System.setErr(originalErr);

	}

	
	
	

}
