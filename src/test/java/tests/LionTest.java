package tests;

import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    Feline feline = new Feline();

    String sex;
    String message;
    boolean hasMane;

    public LionTest(String sex, String message, boolean hasMane) {
        this.sex = sex;
        this.message = message;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters (name = "Список еды для животных {1}: {0}")
    public static Object[][] getFoodData() {
        return new Object[][]{
                {"Самец", "У самца должна быть грива", true},
                {"Самка", "У самки не должно быть гривы", false},
        };
    }

    @Test
    public void hasManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);

        if (hasMane) {
            Assert.assertTrue(message, lion.doesHaveMane());
        } else {
            Assert.assertFalse(message, lion.doesHaveMane());
        }
    }

    @Test
    public void whenWrongSexThrowExceptionTest() {
        try {
            Lion lion = new Lion("Null", feline);
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка",
                    exception.getMessage());
        }
    }

    @Test
    public void lionHasOneKittensTest() throws Exception {
        Lion lion = new Lion(sex, feline);

        int defaultKittensCount = 1;

        Assert.assertEquals(defaultKittensCount, lion.getKittens());
    }

    @Test
    public void lionGetMeatTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        Lion lion = new Lion(sex, feline);

        Assert.assertEquals(expected, lion.getFood());
    }
}