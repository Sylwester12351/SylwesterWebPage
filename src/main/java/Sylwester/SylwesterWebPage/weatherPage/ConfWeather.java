package Sylwester.SylwesterWebPage.weatherPage;

public class ConfWeather {
    public static String City = "Krakow";
    public static String Country = "pl";
    public static String Type = "metric";
    public static String ApiID = "46da914e3b04bc6125fdb728f355cd0e";

    public static String getCity() {
        return City;
    }

    public static void setCity(String city) {
        City = city;
    }

    public static String getCountry() {
        return Country;
    }

    public static void setCountry(String country) {
        Country = country;
    }

    public static final String SERVICE = "http://api.openweathermap.org/data/2.5/weather?q=";
}
