package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.example.Feline;

import java.util.List;

public class FelineTest {
    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        Assert.assertEquals(expected, feline.eatMeat());
    }

    @Test
    public void getFamilyTest() {
        String family = "Кошачьи";

        Assert.assertEquals(family, feline.getFamily());
    }

    @Test
    public void noParameterReturnOneKittensTest() {
        int defaultKittensCount = 1;

        Assert.assertEquals(defaultKittensCount, feline.getKittens());
    }

    @Test
    public void positiveParameterReturnKittensCountTest() {
        int customKittensCount = 10;

        Assert.assertEquals(customKittensCount, feline.getKittens(customKittensCount));
    }
}