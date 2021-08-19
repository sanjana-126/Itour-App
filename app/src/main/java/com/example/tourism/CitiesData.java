package com.example.tourism;

import com.example.tourism.adapters.HangoutItem;

import java.util.ArrayList;

class  FunFactItem{
    String funfactinfo;
    int FunFactImage;

    FunFactItem(String info,int image){
        this.funfactinfo = info;
        this.FunFactImage = image;
    }
}

class CityItem{
    int cityid;
    String cityname;
    String description;
    String cityweather;
    String cityweatherdescription;
    int cityHumidity;
    int cityimage;
    double cityLatitude;
    double cityLongitude;
    ArrayList<FunFactItem> funfacts;
    ArrayList<HangoutItem> hangoutItemArrayList;
    ArrayList<HangoutItem> restuarentsItemArrayList;

    public  CityItem(
            int cityid,
            String cityname,
                     String description,
                     String cityweather,
                     String cityweatherdescription,
                     int cityHumidity,
                     int cityimage,
                     double cityLatitude,
                     double cityLongitude,
            ArrayList<FunFactItem> funfacts,
            ArrayList<HangoutItem> hangoutItemArrayList,
            ArrayList<HangoutItem> restuarentsItemArrayList
            ){
        this.cityid = cityid;
        this.cityname   = cityname;
        this.description = description;
        this.cityweather = cityweather;
        this.cityweatherdescription = cityweatherdescription;
        this.cityHumidity = cityHumidity;
        this.cityimage = cityimage;
        this.cityLatitude = cityLatitude;
        this.cityLongitude = cityLongitude;
        this.funfacts = funfacts;
        this.hangoutItemArrayList = hangoutItemArrayList;
        this.restuarentsItemArrayList = restuarentsItemArrayList;
    }
}

public class CitiesData {
    static ArrayList<CityItem> cities = new ArrayList<CityItem>();

    public  void  addcityitem(  int cityid,
                                String cityname,
                                String description,
                                String cityweather,
                                String cityweatherdescription,
                                int cityHumidity,
                                int cityimage,
                                double cityLatitude,
                                double cityLongitude,
                                ArrayList<FunFactItem> funfacts,
                                ArrayList<HangoutItem> hangoutItemArrayList,
                                ArrayList<HangoutItem> restuarentsItemArrayList
                                ){
        CityItem newCity = new CityItem(cityid,cityname,description,cityweather,cityweatherdescription,cityHumidity,cityimage,cityLatitude,cityLongitude,funfacts,hangoutItemArrayList,restuarentsItemArrayList);
        cities.add(newCity);
    }
    public void addcity(){
        addmumbai();
        adddelhi();
        addbangalore();
       addchennai();
    }
    public  CityItem getCity(int id){
        for (int i = 0; i < cities.size(); i++) {
            if(cities.get(i).cityid == id){
                return  cities.get(i);
            }
        }
        return  null;
    }

    public  void addmumbai(){
        ArrayList<FunFactItem> funfactsMumbai = new ArrayList<FunFactItem>();
        ArrayList<HangoutItem> hangoutItemArrayList = new ArrayList<HangoutItem>();
        ArrayList<HangoutItem> restuarentsItemArrayList = new ArrayList<HangoutItem>();
        funfactsMumbai.add(new FunFactItem("India’s first ever train ran between Mumbai and Thane\n" +
                "On 16 April 1853, India’s first train commenced its operation. Mumbai Locals are the busiest railways in the world and carry about 2.2 billion passengers every year. Mumbai also has the most obsolete electric rail chain in India, which was installed in 1925.",R.drawable.mumbai3));
        funfactsMumbai.add(new FunFactItem("Mumbai was the first one to start a bus service in India\n" +
                "It was on 15 July 1926, that the first ever bus service in India was started. The first route was ridden between Afghan Church and Crawford Market.",R.drawable.mumbai4));
        funfactsMumbai.add(new FunFactItem(" World’s most expensive house is in Mumbai\n" +
                "Antilia, Mukesh Ambani’s 27-story skyscraper is cited as the world’s most expensive house, valued at almost $1 billion. The business tycoon moved into the 400,000 square feet mansion in 2012 with his wife and three children.",R.drawable.mumbai5));

        hangoutItemArrayList.add(new HangoutItem(R.drawable.marinedrive,"Marine Drive","3.6-kilometre-long Promenad",
                "Marine Drive linking Nariman Point to Babulnath is a major landmark within the borders of Mumbai tourist spots. It has a string of sparkling lights adorning the town just like a “Queen’s Necklace”. The boulevard is about 3 km long, with the Girgaum Chowpatty beach at the north end and it is one among the perfect hangout places in Mumbai for friends.",16.6602349,73.4780744));

        hangoutItemArrayList.add(new HangoutItem(R.drawable.chowpatty,"Chowpatty","Beach",
                "A popular locality in South Mumbai, Girgaum Chowpatty beach is situated in northern end of Marine Drive curving round the coast. The place is bustling with activity in the evenings and is popular for its snack stalls that are available at evenings. With people flocking to satisfy their hunger pangs, this place receives a heavy footfall every single day.",18.9542624,72.8077065));

        hangoutItemArrayList.add(new HangoutItem(R.drawable.juhu,"Juhu","Home to many celebrities",
                "Juhu is home to many celebrities, and therefore the beach features a carnival-like atmosphere during the year. Balloon stalls, kites, sand sculptures, rides, horse rides, stalls selling food to jewelry are often found here. Unarguably, the simplest place to hold out with friends in Mumbai, a couple of hours spent here will remain etched in the memories forever.",19.1012636,72.8120343));
       hangoutItemArrayList.add(new HangoutItem(R.drawable.sgnp,"Sanjay Gandhi National Park"," National Park",
                "Sanjay Gandhi Park is frequented by many early morning fitness enthusiasts and picnickers. There are a number of attractions just like the wildlife safari, toy train, trekking, a ship ride on the lake and hand-carved Kanheri Buddhist caves, scattered over the hilltop. Each cave has been carved out of igneous rock and has towering, impactful sculptures of Buddha",
               19.2288092,72.9159897));
        hangoutItemArrayList.add(new HangoutItem(R.drawable.smash,"Smaaash"," fun spot",
                "There are a variety of games for all age groups including bumper cars, air hockey, football and even a restaurant that serves a wide range of kid-friendly food items. They even have go-karting. Kids love coming here because it is one among the foremost fun spots.",
                19.1008235,72.7832565));
         hangoutItemArrayList.add(new HangoutItem(R.drawable.snowworld,"Snow World"," theme park",
                "This one among many major theme parks in Mumbai happens to be a big hit with the youngsters of the city because it offers them the experience of playing in snow and also trying out some fun rides. A number of the activities include snowboarding, skating, ice sliding and much more are available here and one can enjoy the pleasures of the snow without having to leave the city.",
                 19.0863795,72.8867887));


        restuarentsItemArrayList.add(new HangoutItem(R.drawable.snowworld,"Snow World"," theme park",
                "This one among many major theme parks in Mumbai happens to be a big hit with the youngsters of the city because it offers them the experience of playing in snow and also trying out some fun rides. A number of the activities include snowboarding, skating, ice sliding and much more are available here and one can enjoy the pleasures of the snow without having to leave the city.",
                19.0863795,72.8867887));


        addcityitem(R.drawable.mumbai,"Mumbai","Mumbai (formerly called Bombay) is a densely populated city on India’s west coast. A financial center, it's India's largest city.  The city's also famous as the heart of the Bollywood film industry. ",
                "25 C","clear Sky",93,R.drawable.mumbai2,19.0821978,72.7411,funfactsMumbai,hangoutItemArrayList,restuarentsItemArrayList);
    }
    public  void adddelhi(){
        ArrayList<FunFactItem> funfactsMumbai = new ArrayList<FunFactItem>();
        ArrayList<HangoutItem> hangoutItemArrayList = new ArrayList<HangoutItem>();
        ArrayList<HangoutItem> restuarentsItemArrayList = new ArrayList<HangoutItem>();
        funfactsMumbai.add(new FunFactItem("Every 5 minute a person is bitten by stray dogs in mumbai",R.drawable.mumbai));
        funfactsMumbai.add(new FunFactItem("Another Fun Fact",R.drawable.mumbai));

        hangoutItemArrayList.add(new HangoutItem(R.drawable.mumbai,"India Gate","Old Monument",
                "built in 40's",77,88));
        addcityitem(R.drawable.delhi,"Delhi","Famous For India Gate",
                "25 C","clear Sky",93,R.drawable.delhi,19.0821978,72.7411,funfactsMumbai,hangoutItemArrayList,restuarentsItemArrayList);
    }

    public  void addbangalore(){
        ArrayList<FunFactItem> funfactsMumbai = new ArrayList<FunFactItem>();
        ArrayList<HangoutItem> hangoutItemArrayList = new ArrayList<HangoutItem>();
        ArrayList<HangoutItem> restuarentsItemArrayList = new ArrayList<HangoutItem>();
        funfactsMumbai.add(new FunFactItem("Every 5 minute a person is bitten by stray dogs in mumbai",R.drawable.mumbai));
        funfactsMumbai.add(new FunFactItem("Another Fun Fact",R.drawable.mumbai));

        hangoutItemArrayList.add(new HangoutItem(R.drawable.mumbai,"India Gate","Old Monument",
                "built in 40's",77,88));
        addcityitem(R.drawable.bangalore,"Bangalore","City Famous For IT Industires",
                "25 C","clear Sky",93,R.drawable.bangalore,19.0821978,72.7411,funfactsMumbai,hangoutItemArrayList,restuarentsItemArrayList);
    }
    public  void addchennai(){
        ArrayList<FunFactItem> funfactsMumbai = new ArrayList<FunFactItem>();
        ArrayList<HangoutItem> hangoutItemArrayList = new ArrayList<HangoutItem>();
        ArrayList<HangoutItem> restuarentsItemArrayList = new ArrayList<HangoutItem>();
        funfactsMumbai.add(new FunFactItem("Every 5 minute a person is bitten by stray dogs in mumbai",R.drawable.mumbai));
        funfactsMumbai.add(new FunFactItem("Another Fun Fact",R.drawable.mumbai));

        hangoutItemArrayList.add(new HangoutItem(R.drawable.mumbai,"India Gate","Old Monument",
                "built in 40's",77,88));
        addcityitem(R.drawable.chennai,"Chennai","Very Hot City",
                "25 C","clear Sky",93,R.drawable.chennai,19.0821978,72.7411,funfactsMumbai,hangoutItemArrayList,restuarentsItemArrayList);
    }
}
