package com.wire.test.model;

import java.util.ArrayList;
import java.util.List;

public class ExchangeInfo {
    private List<String> receptionCountry;
    private double exchangeValue;
    private double remittanceAmount;
    private String selectCountry;
    private String moneyType;

    public ExchangeInfo() {
        this.receptionCountry = initCountryList();
        this.exchangeValue = 0.0;
        this.remittanceAmount = 0;
        this.selectCountry = null;
    }

    public List<String> getReceptionCountry() {
        return receptionCountry;
    }

    public double getExchangeValue() {
        return exchangeValue;
    }

    public void setExchangeValue(double exchangeValue) {
        this.exchangeValue = exchangeValue;
    }

    public double getRemittanceAmount() {
        return remittanceAmount;
    }

    public void setRemittanceAmount(double remittanceAmount) {
        this.remittanceAmount = remittanceAmount;
    }

    public String getSelectCountry() {
        return selectCountry;
    }

    public void setSelectCountry(String selectCountry) {
        this.selectCountry = selectCountry;
    }

    private List<String> initCountryList() {
        List<String> countryList = new ArrayList<>();
        countryList.add("한국(KRW)");
        countryList.add("일본(JPY)");
        countryList.add("필리핀(PHP)");

        return countryList;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }
}
