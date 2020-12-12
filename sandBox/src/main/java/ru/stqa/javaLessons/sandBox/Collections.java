package ru.stqa.javaLessons.sandBox;

import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main (String[] args){
        String[] langs = {"java", "python, C#", "PHP"};

        List<String> languages = Arrays.asList(langs);


        for (String l : languages){
            System.out.printf("Я хочу выучить" + l);
        }


    }
}
