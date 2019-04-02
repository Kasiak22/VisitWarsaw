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

public class ExtraFragment extends Fragment {


    public ExtraFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_view, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.ne_1), getString(R.string.de_1), R.drawable.kapliczka, getString(R.string.ue_1)));
        places.add(new Place(getString(R.string.ne_2), getString(R.string.de_2), R.drawable.pole_mok, getString(R.string.ue_2)));
        places.add(new Place(getString(R.string.ne_3), getString(R.string.de_3), R.drawable.zoo, getString(R.string.ue_3)));
        places.add(new Place(getString(R.string.ne_4), getString(R.string.de_4), R.drawable.pl_zbaw, getString(R.string.ue_4)));
        places.add(new Place(getString(R.string.ne_5), getString(R.string.de_5), R.drawable.kopernik, getString(R.string.ue_5)));
        places.add(new Place(getString(R.string.ne_6), getString(R.string.de_6), R.drawable.h_gwardii, getString(R.string.ue_6)));

        //Creating new adapter to display the place from ArrayList in ListView
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        ListView listView = rootView.findViewById(R.id.list);

        // Make the ListView use the  PlaceAdapter
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the object that was clicked on
                Place place = places.get(position);
                //Intent for visiting website
                Uri placeUri = Uri.parse(place.getUrl());
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(placeUri);
                startActivity(i);
            }
        });
        return rootView;
    }


}
