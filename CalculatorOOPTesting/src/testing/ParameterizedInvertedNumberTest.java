package com.hcl.test.parametrizados;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.hcl.javaSeBasic.training.operationHandler.OperationHandler;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class ParameterizedInvertedNumberTest {
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 2000, "Entered number: 2000\nInverted Number: [0, 0, 0, 2]\r\n" }, 
                 { 3399, "Entered number: 3399\nInverted Number: [9, 9, 3, 3]\r\n" }, 
                 { 567, "Entered number: 567\nInverted Number: [7, 6, 5]\r\n" }, 
                 { 3, "Entered number: 3\nInverted Number: [3]\r\n"}, 
                 { 84, "Entered number: 84\nInverted Number: [4, 8]\r\n" }, 
                 { 532, "Entered number: 532\nInverted Number: [2, 3, 5]\r\n" }, 
                 { 9216, "Entered number: 9216\nInverted Number: [6, 1, 2, 9]\r\n"}  
           });
    }
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	}

    
    private int Input;

    private String Expected;

    public ParameterizedInvertedNumberTest(int input, String expected) {
        this.Input = input;
        this.Expected = expected;
    }

    @Test
    public void test() {
    	OperationHandler handler = new OperationHandler();
		handler.reversedInteger(Input);
    	assertEquals(Expected, outContent.toString());
    }



	
}
