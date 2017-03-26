package allyson.com.br.desafio_zup.presentation.search;

import android.util.Log;

import allyson.com.br.desafio_zup.data.api.Repository;
import allyson.com.br.desafio_zup.model.Movie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by allys on 25/03/2017.
 */

public class SearchPresentation implements SearchContracts.Presentation {

    private SearchContracts.View view;
    private Repository repository;


    @Override
    public void bind(SearchContracts.View view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void getMovie(String nome) {
        repository.requestConteudos(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Log.e("Resposta", response.body().toString());
                Log.e("Resposta", response.body().toString());
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        }, nome);
    }
}
