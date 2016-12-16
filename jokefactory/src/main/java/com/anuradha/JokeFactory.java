package com.anuradha;

import java.util.Random;

public class JokeFactory {
    private static final int JOKES_COUNT = 4;
    public String JokeTeller(){
        String[] joke = {"Q: Where do pencils go for vacation?\n" +
                            "A: Pencil-vania.",
                        "Q: Why did the girl smear peanut butter on the road?\n" +
                            "A: To go with the traffic jam!" ,
                        "Q: Why do bananas have to put on sunscreen before they go to the beach?\n" +
                            "A: Because they might peel!",
                        "Q: Why couldn't the pony sing himself a lullaby?\n" +
                            "A: He was a little hoarse."};
        int n = new Random().nextInt(JOKES_COUNT);
        System.out.println("Chosen joke from jaketellingjavalib is  "+n);
        return joke[n];
    }
}
