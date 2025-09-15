package com.example;

import java.util.Arrays;
import java.util.List;

public class Alex extends Lion {
    public Alex(String sex, CatFamily catFamily) throws Exception {
        super("Самец", catFamily);
    }

    public List<String> getFriends() {
        return Arrays.asList("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return 0;
    }
}
