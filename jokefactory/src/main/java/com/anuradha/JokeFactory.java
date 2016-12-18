package com.anuradha;

import java.util.Random;

/* Java library for supplying jokes*/
public class JokeFactory {
    private static final int JOKES_COUNT = 8;

    public String JokeTeller() {
        String[] joke = {"Q: Where do pencils go for vacation?\n" +
                "A: Pencil-vania.",
                "Q: Why did the girl smear peanut butter on the road?\n" +
                        "A: To go with the traffic jam!",
                "Q: Why do bananas have to put on sunscreen before they go to the beach?\n" +
                        "A: Because they might peel!",
                "Q: Why couldn't the pony sing himself a lullaby?\n" +
                        "A: He was a little hoarse.",
                "Q: How can you tell the ocean is friendly?\n " +
                        "A: It waves.",
                "Q: What is the world's tallest building? \n" +
                        "A: The library because it has the most stories.",
                "Q: What do you call a bear with no teeth?\n" +
                        "A: A gummy bear!",
                "Q: Why can't Cinderella play soccer?\n" +
                        "A: Because she's always running away from the ball."};
        int n = new Random().nextInt(JOKES_COUNT);
        System.out.println("Chosen joke from jaketellingjavalib is  " + n);
        return joke[n];
    }
}
