package allyson.com.br.desafio_zup.presentation.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import allyson.com.br.desafio_zup.R;
import allyson.com.br.desafio_zup.base.BaseActivity;
import allyson.com.br.desafio_zup.presentation.search.SearchFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        if (savedInstanceState == null) {
            getFragmentManagerTransaction(new SearchFragment(), "SEARCH");
        }
    }

    public void getFragmentManagerTransaction(Fragment fragment, String fragmentDestiny) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment, fragmentDestiny).addToBackStack("pilha").commitAllowingStateLoss();
    }


}
