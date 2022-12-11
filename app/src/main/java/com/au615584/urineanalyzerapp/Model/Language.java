package com.au615584.urineanalyzerapp.Model;

//Model for language Object used in LanguageAdapter
public class Language {
    public String language;
    public int imageResourceId;
    public String langCode;


    public Language(String language, int imageResourceId, String langCode) {
        this.language = language;
        this.imageResourceId = imageResourceId;
        this.langCode=langCode;
    }
}
