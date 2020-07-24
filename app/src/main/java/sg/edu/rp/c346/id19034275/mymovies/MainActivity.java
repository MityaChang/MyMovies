package sg.edu.rp.c346.id19034275.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<Movie> alMovieList;
    CustomAdapter caMovie;
    ImageView rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar cal = Calendar.getInstance();
        String strDescription = "";

        lvMovie = findViewById(R.id.lvContactsM);
        rating = findViewById(R.id.imgViewRateRow);
        alMovieList = new ArrayList<>();
        strDescription = "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.";
        cal.set(2014, 12, 15);
        alMovieList.add(new Movie("The Avenger", 2012, "pg13", "Action | Sci-Fi", cal.getInstance(), "Golden Village - Bishan", strDescription, 4));
        cal.set(2015, 5, 15);
        alMovieList.add(new Movie("Planes", 2013, "pg", "Animation | Comedy", cal.getInstance(), "Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world", 2));
        cal.set(2020, 3, 20);
        alMovieList.add(new Movie("Sonic the Hedgehog", 2020, "pg", "Action | Adventure | Comedy", cal.getInstance(), "Cathay - AMK Hub", "The world needed a hero; it's got a hedgehog. Powered with incredible speed, Sonic embraces his new home on Earth.", 2));
        caMovie = new CustomAdapter(this, R.layout.row, alMovieList);
        lvMovie.setAdapter(caMovie);

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, MovieDetails.class);
                intent.putExtra("title", alMovieList.get(position).getTitle());
                intent.putExtra("year", alMovieList.get(position).getYear());
                intent.putExtra("rated", alMovieList.get(position).getRated());
                intent.putExtra("genre", alMovieList.get(position).getGenre());
                intent.putExtra("watched_on", alMovieList.get(position).toString());
                intent.putExtra("in_theatre", alMovieList.get(position).getIn_theatre());
                intent.putExtra("description", alMovieList.get(position).getDescription());
                intent.putExtra("rating", alMovieList.get(position).getRating());
                startActivity(intent);

            }
        });
    }
}



