package ru.stqa.javaLessons.sandBox;

import org.testng.annotations.Test;
import org.testng.Assert;

public class squareTests {

    @Test
    public void testArea(){
        Square s = new Square(5);
        Assert.assertEquals( s.area(), 25);
    }

}
