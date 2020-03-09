package com.example.newslistfragment.news;

import java.util.List;
import java.util.Random;

public class NewsCreator {

    private static String[] urlAdress = new String[]{"https://image.winudf.com/v2/image/Y29tLnBlbWFuZGFuZ2FudGVyaW5kYWh3YWxscGFwZXIuYWxmYXRoX3NjcmVlbl8wXzE1MzY4MDUzODRfMDIx/screen-0.jpg?fakeurl=1&type=.jpg",
            "https://www.fotor.com/loopBannerImg/indexBannerImg/banner-01.jpg", "https://www.elitereaders.com/wp-content/uploads/2017/02/feat-2.jpg",
            "https://images.hdqwalls.com/download/best-nature-image-2560x1440.jpg", "https://www.jakpost.travel/wimages/large/54-548017_free-high-resolution-nature-best-nature-wallpaper-hd.jpg",
    "https://pbs.twimg.com/profile_images/1035873131326390272/O9blZ0x1_400x400.jpg","https://www.featurepics.com/StockImage/20170122/beautiful-nature-norway-stock-image-4364710.jpg"};


    private static Random random = new Random();

    public static void creatNews(List<News> newsList) {
        for (int i = 0; i < 10; i++) {
            News news = new News();
            news.setTitle("By Google");
            news.setDescription("Description");
            news.setUrl(urlAdress[random.nextInt(6)]);
            newsList.add(news);

        }
    }

}

