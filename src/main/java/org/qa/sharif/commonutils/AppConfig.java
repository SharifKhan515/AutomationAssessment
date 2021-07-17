package org.qa.sharif.commonutils;

public class AppConfig{

    public static PropertyHelper propertyHelper = new PropertyHelper();
    public static void main(String[] args) {
        System.out.println(getBaseUrl());
    }

    public static String getBaseUrl(){
        return    propertyHelper.getPropertyValue("base.url");
    }

    public static String getDefaultBrowser(){
        return propertyHelper.getPropertyValue("defaultBrowser.name");
    }
}
