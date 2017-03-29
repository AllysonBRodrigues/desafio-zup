package allyson.com.br.desafio_zup.data.service;

import java.util.List;

import allyson.com.br.desafio_zup.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by allys on 25/03/2017.
 */

public interface IMovie {

    @GET(".")
    Call<Movie> getMovie(@Query("t") String movie);

}
