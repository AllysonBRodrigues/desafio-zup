package allyson.com.br.desafio_zup.presentation.catalog;

import android.os.Bundle;

import java.util.List;

import allyson.com.br.desafio_zup.data.api.Repository;
import allyson.com.br.desafio_zup.model.Movie;

/**
 * Created by Allyson Rodrigues on 25/03/2017.
 */

interface CatalogContracts {

    interface Presentation {
        void bind(View view, Repository repository);

        void loadCatalog();
    }

    interface View {
        void updateView(List<Movie> movies);

        void erro();

        void checkInstanceState(Bundle instanceState);
    }


}
