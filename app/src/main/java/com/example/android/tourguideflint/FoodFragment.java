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
public class FoodFragment extends Fragment {

    // Creates keys for ListView item data
    public static final String KEY_NAME = "KEY_NAME";
    public static final String KEY_LOCATION = "KEY_LOCATION";
    public static final String KEY_DETAILS = "KEY_DETAILS";
    public static final String KEY_DRAWABLE = "KEY_DRAWABLE";
    public static final String KEY_DESCRIPTION = "KEY_DESCRIPTION";

    public FoodFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        final ArrayList<Info> info = new ArrayList<Info>();
        info.add(new Info(getContext().getString(R.string.churchills_name), getContext().getString(R.string.churchills_distance),
                getContext().getString(R.string.churchills_detail), R.drawable.churchills,
                getContext().getString(R.string.churchills_description), getContext().getString(R.string.churchills_location)));
        info.add(new Info(getContext().getString(R.string.crepe_company_name), getContext().getString(R.string.crepe_company_distance),
                getContext().getString(R.string.crepe_company_detail), R.drawable.crepes,
                getContext().getString(R.string.crepe_company_description), getContext().getString(R.string.crepe_company_location)));
        info.add(new Info(getContext().getString(R.string.white_horse_name), getContext().getString(R.string.white_horse_distance),
                getContext().getString(R.string.white_horse_detail), R.drawable.whitehorse,
                getContext().getString(R.string.white_horse_description), getContext().getString(R.string.white_horse_location)));

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
