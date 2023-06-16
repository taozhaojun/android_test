package com.example.fia_a3.model;

import android.content.Context;
import android.util.Log;

import com.example.fia_a3.R;
import com.example.fia_a3.model.BookID;

import java.util.ArrayList;

public class Constants {
    private static final String TAG = "Constants";

    public static final String BIOGRAPHY = "Biography";
    public static final String ROMANCE = "Romance";
    public static final String FICTION = "Fiction";
    public static final String POEM = "Poem";

    public static final String CATEGORY_KEY= "category";
    public static final String DETAIL_KEY= "detail";


    public static ArrayList<BookID> biographyList(Context context) {
        ArrayList<BookID> bookArrayList = new ArrayList<>();
        bookArrayList.add(new BookID("Dreams from My Father", context.getString(R.string.Dreams), "Barak Obama", R.drawable.dreams_from_my_father, 24.99, 0));
        bookArrayList.add(new BookID("The Light We Carry", context.getString(R.string.TheLightWeCarry), "Michele Obama", R.drawable.the_light_we_carry, 24.58, 0));
        bookArrayList.add(new BookID("Dare Not Linger", context.getString(R.string.DareNotLinger), "Nelson Mandela", R.drawable.nelson_mandela_dare_not_linger, 34.99, 0));
        bookArrayList.add(new BookID("Strength To Love", context.getString(R.string.Strength), "Martin Luther King, Jr.", R.drawable.strenght_to_love, 30.26, 0));
        Log.d(TAG, "biographyList: done");
        return bookArrayList;
    }

    public static ArrayList<BookID> fictionList(Context context) {
        ArrayList<BookID> bookArrayList = new ArrayList<>();
        bookArrayList.add(new BookID("Elementary, Chapter Three: Ultramorpho", context.getString(R.string.Ultramorpho), "Elementary", R.drawable.world_finest, 3.99, 0));
        bookArrayList.add(new BookID("Nightwing", context.getString(R.string.Nightwing), "Tom Taylor and Bruno Redondo", R.drawable.nightwing, 4.99, 0));
        bookArrayList.add(new BookID("Saga", context.getString(R.string.Saga), "Bonnie Garmus", R.drawable.saga, 4.99, 0));
        bookArrayList.add(new BookID("Harry Potter and the Philosopher's Stone", "Turning the envelope over, his hand trembling, Harry saw a purple wax seal bearing a coat of arms; a lion, an eagle, a badger and a snake surrounding a large letter 'H'.", "Mary GrandPré and J.K. Rowling", R.drawable.harrypotter, 15.99, 0));
        bookArrayList.add(new BookID("The Magic Of The Lost Temple", "Are you a curious reader, ready to explore the depths of the magic hidden in the lost temple of Karnataka? ", " Sudha Murty", R.drawable.magic, 12.99, 0));
        Log.d(TAG, "fictionList: done");
        return bookArrayList;
    }

    public static ArrayList<BookID> romanceList(Context context) {
        ArrayList<BookID> bookArrayList = new ArrayList<>();
        bookArrayList.add(new BookID("Pride & Prejudice", context.getString(R.string.PridePrejudice), "Jane Austen", R.drawable.pride_and_prejudice, 34.99, 0));
        bookArrayList.add(new BookID("Rules", context.getString(R.string.Rules), "Jane Austen", R.drawable.rules, 10.00, 0));
        bookArrayList.add(new BookID("Emma", context.getString(R.string.Emma), "Jane Austen", R.drawable.emma, 15.00, 0));
        bookArrayList.add(new BookID("The Girl on the Carpathia", context.getString(R.string.Carpathia), "Eileen Enwright Hodgetts", R.drawable.the_girl_on_the_carpathia, 21.49, 0));
        Log.d(TAG, "romanceList: done");
        return bookArrayList;
    }

    public static ArrayList<BookID> poemList(Context context) {
        ArrayList<BookID> bookArrayList = new ArrayList<>();
        bookArrayList.add(new BookID("One Hundred Years of Solitude", context.getString(R.string.OneHundred), "Gabriel García Márquez", R.drawable.one_hundred_years_of_solitude, 22, 0));
        bookArrayList.add(new BookID("Their Eyes Were Watching God", context.getString(R.string.God), "Zora Neale Hurston", R.drawable.their_eyes_were_watching_god, 15.99, 0));
        bookArrayList.add(new BookID("Divan of Hafez", "This compact version of the Divan of Hafez is a facsimile illuminated manuscript, complete with beautiful Persian calligraphy and miniature illustrations.", "Hafez", R.drawable.hafez, 80.99, 0));
        bookArrayList.add(new BookID("The Masnavi of Rumi", "Jalaloddin Rumi'sMasnavi-ye Ma'navi, or 'Spiritual Couplets', composed in the 13th Century, is a monumental work of poetry in the Sufi tradition of Islamic mysticism. ", "  Jalaloddin Rumi", R.drawable.masnavi, 87.05, 0));
        Log.d(TAG, "poemList: done");
        return bookArrayList;

    }

}
