package testing;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.hcl.javaSeBasic.training.operations.Substraction;

public class OperacionesRestasTest {
	
	private Substraction operation;

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
		operation = new Substraction();
		
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}
	
	@After
	public void restoreStreams() {

		System.setOut(originalOut);
		System.setErr(originalErr);

	}

	// Test de la clase Substraction
		@Test
		@Category(CalculatorGoodTestCategory.class)
		public void Resta2numerosEnterosTest() {
			double num1 = 10;
			double num2 = 5;
			
			operation.performOperation(num1, num2);
			String exp = "The resoult by substracting "+num1 +" - "+ num2 + " = "+(num1-num2)+"\r\n";
			assertEquals(exp, outContent.toString());
			
		}
		
		@Test
		public void Resta2NumerosDoubleTest(){
			double num1 = 10.54;
			double num2 = 5.10;
			
			operation.performOperation(num1, num2);
			String exp = "The resoult by substracting "+num1 +" - "+ num2 + " = "+(num1-num2)+"\r\n";
			assertEquals(exp, outContent.toString());
		}
		
		@Test//(expected = Exception.class)
		public void Resta2NumerosNegativosTest(){
			double num1 = -10;
			double num2 = -5;
			
			operation.performOperation(num1, num2);
			String exp = "The resoult by substracting "+num1 +" - "+ num2 + " = "+(num1-num2)+"\r\n";
			assertEquals(exp, outContent.toString());
		}
		
		@Test
		@Category(CalculatorBadTestCategory.class)
		public void RestaNumerosYLetrasTest() {
			fail("not yet implemented");
		}

}
