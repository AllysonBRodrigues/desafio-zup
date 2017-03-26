package allyson.com.br.desafio_zup.data.realm;

import java.util.List;

import allyson.com.br.desafio_zup.model.Movie;

/**
 * Created by Allyson Rodrigues on 25/03/2017.
 */

public class Maneger implements Database{

    @Override
    public List<Movie> loadCatalog() {
        return null;
    }

    @Override
    public void insetMovie(Movie movie) {

    }

    @Override
    public Movie getMovie(String movie) {
        return null;
    }
}
