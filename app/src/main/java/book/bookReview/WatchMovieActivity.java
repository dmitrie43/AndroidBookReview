package book.bookReview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

public class WatchMovieActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener {

    public String urlPath;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        //Задаем внешний вид интерфейса
        setContentView(R.layout.watch_movie);
        //Добавляем размещение элементов

        YouTubePlayerSupportFragment frag =
                (YouTubePlayerSupportFragment) getSupportFragmentManager().findFragmentById(R.id.youtubePlay);
        frag.initialize(YouTubeConfig.getApiKey(), this);

//        mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlay);

        final Intent intent = getIntent();
        //Получаем нужные данные
        String name = intent.getStringExtra("name");
        String description = intent.getStringExtra("description");
        String author = intent.getStringExtra("author");
        String image = intent.getStringExtra("image");
        int date = intent.getIntExtra("date", 0);
        int countPages = intent.getIntExtra("countPages", 0);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (actionBar != null) {
            actionBar.setTitle(name);
        }

        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        TextView authorTextView = (TextView) findViewById(R.id.authorTextView);
        TextView descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);
        ImageView imageView = (ImageView) findViewById(R.id.movieImage);
        TextView dateTextView = (TextView) findViewById(R.id.dateTextView);
        TextView countPagesTextView = (TextView) findViewById(R.id.countPagesTextView);

        nameTextView.setText(name);
        authorTextView.setText("Автор: " + author);
        descriptionTextView.setText(description);
        Picasso.get().load(image).into(imageView);
        dateTextView.setText(date + " год публикации");
        countPagesTextView.setText(countPages + " страниц");

//        VideoView videoView = (VideoView) findViewById(R.id.videoView);
//        String uriPath = intent.getStringExtra("url");
//        Uri uri = Uri.parse(uriPath);
//        videoView.setVideoURI(uri);
//        videoView.requestFocus();
//        videoView.start();

//        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                String urlPath = intent.getStringExtra("url");
//                youTubePlayer.loadVideo(urlPath);
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//            }
//        };
//        mYouTubePlayerView.initialize(YouTubeConfig.getApiKey(), mOnInitializedListener);

        this.urlPath = intent.getStringExtra("url");

    }

    public String getUrlPath() {
        return urlPath;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(getUrlPath());
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
