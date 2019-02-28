package com.example.android.tourguideflint;

public class Info {

    private String mName;

    private String mDistance;

    private String mDetails;

    private String mDescription;

    private String mLocation;

    private int mImageResourceId;

    public Info(String name, String distance, String details, int imageResourceId, String description, String location) {
        mName = name;
        mDistance = distance;
        mDetails = details;
        mImageResourceId = imageResourceId;
        mDescription = description;
        mLocation = location;
    }

    public String getName() {
        return mName;
    }

    public String getDistance() {
        return mDistance;
    }

    public String getDetails() {
        return mDetails;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getLocation() {
        return mLocation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
