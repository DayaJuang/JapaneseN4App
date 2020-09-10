package com.example.kanjicardn4;

public class Kanji {

    private String name;
    private String url;
    private String desc;
    private String onYomi;
    private String kunYomi;
    private String[] wordList;

    public Kanji(String name, String url, String desc, String onYomi, String kunYomi, String[] wordList) {
        this.name = name;
        this.url = url;
        this.desc = desc;
        this.onYomi = onYomi;
        this.kunYomi = kunYomi;
        this.wordList = wordList;
    }

    public String getOnYomi() {
        return onYomi;
    }

    public String getKunYomi() {
        return kunYomi;
    }

    public String[] getWordList() {
        return wordList;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getDesc() {
        return desc;
    }
}
