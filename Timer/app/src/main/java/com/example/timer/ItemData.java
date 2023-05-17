package com.example.timer;

import java.util.ArrayList;

public class ItemData {
    public String word;
    public String meaning;


    public ItemData(String word, String meanoing) {
        this.word = word;
        this.meaning = meaning;
    }


    public static ArrayList<ItemData> createContactsList(int numContacts) {
        ArrayList<ItemData> contacts = new ArrayList<ItemData>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new ItemData("Person ", "test"));
        }

        return contacts;
    }
}
