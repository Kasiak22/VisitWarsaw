package Fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.android.visitwarsaw.Place;
import com.example.android.visitwarsaw.PlaceAdapter;
import com.example.android.visitwarsaw.R;

import java.util.ArrayList;

public class MuseumFragment extends Fragment {


    public MuseumFragment() {
           }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_view, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.nm_1), getString(R.string.dm_1), R.drawable.mchopin, getString(R.string.um_1)));
        places.add(new Place(getString(R.string.nm_2), getString(R.string.dm_2), R.drawable.national, getString(R.string.um_2)));
        places.add(new Place(getString(R.string.nm_3), getString(R.string.dm_3), R.drawable.jews, getString(R.string.um_3)));
        places.add(new Place(getString(R.string.nm_4), getString(R.string.dm_4), R.drawable.warsaw, getString(R.string.um_4)));
        places.add(new Place(getString(R.string.nm_5), getString(R.string.dm_5), R.drawable.photoplasticon, getString(R.string.um_5)));
        places.add(new Place(getString(R.string.nm_6), getString(R.string.dm_6), R.drawable.neon, getString(R.string.um_6)));
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
