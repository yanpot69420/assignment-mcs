package com.example.assignment1;


public class Historys extends Products {
    String hsId;
    Integer hsQuant;
    Integer hsTprice;
    String hsDate;

    Historys(Integer hsImage, String hsId, String hsName, Integer hsQuant, Integer hsTprice,String hsDate){
        productImage = hsImage;
        this.hsId = hsId;
        productName = hsName;
        this.hsQuant = hsQuant;
        this.hsTprice = hsTprice;
        this.hsDate = hsDate;
    }
    public Historys(Historys newList) {
        productImage = newList.productImage;
        this.hsId = newList.hsId;
        productName = newList.productName;
        this.hsQuant = newList.hsQuant;
        this.hsTprice = newList.hsTprice;
        this.hsDate = newList.hsDate;
    }
    Historys(){

    }
}
