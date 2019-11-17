package com.birmingham.hci.workshop.chen.worksheet4;

/**
 * The class is used to represent music titles in form of a title, an
 * artist, and a price, of types String, String, and int,
 * respectively.  login attempts.
 *
 * User: Chen Liu
 * Date: 2019/11/16
 * Time: 11:21 pm
 */
public class MusicTitle implements MusicTitleInterface {

    /**
     * The title of the music
     */
    private String title;

    /**
     * The artist of the music
     */
    private String artist;

    /**
     * The price of the music
     */
    private int price;

    /**
     * Standard getter for the title
     *
     * @return The title of the music title.
     */
    @Override
    public String getTitle() {
        return this.title;
    }

    /**
     * Standard getter for the artist
     *
     * @return The artist of the music title.
     */
    @Override
    public String getArtist() {
        return this.artist;
    }

    /**
     * Standard getter for the price
     *
     * @return The price of the music title.
     */
    @Override
    public int getPrice() {
        return this.price;
    }

    /**
     * Standard toString method to represent the object in a human
     * readable form.
     *
     * @return The object in a human readable form.
     */
    @Override
    public String toString() {
        return "MusicTitle{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", price=" + price +
                '}';
    }
}
