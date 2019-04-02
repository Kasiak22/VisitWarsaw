package com.example.android.visitwarsaw;

public class Place {
    private String name;
    private String descript;
    private int imageID;
    private String Url;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Place(String theName, String theDescript, int theImageID, String theUrl) {
        name = theName;
        descript = theDescript;
        imageID = theImageID;
        Url = theUrl;

    }

    //returns song title
    public String getName() {
        return name;
    }

    //returns Artist name
    public String getDescript() {
        return descript;
    }

    //Returns imageID
    public int getImageResourceId() {
        return imageID;
    }

    // Returns whether or not there is an image for this song.
    public boolean hasImage() {
        return imageID != NO_IMAGE_PROVIDED;
    }

    public String getUrl() {
        return Url;
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", street'" + descript + '\'' +
                ", imageID" + imageID +
                ", URL" + Url +
                '}';
    }
}
