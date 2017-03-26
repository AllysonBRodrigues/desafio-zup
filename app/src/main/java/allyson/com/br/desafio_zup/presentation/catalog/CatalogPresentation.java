package allyson.com.br.desafio_zup.presentation.catalog;

import allyson.com.br.desafio_zup.data.api.Repository;

/**
 * Created by allys on 25/03/2017.
 */

public class CatalogPresentation implements CatalogContracts.Presentation {

    CatalogContracts.View view;
    Repository repository;

    @Override
    public void bind(CatalogContracts.View view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void loadCatalog() {

    }
}
