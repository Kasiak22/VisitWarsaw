package Fragment;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.visitwarsaw.Place;
import com.example.android.visitwarsaw.PlaceAdapter;
import com.example.android.visitwarsaw.R;

import java.util.ArrayList;

public class LeisureFragment extends Fragment {

    public LeisureFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_view, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.nl_1), getString(R.string.dl_1), R.drawable.bulwary, getString(R.string.ul_1)));
        places.add(new Place(getString(R.string.nl_2), getString(R.string.dl_2), R.drawable.beach, getString(R.string.ul_2)));
        places.add(new Place(getString(R.string.nl_3), getString(R.string.dl_3), R.drawable.harenda, getString(R.string.ul_3)));
        places.add(new Place(getString(R.string.nl_4), getString(R.string.dl_4), R.drawable.mazowiecka, getString(R.string.ul_4)));
        places.add(new Place(getString(R.string.nl_5), getString(R.string.dl_5), R.drawable.n_market, getString(R.string.ul_5)));
        places.add(new Place(getString(R.string.nl_6), getString(R.string.dl_6), R.drawable.arkadia, getString(R.string.ul_6)));

        //Creating new adapter to display the songs from ArrayList in ListView
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        ListView listView = rootView.findViewById(R.id.list);

        // Make the ListView use the  PlaceAdapter
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the object that was clicked on
                Place place = places.get(position);

                Uri placeUri = Uri.parse(place.getUrl());
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(placeUri);
                startActivity(i);
            }
        });
        return rootView;
    }
}
