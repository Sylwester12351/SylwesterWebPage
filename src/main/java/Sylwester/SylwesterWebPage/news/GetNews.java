package Sylwester.SylwesterWebPage.news;


import Sylwester.SylwesterWebPage.entity.NewsDataBase;
import Sylwester.SylwesterWebPage.repository.NewsRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
https://newsapi.org/v2/top-headlines?country=pl&apiKey=3c8eb98927654bf0adc6701d5e46a2fd
* */
public class GetNews {
    List<String> list = new ArrayList<>();
    String name;
    String author;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void convert() {
        String inline = "";
        try {
            URL url = new URL("https://newsapi.org/v2/top-headlines?country=pl&apiKey=3c8eb98927654bf0adc6701d5e46a2fd");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();
            if (responsecode != 200)
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            else {
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()) {
                    inline += sc.nextLine();
                }
                //System.out.println(inline);
                JSONParser parse = new JSONParser();
                JSONObject jobj = (JSONObject) parse.parse(inline);
                JSONArray jsonarr_1 = (JSONArray) jobj.get("articles");
                for (int i = 0; i < jsonarr_1.size(); i++) {
                    JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
                    list.add(jsonobj_1.get("title").toString()+"~~");
                }
            }


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }
}






