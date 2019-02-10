import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ParserTest {
    Parser parser;
    @Before
    public void setup() {
        parser = new Parser();
    }

    @Test
    public void testBreakIntoArray() {
        // Given
        String testString = "square(5+5 * 18 + square(4))";
        // When
        List<String> actualList = parser.breakIntoArray(testString);
        // Then
        List<String> expectedList = Arrays.asList("square", "(", "5", "+", "5", "*", "18", "+", "square", "(", "4", ")", ")");
        Assert.assertEquals(expectedList, actualList);

    }

    @Test
    public void testSortByOperation() {
        // Given
        List<String> testList = Arrays.asList("(", "5", "+", "5", "*", "18", "+", "4", ")");
        // When
        List<String> actualList = parser.sortByOperation(testList);
        // Then
        List<String> expectedList = Arrays.asList("5", "18", "*", "5", "+", "4");
        Assert.assertEquals(expectedList, actualList);

    }


}
