package businesscard;

import java.util.ArrayList;
import java.util.List;

public class BusinessCardData {

    private int maxNum;
    private List<BusinessCard> businessCards = new ArrayList<>();


    public BusinessCardData() {
        this.maxNum = 1;
        this.businessCards = businessCards;
    }
/*
    public BusinessCardData(List<BusinessCard> businessCards, int maxNum) {
        this.maxNum = maxNum = 1;
        this.businessCards = businessCards;

    }*/

    public int getMaxNum() {

        return maxNum++;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public void add(BusinessCard bc){
        businessCards.add(bc);

    }



    public List<BusinessCard> getBusinessCards() {
        return businessCards;
    }

    public void setBusinessCards(List<BusinessCard> businessCards) {
        this.businessCards = businessCards;
    }


    @Override
    public String toString() {
        return "BusinessCardData{" +
                "businessCards=" + businessCards +
                ", maxNum=" + maxNum +
                '}';
    }
}
