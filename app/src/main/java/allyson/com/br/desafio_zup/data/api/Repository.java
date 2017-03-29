package allyson.com.br.desafio_zup.data.api;

import java.util.List;

import allyson.com.br.desafio_zup.model.Movie;
import retrofit2.Callback;

/**
 * Created by Allyson Rodrigues on 25/03/2017.
 * Requests interface for web service
 */

public interface Repository {

    void requestMovies(Callback<Movie> callback, String movie);

}
