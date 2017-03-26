package allyson.com.br.desafio_zup.presentation.main;

import android.os.Bundle;
import android.util.Log;

import allyson.com.br.desafio_zup.R;
import allyson.com.br.desafio_zup.base.BaseActivity;
import allyson.com.br.desafio_zup.data.api.Maneger;
import allyson.com.br.desafio_zup.model.Movie;

public class MainActivity extends BaseActivity implements SearchContracts.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SearchPresentation searchPresentation = new SearchPresentation();
        searchPresentation.bind(this, new Maneger());
        searchPresentation.getMovie("Star wars");

    }

    @Override
    public void returnMovie(Movie movies) {
        Log.e("Nome", movies.getTitle());
        Log.e("Atores", movies.getActors());
    }

    @Override
    public void erro() {

    }
}
