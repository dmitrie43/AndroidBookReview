package book.bookReview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

//Класс для упрощения связывания данных с элементов управдения
class MovieAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<Movie> movieArrayList;
    private LayoutInflater inflater;

    MovieAdapter(Activity activity, ArrayList<Movie> movieArrayList) {
        this.activity = activity;
        this.movieArrayList = movieArrayList;
    }

    @Override
    public int getCount() {
        return this.movieArrayList.size();
    }

    @Override
    public Movie getItem(int position) {
        return this.movieArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.movie_list_item, null);

        TextView name = (TextView) convertView.findViewById(R.id.nameTextView);
        TextView description = (TextView) convertView.findViewById(R.id.descriptionTextView);
        TextView author = (TextView) convertView.findViewById(R.id.authorTextView);
        ImageView image = (ImageView) convertView.findViewById(R.id.imageView);
        TextView date = (TextView) convertView.findViewById(R.id.dateTextView);
        TextView countPages = (TextView) convertView.findViewById(R.id.countPagesTextView);

        final Movie movie = getItem(position);
        name.setText(movie.getName());
        if (movie.getDescription().length() <= 150) {
            description.setText(movie.getDescription());
        } else {
            description.setText(movie.getDescription().substring(0, 150) + "...");
        }
        author.setText("Автор: " + movie.getAuthor());
        date.setText("Год публикации: " + movie.getDate());
        countPages.setText(movie.getCountPages() + " страниц");


        Picasso.get().load(movie.getImage()).into(image);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, WatchMovieActivity.class);
                intent.putExtra("name", movie.getName());
                intent.putExtra("description", movie.getDescription());
                intent.putExtra("author", movie.getAuthor());
                intent.putExtra("image", movie.getImage());
                intent.putExtra("url", movie.getUrl());
                intent.putExtra("date", movie.getDate());
                intent.putExtra("countPages", movie.getCountPages());

                activity.startActivity(intent);
            }
        });

        return convertView;
    }
}
