 

import calculator.IOConsole;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * @author leon on 03/02/2019.
 */
@SuppressWarnings("all")
public class GetStringInputTest {
    private calculator.IOConsole IOConsole;


    @Test
    public void test1() {
        test("0");
    }

    @Test
    public void test2() {
        test("1");
    }

    @Test
    public void test3() {
        test("3.4028235E38");
    }

    @Test
    public void test5() {
        test("-9223372036854775808");
    }

    @Test
    public void test6() {
        test("1.1");
    }

    @Test
    public void test7() {
        test("_");
    }


    private void test(String input) {
        // Given
        String expected = input;
        this.IOConsole = getConsoleWithBufferedInput(input);

        // When
        String actual = IOConsole.getStringInput("");

        // Then
        Assert.assertEquals(actual, expected);
    }

    private IOConsole getConsoleWithBufferedInput(String inputString) {
        byte[] inputBytes = inputString.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Scanner scanner = new Scanner(inputByteArray);
        IOConsole IOConsole = new IOConsole(scanner, System.out);
        return IOConsole;
    }
}
