package allyson.com.br.desafio_zup.presentation.search;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import allyson.com.br.desafio_zup.CommonInterfaces.OnItemClickListener;
import allyson.com.br.desafio_zup.R;
import allyson.com.br.desafio_zup.data.api.Maneger;
import allyson.com.br.desafio_zup.model.Movie;
import allyson.com.br.desafio_zup.presentation.description.DescriptionFragment;
import allyson.com.br.desafio_zup.presentation.main.MainActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements OnItemClickListener, SearchContracts.View {

    @BindView(R.id.et_movie)
    AppCompatEditText et_movie;
    @BindView(R.id.rv_movies)
    RecyclerView rv_movies;

    private List<Movie> movies;
    private OnItemClickListener onItemClickListener = this;
    private SearchAdapter searchAdapter;
    private SearchContracts.Presentation presentation;
    private ProgressDialog progressDialog;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this, view);
        presentation = new SearchPresentation();
        presentation.bind(this, new Maneger());

        et_movie.setOnEditorActionListener(new AppCompatEditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    progressDialog = new ProgressDialog(getActivity());
                    progressDialog.setMessage("Pesquisando...");
                    progressDialog.show();
                    presentation.getMovie(et_movie.getText().toString());
                    return true;
                }
                return false;
            }
        });

        rv_movies.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv_movies.getContext(),
                new LinearLayoutManager(getActivity()).getOrientation());
        rv_movies.addItemDecoration(dividerItemDecoration);

        checkInstanceState(savedInstanceState);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (this.movies.size() > 0) {
            Gson gson = new Gson();
            List<Movie> movies = new ArrayList<>();
            movies.addAll(this.movies);
            outState.putString("movies", gson.toJson(movies));
        }
    }


    @Override
    public void OnClick(int pos, Object object) {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.getFragmentManagerTransaction(new DescriptionFragment(), "DESCRIPTION");
    }

    @Override
    public void returnMovie(Movie movie) {
        progressDialog.dismiss();
        if (movie.getImdbID() != null) {
            movies = new ArrayList<>();
            movies.add(movie);
            searchAdapter = new SearchAdapter(getActivity(), movies, onItemClickListener);
            rv_movies.setAdapter(searchAdapter);
            searchAdapter.notifyDataSetChanged();

        } else {
            Toast.makeText(getActivity(), "Filme não encontrado", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void erro() {
        Toast.makeText(getActivity(), "Erro ao buscar filme", Toast.LENGTH_LONG).show();
    }

    @Override
    public void checkInstanceState(Bundle instanceState) {
        if (instanceState != null) {
            Gson gson = new Gson();
            Type tipoLista = new TypeToken<ArrayList<Movie>>() {
            }.getType();
            movies = new ArrayList<>();
            this.movies = gson.fromJson(instanceState.getString("movies"), tipoLista);
            searchAdapter = new SearchAdapter(getActivity(), movies, onItemClickListener);
            rv_movies.setAdapter(searchAdapter);
            searchAdapter.notifyDataSetChanged();
        }
    }
}
