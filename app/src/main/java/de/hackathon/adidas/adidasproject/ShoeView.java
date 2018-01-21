package de.hackathon.adidas.adidasproject;

import android.graphics.drawable.Drawable;

/**
 * Created by ankit on 1/21/18.
 */

public class ShoeView {

    private Integer shoeImage;
    private Integer shoeText;
    private Integer priceText;


    public ShoeView(Integer shoeImage, Integer shoeText, Integer priceText) {
        this.shoeImage = shoeImage;
        this.shoeText = shoeText;
        this.priceText = priceText;
    }

    public Integer getShoeImage() {
        return shoeImage;
    }

    public Integer getShoeText() {
        return shoeText;
    }

    public Integer getPriceText() {
        return priceText;
    }

}
