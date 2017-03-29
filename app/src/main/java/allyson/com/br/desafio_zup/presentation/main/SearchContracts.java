package allyson.com.br.desafio_zup.presentation.main;

import java.util.List;

import allyson.com.br.desafio_zup.data.api.Repository;
import allyson.com.br.desafio_zup.model.Movie;


/**
 * Created by allys on 25/03/2017.
 */

interface SearchContracts {

    interface Presentation {
        void bind(View view, Repository repository);

        void getMovie(String nome);
    }


    interface View {
        void returnMovie(Movie movies);

        void erro();
    }


}
