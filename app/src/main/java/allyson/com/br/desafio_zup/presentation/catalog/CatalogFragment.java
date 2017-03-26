package allyson.com.br.desafio_zup.presentation.catalog;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import allyson.com.br.desafio_zup.R;
import allyson.com.br.desafio_zup.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatalogFragment extends BaseFragment {


    public CatalogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_catalog, container, false);
    }

}
