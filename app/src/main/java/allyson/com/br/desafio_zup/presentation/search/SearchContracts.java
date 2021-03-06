package allyson.com.br.desafio_zup.presentation.search;

import android.os.Bundle;

import java.util.List;

import allyson.com.br.desafio_zup.data.api.Repository;
import allyson.com.br.desafio_zup.model.Movie;


/**
 * Created by allys on 25/03/2017.
 */

interface SearchContracts {

    interface Presentation {
        void bind(SearchContracts.View view, Repository repository);

        void getMovie(String nome);
    }


    interface View {
        void returnMovie(Movie movie);

        void erro();

        void checkInstanceState(Bundle instanceState);

    }


}
