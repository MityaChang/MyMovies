package sg.edu.rp.c346.id19034275.mymovies;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MovieDetails extends AppCompatActivity {
    ArrayList<Movie> movieList = new ArrayList<Movie>();
    ImageView ivRating;
    TextView tvTitle, tvCategory, tvDescription, tvWatchedOn, tvInTheatre;
    RatingBar ratingBar;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating_detail);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int year = intent.getIntExtra("year", 0);
        String rate = intent.getStringExtra("rated");
        String genre = intent.getStringExtra("genre");
        String watchon = intent.getStringExtra("watched_on");
        String theatre = intent.getStringExtra("in_theatre");
        String description = intent.getStringExtra("description");
        int ratingnumber = intent.getIntExtra("rating", 0);

        ivRating = findViewById(R.id.imgViewRateRT);
        tvTitle = findViewById(R.id.tvTitleRT);
        tvCategory = findViewById(R.id.tvCategoryRT);
        tvDescription = findViewById(R.id.tvDescRT);
        tvWatchedOn = findViewById(R.id.tvWatchRT);
        tvInTheatre = findViewById(R.id.tvTheatreRT);
        ratingBar = findViewById(R.id.ratingBar);

        switch (rate) {
            case "g":
                ivRating.setImageResource(R.drawable.rating_g);
                break;
            case "pg":
                ivRating.setImageResource(R.drawable.rating_pg);
                break;
            case "pg13":
                ivRating.setImageResource(R.drawable.rating_pg13);
                break;
            case "nc16":
                ivRating.setImageResource(R.drawable.rating_nc16);
                break;
            case "m18":
                ivRating.setImageResource(R.drawable.rating_m18);
                break;
            case "r21":
                ivRating.setImageResource(R.drawable.rating_r21);
                break;
        }

        tvTitle.setText(title);
        if (year == 2020) {
            tvTitle.setTextColor(getResources().getColor(R.color.title2020, null));
        }
        String strCategory = (year) + " - " + genre;
        tvCategory.setText(strCategory);
        tvDescription.setText(description);
        tvWatchedOn.setText("Watched On: " + watchon);
        tvInTheatre.setText("In Theatre: " + theatre);
        ratingBar.setRating(ratingnumber);

    }
}
