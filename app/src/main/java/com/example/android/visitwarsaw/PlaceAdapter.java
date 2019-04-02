package com.example.android.visitwarsaw;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    public PlaceAdapter(Context context, ArrayList<Place> places) {
        super(context, 0, places);

    }
    //viewHolder based on https://www.javacodegeeks.com/2013/09/android-viewholder-pattern-example.html

    static class ViewHolderItem {
        TextView nameTx;
        TextView descriptTx;
        ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolderItem viewHolder;
        if (convertView == null) {
            // inflate the layout
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_view, parent, false);
            //set up ViewHolder
            viewHolder = new ViewHolderItem();

            viewHolder.nameTx = convertView.findViewById(R.id.name_tv);
            viewHolder.descriptTx = convertView.findViewById(R.id.descript_tv);
            viewHolder.imageView = convertView.findViewById(R.id.image);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderItem) convertView.getTag();
        }

        // Get place object for chosen position
        Place currentPlace = getItem(position);
        //set up value for textViews
        viewHolder.nameTx.setText(currentPlace.getName());
        viewHolder.descriptTx.setText(currentPlace.getDescript());

        // Checking if object has image

        if (currentPlace.hasImage()) {
            viewHolder.imageView.setImageResource(currentPlace.getImageResourceId());
            viewHolder.imageView.setVisibility(View.VISIBLE);
        } else {
            viewHolder.imageView.setVisibility(View.GONE);
        }

        return convertView;
    }


}
