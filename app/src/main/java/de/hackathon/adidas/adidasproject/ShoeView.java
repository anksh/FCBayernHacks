package de.hackathon.adidas.adidasproject;

import android.graphics.drawable.Drawable;

/**
 * Created by ankit on 1/21/18.
 */

public class ShoeView {

    private Integer shoeImage;
    private Integer shoeText;


    public ShoeView(Integer shoeImage, Integer shoeText) {
        this.shoeImage = shoeImage;
        this.shoeText = shoeText;
    }

    public Integer getShoeImage() {
        return shoeImage;
    }

    public Integer  getShoeText() {
        return shoeText;
    }

}
