package com.asefactory.ase21.recyclerviewtestingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asefactory.ase21.recyclerviewtestingapp.pojo.BeerObject;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BeerRecyclersAdapter extends RecyclerView.Adapter<BeerRecyclersAdapter.ViewHolder> {
    Context context;
    List<BeerObject> beerObjectList = new ArrayList<>();
    LayoutInflater inflater;

    public BeerRecyclersAdapter(Context context, List<BeerObject> beerObjectList) {
        this.context = context;
        this.beerObjectList = beerObjectList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new ViewHolder(inflater.inflate(R.layout.item_beer, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        BeerObject beer = beerObjectList.get(position);

        Picasso.get().load(beer.getScreen()).into(viewHolder.beerLabelImageView);
        viewHolder.nameTextView.setText(beer.getName());
        viewHolder.aboutTextView.setText(beer.getAbout());
    }

    @Override
    public int getItemCount() {
        return beerObjectList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView beerLabelImageView;
        TextView nameTextView;
        TextView aboutTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            beerLabelImageView = itemView.findViewById(R.id.beer_label);
            nameTextView = itemView.findViewById(R.id.beer_name);
            aboutTextView = itemView.findViewById(R.id.about);
        }
    }
}
