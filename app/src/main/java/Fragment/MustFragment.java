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


public class MustFragment extends Fragment {


    public MustFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_view, container, false);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.n_1), getString(R.string.d_1), R.drawable.zam_kr, getString(R.string.u_1)));
        places.add(new Place(getString(R.string.n_2), getString(R.string.d_2), R.drawable.lazienki, getString(R.string.u_2)));
        places.add(new Place(getString(R.string.n_3), getString(R.string.d_3), R.drawable.pkin, getString(R.string.u_3)));
        places.add(new Place(getString(R.string.n_4), getString(R.string.d_4), R.drawable.palac_w, getString(R.string.u_4)));
        places.add(new Place(getString(R.string.n_5), getString(R.string.d_5), R.drawable.old_town, getString(R.string.u_5)));
        places.add(new Place(getString(R.string.n_6), getString(R.string.d_6), R.drawable.muprising, getString(R.string.u_6)));
        //Creating new adapter to display the songs from ArrayList in ListView

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        ListView listView = rootView.findViewById(R.id.list);

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
