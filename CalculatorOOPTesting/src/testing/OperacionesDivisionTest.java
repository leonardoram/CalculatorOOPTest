package testing;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.hcl.javaSeBasic.training.operations.Divition;

public class OperacionesDivisionTest {

	private Divition operation;

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
		operation = new Divition();
		
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}
	
	@After
	public void restoreStreams() {

		System.setOut(originalOut);
		System.setErr(originalErr);

	}


	//Test de la clase Multiplication
	@Test
	@Category(CalculatorGoodTestCategory.class)
	public void Division2numerosEnterosTest() {
		double num1 = 10;
		double num2 = 5;
		
		operation.performOperation(num1, num2);
		String exp = "The resoult by dividing "+num1 +" / "+ num2 + " = "+(num1/num2)+"\r\n";
		assertEquals(exp, outContent.toString());
	}
	@Test
	public void Division2NumerosDoubleTest(){
		double num1 = 10.45;
		double num2 = 5.32;
		
		operation.performOperation(num1, num2);
		String exp = "The resoult by dividing "+num1 +" / "+ num2 + " = "+(num1/num2)+"\r\n";
		assertEquals(exp, outContent.toString());
	}
	
	
	@Test//(expected = Exception.class)
	public void Division2NumerosNegativosTest(){
		double num1 = -10;
		double num2 = -5;
		
		operation.performOperation(num1, num2);
		String exp = "The resoult by dividing "+num1 +" / "+ num2 + " = "+(num1/num2)+"\r\n";
		assertEquals(exp, outContent.toString());
		
	}
	
	@Test
	public void DivisionNumeroTest() {
		double num1 = 5;
		double num2 = 0;
		
		operation.performOperation(num1, num2);
		String exp = "The resoult by dividing "+num1 +" / "+ num2 + " = "+(num1/num2)+"\r\n";
		assertEquals(exp, outContent.toString());
		
	}
	
	@Test
	@Category(CalculatorBadTestCategory.class)
	public void DivisionConLetrasYnumerosTest(){
		
		double num1 = 5;
		String num2 = "a";
		
		operation.performOperation(num1, num2);
		String exp = "The resoult by dividing "+num1 +" / "+ num2 + " = "+(num1/num2)+"\r\n";
		assertEquals(exp, outContent.toString());
		
	}

}
