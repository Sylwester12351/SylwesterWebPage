package Sylwester.SylwesterWebPage.controllers;

import org.springframework.stereotype.Repository;

@Repository
public class TextData {

    // ALL
    //pl
    private String footer_PL = "Strona postawiona na własnym serwerze RPI 3b+ ";
    private String submit_PL = "Wykonaj"; // err
    private String back_PL = "Powrót";
    //pl end
    // ALL END

    // POLISH HOME
    private String homeHeader_PL = "Witaj na mojej stronie ! Welcome !! 1.0.5 Strona nadal w rozwoju ";
    private String homeContent_PL ="Witam na mojej stronie !\n" +
        "    Pokrótce chciałbym opisać czym się zajmowałem.\n" +
        "    Ukończyłem technikum elektryczne o profilu technik informatyk ponieważ praca z komputerami zawsze była moją pasją.\n" +
        "    Pierwszym ciekawym samodzielnym projektem było napisanie gry multi-player o podobnych zasadach rozgrywki do Counter-Strike ale także posiadała\n" +
        "    mechanizm opadania pocisku nie był to najzwyklejszy raycasting, grę tworzyłem na silniku Unity 5 kod pisałem w języku C#.\n" +
        "    Obecnie zajmuję się językiem Java w którym pisałem projekty takie jak generator haseł, pobieranie wyświetlanie pogody i tworzenie wykresu na podstawie tych informacji,\n" +
        "    konwersja na język mors-a, wysyłanie\n" +
        "    wiadomości mail i obecną stronę używając framework-a Spring strona działa także na moim własnym prywatnym serwerze.\n" +
        "    W dalszym ciągu chcę rozwijać swoje pasje oraz poszerzać horyzonty.\n" +
        "    Zapraszam do obejrzenia mikro-serwisów znajdujących się po lewej stronie w menu ! Wszystkie projekty java jak i kod źródłowy tej strony znajduje się\n" +
        "    na moim profilu GitHub.";
    private String homeMenuBlog_PL = "Test bazy danych h2 login User hasło user";
    private String homeMenuRegister_PL = "Rejestracja nie aktywna";
    private String homeMenuWeather_PL = "Pogoda";
    private String homeMenuCalc_PL = "Kalkulator";
    private String homeMenuPass_PL = "Prosty generator haseł";
    private String homeProfiles_PL = "MOJE PROFILE";
    private String homeMyEmailAddres_PL = "Mój adres kontaktowy Email";
    // POLISH HOME END

    // POLISH WEATHER
    private String weatherTitle_PL = "Temperatura";
    private String weatherHeader_PL = "Możesz sprawdzić jaka jest temperatura w różnych miejscach na świecie !";
    private String weatherInformation_PL = "Musisz podać kraj i miasto na przykład: pl Krakow ";
    private String weatherCountry_PL = "Kraj";
    private String weatherCity_PL = "Miasto";
    private String weatherContent_PL = "Celciusza";
    // POLISH WEATHER END

    // POLISH NEW WEATHER
    private String newWeatherHeader_PL = "Temperatura w mieście :";
    // POLISH NEW WEATHER END

    // POLISH CALCULATOR
    private String calcHeader_PL = "Kalkulator";
    private String calcContent_PL = "Oblicz sobie coś !";
    private String calcContentDT_PL = "Prosty kalkulator";
    // POLISH CALCULATOR END

    // POLISH PASS GENERATOR
    private String passGenHeader = "Wygeneruj hasło";
    private String passGenHeaderResult = "Twoje hasło";
    private String passGenContentL = "Długość hasła: ";
    // POLISH PASS GENERATOR END

    // POLISH BLOG
    private String blogContent = "Przykładowe wpisy możesz dodać własny wpis";
    private String blogName = "Imię";
    private String blogTopic = "Temat";
    private String blogMessage = "Wiadomość";
    // POLISH BLOG END


    public String getHomeMenuRegister_PL() {
        return homeMenuRegister_PL;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public String getBlogName() {
        return blogName;
    }

    public String getBlogTopic() {
        return blogTopic;
    }

    public String getBlogMessage() {
        return blogMessage;
    }

    public String getFooter_PL() {
        return footer_PL;
    }

    public String getSubmit_PL() {
        return submit_PL;
    }

    public String getBack_PL() {
        return back_PL;
    }

    public String getHomeHeader_PL() {
        return homeHeader_PL;
    }

    public String getHomeContent_PL() {
        return homeContent_PL;
    }

    public String getHomeMenuBlog_PL() {
        return homeMenuBlog_PL;
    }

    public String getHomeMenuWeather_PL() {
        return homeMenuWeather_PL;
    }

    public String getHomeMenuCalc_PL() {
        return homeMenuCalc_PL;
    }

    public String getHomeMenuPass_PL() {
        return homeMenuPass_PL;
    }

    public String getHomeProfiles_PL() {
        return homeProfiles_PL;
    }

    public String getHomeMyEmailAddres_PL() {
        return homeMyEmailAddres_PL;
    }

    public String getWeatherTitle_PL() {
        return weatherTitle_PL;
    }

    public String getWeatherHeader_PL() {
        return weatherHeader_PL;
    }

    public String getWeatherInformation_PL() {
        return weatherInformation_PL;
    }

    public String getWeatherCountry_PL() {
        return weatherCountry_PL;
    }

    public String getWeatherCity_PL() {
        return weatherCity_PL;
    }

    public String getWeatherContent_PL() {
        return weatherContent_PL;
    }

    public String getCalcHeader_PL() {
        return calcHeader_PL;
    }

    public String getCalcContent_PL() {
        return calcContent_PL;
    }

    public String getCalcContentDT_PL() {
        return calcContentDT_PL;
    }

    public String getNewWeatherHeader_PL() {
        return newWeatherHeader_PL;
    }

    public String getPassGenHeader() {
        return passGenHeader;
    }

    public String getPassGenContentL() {
        return passGenContentL;
    }

    public String getPassGenHeaderResult() {
        return passGenHeaderResult;
    }

}
