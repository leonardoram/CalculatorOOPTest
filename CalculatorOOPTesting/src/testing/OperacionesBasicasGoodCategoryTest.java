package testing;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(CalculatorGoodTestCategory.class)
@SuiteClasses({ OperacionesSumasTest.class,
				OperacionesMultiplicacionesTest.class,
				OperacionesRestasTest.class })

public class OperacionesBasicasGoodCategoryTest {

}
