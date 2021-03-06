package Sylwester.SylwesterWebPage.weatherPage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import static Sylwester.SylwesterWebPage.weatherPage.ConfWeather.*;
@Service
public class GetTemp {
    private String temperature = null;
    public String getTemperature() {
        return temperature;
    }
    @Override
    public String toString() {
        return "GetTemp{" +
                "temperature='" + temperature + '\'' +
                '}';
    }

    public void convert(){
        URL url = null;
        try {
            url = new URL(SERVICE + City + "," + Country + "&" + "units=" + Type + "&" + "APPID=" + ApiID);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Temp
        if (!StringUtils.isBlank(line)) {
            int startIndex = line.indexOf("{\"temp\"") + 8;
            int endIndex = line.indexOf(",\"feels_like\"");
            temperature = line.substring(startIndex, endIndex);

        }
    }
    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
