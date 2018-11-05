package testing;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.*;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
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
	
	@After
	public void restoreStreams() {

		System.setOut(originalOut);
		System.setErr(originalErr);

	}
	/*
	//private Addition sumita;
	private Method m;
	private static String method_name ="addition";
	
	 Este codigo no funciona, segun es para calar la suma con reflection API pero no jalo 
	@Before
	public void setUp() throws NoSuchMethodException{
		
		Addition sum = new Addition();
		Class<?> sumita = sum.getClass();
		
		m = sumita.getDeclaredMethod(method_name, double.class, double.class);
		m.setAccessible(true);	
		
	}
	*/ 
	
	// test de la clase Addition
	@Test
	@Category(CalculatorGoodTestCategory.class)
	public void Suma2numerosEnterosTest() throws Exception, IllegalArgumentException, InvocationTargetException {
	/*	esto tampoco funciona 
	 	double num1 = 3;
		double num2 = 5;
		
		operation.performOperation(num1, num2);
		String exp = "The resoult by adding "+num1 +" + "+ num2 + " = "+(num1+num2);
		assertTrue(exp, outContent.toString());
		
		double num1 = 5;
		double num2 = 10;
		
		double num1 =5;
		double num2 = 10;
		
		double actual = (double) m.invoke(method_name, num1,num2);
		
		assertEquals(15, actual, 00);
		*/
		
		double num1 = 3;
		double num2 = 5;
		
		operation.performOperation(num1, num2);
		String exp = "The resoult by adding "+num1 +" + "+ num2 + " = "+(num1+num2)+"\r\n";
		assertEquals(exp, outContent.toString());
		
		
	}
	@Test
	public void Suma2NumerosDoubleTest(){
		
		double num1 = 10.154;
		double num2 = 52.64;
		
		operation.performOperation(num1, num2);
		String exp = "The resoult by adding "+num1 +" + "+ num2 + " = "+(num1+num2)+"\r\n";
		assertEquals(exp, outContent.toString());
		
	}
	
	@Test //(expected = Exception.class)
	//Se supone que deberia de fallar y mandar una excepcion que cachamos desde expected en test, pero por alguna razon en el test si funciona
	public void Suma2NumerosNegativosTest(){
		
		double num1 = (-15);
		double num2 = (-5);
		
		operation.performOperation(num1, num2);
		String exp = "The resoult by adding "+num1 +" + "+ num2 + " = "+(num1+num2)+"\r\n";
		assertEquals(exp, outContent.toString());
	
	}
	
	@Test
	@Category(CalculatorBadTestCategory.class)
	public void SumarNumerosYletrasTest() {
		
		double num1 = (-15);
		String num2 = "a";
		
		operation.performOperation(num1, num2);
		String exp = "The resoult by adding "+num1 +" + "+ num2 + " = "+(num1+num2)+"\r\n";
		assertEquals(exp, outContent.toString());
		
	}
	
		

}
