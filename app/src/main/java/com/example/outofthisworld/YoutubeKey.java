package com.example.outofthisworld;

public class YoutubeKey {

    public YoutubeKey() {

    }

    //this file just stores the api key for the youtube api and contains a getter that is used in YoutubeTopic class rather than adding key directly in there
    //created a new file for reusability and easy access of the key
    public static final String API_KEY = "AIzaSyCKdrq-6LyA7sM-KPE0Fd-B9q9WEsRQKw0";

    public static String getApiKey() {
        return API_KEY;
    }

}




