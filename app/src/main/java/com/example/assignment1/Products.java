package com.example.assignment1;


public class Products {
    String productName;
    Integer productRating;
    Integer productPrice;
    Integer productImage;
    String productDescription;

    Products(String productName, Integer productRating, Integer productPrice,Integer productImage, String productDescription){
        this.productName = productName;
        this.productRating = productRating;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productDescription = productDescription;
    }

    Products(){ }
}
