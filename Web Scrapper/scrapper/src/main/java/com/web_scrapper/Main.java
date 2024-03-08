package com.web_scrapper;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    public static void main(String[] args) {
        String url = "https://www.geeksforgeeks.org/interesting-facts-about-java/";
        try{
            Document document = Jsoup.connect(url).get();
            Elements facts = document.select(".text");

            String content = "";
            for(Element fact : facts){
                content = fact.select("ol > li").text();
            }

            ArrayList<StringBuilder> lines = new ArrayList<>();
            StringBuilder sb = new StringBuilder("");
            for(char data : content.toCharArray()){
                if(data != '.'){
                    sb.append(data);
                } else {
                    sb.append('.');
                    lines.add(sb);
                    sb = new StringBuilder("");
                }
            }

            // System.out.println(lines);
            for(var i: lines){
                System.out.println(i);
            }

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}