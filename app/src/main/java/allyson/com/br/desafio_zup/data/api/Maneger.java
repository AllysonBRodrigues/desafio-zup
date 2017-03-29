package allyson.com.br.desafio_zup.data.api;

import java.util.List;

import allyson.com.br.desafio_zup.Util.URL;
import allyson.com.br.desafio_zup.data.service.IMovie;
import allyson.com.br.desafio_zup.data.service.Service;
import allyson.com.br.desafio_zup.model.Movie;
import retrofit2.Callback;

/**
 * Created by Allyson Rodrigues on 25/03/2017.
 *
 */

public class Maneger implements Repository{
    @Override
    public void requestMovies(Callback<Movie> callback, String movie) {
        Service.getService(IMovie.class, URL.URL_PRINCIPAL).getMovie(movie).enqueue(callback);
    }
}
