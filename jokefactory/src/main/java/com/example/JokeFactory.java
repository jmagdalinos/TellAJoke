package com.example;

import java.util.ArrayList;

/** Holds a number of jokes and contains a method to return one randomly */
public class JokeFactory {

    /** Select a random joke */
    public static String getJoke() {
        ArrayList<String> jokes = initializeArray();

        return jokes.get((int) (Math.random()*jokes.size()));
    }

    /** Returns the list of jokes */
    private static ArrayList<String> initializeArray() {
        ArrayList<String> jokes = new ArrayList<>();

        jokes.add("Can a kangaroo jump higher than a house? \n" +
                "Of course, a house doesn't jump at all.");
        jokes.add("Doctor: \"I'm sorry but you suffer from a terminal illness and have only 10 to live.\"\n" +
                "\n" +
                "Patient: \"What do you mean, 10? 10 what? Months? Weeks?!\"\n" +
                "\n" +
                "Doctor: \"Nine.");
        jokes.add("A man asks a farmer near a field, \"Sorry sir, would you mind if I crossed your field instead of going around it? You see, I have to catch the 4:23 train.\"\n" +
                "\n" +
                "The farmer says, \"Sure, go right ahead. And if my bull sees you, you'll even catch the 4:11 one.\"");
        jokes.add("Anton, do you think I'm a bad mother?\n" +
                "\n" +
                "My name is Paul.");
        jokes.add("What is the difference between a snowman and a snowwoman?\n" +
                "-\n" +
                "Snowballs.");
        jokes.add("My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.");
        jokes.add("A detective asks a woman, \"So, your husband hanged himself?\" Woman replies, \"Yes, that is correct.\" The suspicious detective continues, \"But why does he have all those bruises on his head?\" \n" +
                "\n" +
                "\"The old fool used an elastic rope!\"");
        jokes.add("Why don't cannibals eat divorced women?\n" +
                "\n" +
                "Because they're bitter.");
        jokes.add("Q. What's the worst thing about being lonely?\n" +
                "\n" +
                "A. Playing Frisbee.");
        jokes.add("Why did the physics teacher break up with the biology teacher? There was no chemistry.");
        jokes.add("I'm certain there are female hormones in beer. When I drink too much, I talk nonsense and I cannot control my car.\n");
        jokes.add("Patient asks his doctor: \"Can I take a bath with diarrhea?\"\n" +
                "-\n" +
                "Doctor: \"Yes, if you are able to fill it up. \"");
        jokes.add("Man: Hi, do you want to dance?\n" +
                "-\n" +
                "Woman: Yeah, sure!\n" +
                "-\n" +
                "Man: Great, go and dance, I want to talk to your pretty friend!");
        jokes.add("Waiter, I am outraged. There is one hair in my soup.\n" +
                "-\n" +
                "And what do you expect for this price? A whole wig?!");
        jokes.add("My girlfriend says that I am snoopy. But OK, maybe she meant it differently when she wrote it in her diary.");
        jokes.add("What is see-through and smells of carrots? \n" +
                "-\n" +
                "A rabbit fart.");
        jokes.add("Dentist: \"This will hurt a little.\"\n" +
                "\n" +
                "Patient: \"OK.\"\n" +
                "\n" +
                "Dentist: \"I've been having an affair with your wife for a while now.\"");
        jokes.add("Yes, money cannot buy you happiness, but I'd still feel a lot more comfortable crying in a new BMW than on a bike.");
        jokes.add("One state official to the other: \"I don't know what people have against us - We haven't done anything.\"");

        return jokes;
    }
}
