package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ OperacionesSumasTest.class,
	OperacionesMultiplicacionesTest.class,
	OperacionesRestasTest.class,
	ParameterizedInvertedNumberTest.class,
	ParameterizedFactorial.class})

public class OperacionesBasicasSuiteTest {
	
}
