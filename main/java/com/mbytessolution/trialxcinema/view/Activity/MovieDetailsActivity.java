package com.mbytessolution.trialxcinema.view.Activity;

import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mbytessolution.trialxcinema.R;
import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {

    private String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w780";
    private ImageView second_banner_image, play;
    private CircleImageView first_banner_image;
    private TextView title, rating, release_date, language, overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        initView();
    }

    private void initView() {
        second_banner_image = (ImageView) findViewById(R.id.second_banner);
        play = (ImageView) findViewById(R.id.play);
        first_banner_image = (CircleImageView) findViewById(R.id.first_banner);
        title = (TextView) findViewById(R.id.title);
        rating = (TextView) findViewById(R.id.rating);
        release_date = (TextView) findViewById(R.id.release_date);
        language = (TextView) findViewById(R.id.language);
        overview = (TextView) findViewById(R.id.overview);

        String second_banner = getIntent().getStringExtra("second_banner");
        String first_banner = getIntent().getStringExtra("first_banner");
        String movie_title = getIntent().getStringExtra("movie_title");
        String rating1 = getIntent().getStringExtra("rating");
        String date = getIntent().getStringExtra("date");
        String language1 = getIntent().getStringExtra("language");
        String Overview1 = getIntent().getStringExtra("Overview");
        Picasso.get().load(BASE_IMAGE_URL+second_banner).placeholder(R.drawable.placeholder_loading)
                .error(R.drawable.placeholder_loading).into(second_banner_image);

        Picasso.get().load(BASE_IMAGE_URL+first_banner).placeholder(R.drawable.placeholder_loading)
                .error(R.drawable.placeholder_loading).into(first_banner_image);
        title.setText(movie_title);
        rating.setText(rating1);
        release_date.setText(date);
        if (language1.equalsIgnoreCase("en")) {
            language.setText("English");
        }

        overview.setText(Overview1);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MovieDetailsActivity.this, VideoPlayerActivity.class);
                startActivity(intent);

            }
        });
    }
}