package com.example.pdfgenerator.model;

public class KeyValuePair {


    private String key;
    private String value;

    public KeyValuePair() {

    }

    public KeyValuePair(String key, String value) {
        super();
        this.key = key;
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }
}
