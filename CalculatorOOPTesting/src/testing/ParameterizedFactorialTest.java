package testing;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.hcl.javaSeBasic.training.operations.RecursiveFactorial;
@RunWith(Parameterized.class)
public class ParameterizedFactorialTest {
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 5,  120}, 
                 { 4, 24}, 
                 { 3,  6}, 
                 { 6 , 720}, 
                 { 2, 2 }, 
                 { 7, 5040}, 
                 { 8, 40320}  
           });
    }
    
    private Method factMethod;
    private int input;
    private int expected;

	
	 public ParameterizedFactorialTest(int input, int expected) {
	        this.input = input;
	        this.expected = expected;
	    }

	 @Test
	  public void test() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, NoSuchMethodException  {
		factMethod = RecursiveFactorial.class.getDeclaredMethod("calculateFactorial", int.class);
		factMethod.setAccessible(true);
		
		int actual = (Integer) factMethod.invoke(new RecursiveFactorial(0), input);

		assertEquals(expected,actual);

	}
	


	

}
