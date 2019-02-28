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

public class CollegesFragment extends Fragment {

    // Creates keys for ListView item data
    public static final String KEY_NAME = "KEY_NAME";
    public static final String KEY_LOCATION = "KEY_LOCATION";
    public static final String KEY_DETAILS = "KEY_DETAILS";
    public static final String KEY_DRAWABLE = "KEY_DRAWABLE";
    public static final String KEY_DESCRIPTION = "KEY_DESCRIPTION";

    public CollegesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        final ArrayList<Info> info = new ArrayList<Info>();
        info.add(new Info(getContext().getString(R.string.kettering_name), getContext().getString(R.string.kettering_distance),
                getContext().getString(R.string.kettering_detail), R.drawable.kettering,
                getContext().getString(R.string.kettering_description), getContext().getString(R.string.kettering_location)));
        info.add(new Info(getContext().getString(R.string.um_flint_name), getContext().getString(R.string.um_flint_distance),
                getContext().getString(R.string.um_flint_detail), R.drawable.umflint,
                getContext().getString(R.string.um_flint_description), getContext().getString(R.string.um_flint_location)));
        info.add(new Info(getContext().getString(R.string.mott_cc_name), getContext().getString(R.string.mott_cc_distance),
                getContext().getString(R.string.mott_cc_detail), R.drawable.kettering,
                getContext().getString(R.string.mott_cc_description), getContext().getString(R.string.mott_cc_location)));

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
