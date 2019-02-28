package com.example.android.tourguideflint;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AttractionsFragment extends Fragment {

    public static final String KEY_NAME = "KEY_NAME";
    public static final String KEY_LOCATION = "KEY_LOCATION";
    public static final String KEY_DETAILS = "KEY_DETAILS";
    public static final String KEY_DESCRIPTION = "KEY_DESCRIPTION";
    public static final String KEY_DRAWABLE = "KEY_DRAWABLE";

    public AttractionsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        final ArrayList<Info> info = new ArrayList<Info>();
        info.add(new Info(getContext().getString(R.string.crossraods_village_name), getContext().getString(R.string.crossraods_village_distance),
                getContext().getString(R.string.crossraods_village_details), R.drawable.crossroads,
                getContext().getString(R.string.crossraods_village_description), getContext().getString(R.string.crossraods_village_location)));
        info.add(new Info(getContext().getString(R.string.sloan_museum_name), getContext().getString(R.string.sloan_museum_distance),
                getContext().getString(R.string.sloan_museum_detail), R.drawable.sloan,
                getContext().getString(R.string.sloan_museum_description), getContext().getString(R.string.sloan_museum_location)));
        info.add(new Info(getContext().getString(R.string.institute_of_arts_name), getContext().getString(R.string.institute_of_arts_distance),
                getContext().getString(R.string.institute_of_arts_detail), R.drawable.arts,
                getContext().getString(R.string.institute_of_arts_description), getContext().getString(R.string.institute_of_arts_location)));
        info.add(new Info(getContext().getString(R.string.planetarium_name), getContext().getString(R.string.planetarium_distance),
                getContext().getString(R.string.planetarium_detail), R.drawable.longwayplanetarium,
                getContext().getString(R.string.planetarium_description), getContext().getString(R.string.planetarium_location)));

        InfoAdapter adapter = new InfoAdapter(getActivity(), info);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Info item = info.get(position);
                Intent details = new Intent(getContext(), DetailsActivity.class);
                details.putExtra(KEY_NAME, item.getName());
                details.putExtra(KEY_LOCATION, item.getLocation());
                details.putExtra(KEY_DETAILS, item.getDetails());
                details.putExtra(KEY_DESCRIPTION, item.getDescription());
                details.putExtra(KEY_DRAWABLE, item.getImageResourceId());
                startActivity(details);
            }
        });

        return rootView;
    }
}