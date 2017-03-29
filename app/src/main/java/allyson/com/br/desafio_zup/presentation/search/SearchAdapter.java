package allyson.com.br.desafio_zup.presentation.search;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import allyson.com.br.desafio_zup.CommonInterfaces.OnItemClickListener;
import allyson.com.br.desafio_zup.R;
import allyson.com.br.desafio_zup.model.Movie;

/**
 * Created by Allyson Rodrigues on 26/03/2017.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private List<Movie> movies;
    private OnItemClickListener onItemClickListener;
    private Context context;

    public SearchAdapter(Context context, List<Movie> movies, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.movies = movies;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_adapter_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.tv_title.setText(movie.getYear() != null ? movie.getTitle() + " (" + movie.getYear() + ")" : movie.getTitle());
        holder.tv_synopsis.setText(movie.getPlot());
        holder.tv_rating.setText(movie.getImdbRating()+"/10");
        try {
            Picasso.with(context)
                    .load(movie.getPoster())
                    .resize(100, 75)
                    .into(holder.iv_poster);
        } catch (Exception ex) {
            Log.e("ERRO", "Imagem não disponível");
            holder.iv_poster.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private AppCompatTextView tv_title;
        private AppCompatTextView tv_synopsis;
        private AppCompatImageView iv_poster;
        private AppCompatTextView tv_rating;
        ViewHolder(View v) {
            super(v);
            tv_title = (AppCompatTextView) v.findViewById(R.id.tv_title);
            tv_synopsis = (AppCompatTextView) v.findViewById(R.id.tv_plot);
            iv_poster = (AppCompatImageView) v.findViewById(R.id.iv_poster);
            tv_rating = (AppCompatTextView) v.findViewById(R.id.tv_rating);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (!movies.isEmpty()) {
                onItemClickListener.OnClick(getAdapterPosition(), movies.get(getAdapterPosition()));
            }
        }
    }

}
