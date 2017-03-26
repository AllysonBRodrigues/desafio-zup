package allyson.com.br.desafio_zup.data.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Allyson on 25/03/2017.
 * Communication service with retrofit
 */

public class Service {


    private static Retrofit retrofitBuilder(String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static <T> T getService(Class<T> tClass, String url) {
        return retrofitBuilder(url).create(tClass);
    }

}
