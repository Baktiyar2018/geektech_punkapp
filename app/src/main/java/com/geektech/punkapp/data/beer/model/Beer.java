package com.geektech.punkapp.data.beer.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public class Beer {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("image_url")
    private String imageUrl;

    //region Constructors

    public Beer(
            int id,
            String name,
            String description,
            String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }


    //endregion

    //region Getters/Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return  id + " "
                 + name + " "
                 + description +" "
                + imageUrl ;
    }

    //endregion

}
