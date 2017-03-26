package allyson.com.br.desafio_zup.data.realm;

import java.util.List;

import allyson.com.br.desafio_zup.model.Movie;

/**
 * Created by allys on 25/03/2017.
 */

public interface Database {

    List<Movie> loadCatalog();
    void insetMovie(Movie movie);
    Movie getMovie(String movie);

}
