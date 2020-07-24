package sg.edu.rp.c346.id19034275.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);
        this.parent_context = context;
        this.layout_id = resource;
        this.movieList = objects;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvCategory = rowView.findViewById(R.id.tvCategoryR);
        TextView tvTitle = rowView.findViewById(R.id.tvTitleR);
        ImageView ivRating = rowView.findViewById(R.id.imgViewRateRow);

        Movie currentItem = movieList.get(position);
        tvTitle.setText(currentItem.getTitle());
        if (currentItem.getYear() == 2020) {
            tvTitle.setTextColor(ContextCompat.getColor(parent_context, R.color.title2020));
            String strCategory = (currentItem.getYear()) + " - " + currentItem.getGenre();
            tvCategory.setText(strCategory);

            switch (currentItem.getRated()) {
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

            return rowView;
        }
        return rowView;
    }
}
