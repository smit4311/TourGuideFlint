package com.example.android.tourguideflint;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoAdapter extends ArrayAdapter<Info> {

    public InfoAdapter(Activity context, ArrayList<Info> info) {
        super(context, 0, info);
    }

    static class ViewHolder {
        private TextView nameTextView;
        private TextView distanceTextView;
        private TextView detailsTextView;
        private ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Info currentInfo = getItem(position);

        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.nameTextView = (TextView) convertView.findViewById(R.id.name_text_view);
            holder.distanceTextView = (TextView) convertView.findViewById(R.id.distance_text_view);
            holder.detailsTextView = (TextView) convertView.findViewById(R.id.details_text_view);
            holder.imageView = (ImageView) convertView.findViewById(R.id.image_view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.nameTextView.setText(currentInfo.getName());

        holder.distanceTextView.setText(currentInfo.getDistance());

        holder.detailsTextView.setText(currentInfo.getDetails());

        holder.imageView.setImageResource(currentInfo.getImageResourceId());

        return convertView;
    }
}
