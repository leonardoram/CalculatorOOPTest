package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.hcl.javaSeBasic.training.operations.RecursiveFactorial;
@RunWith(Parameterized.class)
class ParameterizedFactorial {
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

    private int Input;

    private int Expected;

    public ParameterizedFactorial(int entrada, int expected) {
        this.Input = entrada;
        this.Expected = expected;
    }

    @Test
    public void test() throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
    
    	
    		Class[] type = { Integer.class };
			Class c = Class.forName("com.hcl.javaSeBasic.training.operations.RecursiveFactorial");
			RecursiveFactorial rf = (RecursiveFactorial) c.newInstance();
			Method m =(Method) c.getDeclaredMethod("calculateFactorial", Integer.class);
			m.setAccessible(true);
			int result= (int)m.invoke(rf, Input);
			assertEquals(Expected, result);
		
		
    }

}
