package com.example.kanjicardn4;

public class Vocabulary {

    private String name;
    private String url;
    private String longDesc;

    public Vocabulary(String name, String url, String longDesc) {
        this.name = name;
        this.url = url;
        this.longDesc = longDesc;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getLongDesc() {
        return longDesc;
    }
}
