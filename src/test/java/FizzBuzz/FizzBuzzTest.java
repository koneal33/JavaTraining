package FizzBuzz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.rmi.CORBA.Util;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;
    private int num1;
    private Util utilMock;

    @Before
    public void Before(){
        utilMock = mock(Util.class);
        fizzBuzz = new FizzBuzz(utilMock);
        num1 = 0;
    }

    @Test
    public void dummyTest(){
        fizzBuzz.number(num1);
        verify(utilMock, times(45)).equals(num1);
    }

    @Test
    public void givenintegerwhenfizzbuzzthenstring(){
        String number = fizzBuzz.number(num1);
        Assert.assertEquals(String.valueOf(num1),number);
    }
    @Test
    public void givenMultOf3whenlammalammadingdongthenisFizz(){
        num1 = 21;
        String result = fizzBuzz.lammalammadingdong(num1);
        Assert.assertEquals("fizz", result);
    }
    @Test
    public void givenNotMultOf3or5whenlammalammadingdongthenNull(){
        num1 = 29;
        String result = fizzBuzz.lammalammadingdong(num1);
        Assert.assertNull(result);
    };
    @Test
    public void givenMultOfFivewhenlammalammadingdongthenBuzz(){
        num1 = 20;
        String result = fizzBuzz.lammalammadingdong(num1);
        Assert.assertEquals(result,"buzz");
    }
}
