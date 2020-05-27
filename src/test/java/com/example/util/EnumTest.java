package com.example.util;

import com.example.demo.DemoApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
public class EnumTest {

    private EnumMap<Season, String> seasons = new EnumMap<>(Season.class);

    @Before
    public void initSeasons() {
        seasons.put(Season.SPRING, "出暖花开");
        seasons.put(Season.SUMMER, "烈日炎炎");
        seasons.put(Season.FALL, "秋风萧瑟");
        seasons.put(Season.WINTER, "寒风凛冽");
    }

    enum Season {
        SPRING,
        SUMMER,
        FALL,
        WINTER
    }

    @Test
    public void testEnumMap(){
        Assert.assertEquals(seasons.size(), 4);

        Collection<String> values = seasons.values();
        Assert.assertTrue(values.contains("寒风凛冽"));

        Assert.assertTrue(seasons.keySet().contains(Season.FALL));
    }

    @Test
    public void testEnumSet(){
        EnumSet enumSet = EnumSet.allOf(Season.class);
        System.out.println(enumSet);

        EnumSet rangeEnumSet = EnumSet.range(Season.SPRING, Season.FALL);
        System.out.println(rangeEnumSet);

        EnumSet ofEnumSet = EnumSet.of(Season.SPRING, Season.WINTER);
        System.out.println(ofEnumSet);

        System.out.println(EnumSet.complementOf(ofEnumSet));
    }
}
