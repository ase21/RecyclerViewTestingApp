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
    private Context context;
    private List<BeerObject> beerObjectList;
    private LayoutInflater inflater;

    BeerRecyclersAdapter(Context context, List<BeerObject> beerObjectList) {
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
        BeerObject beerObject = beerObjectList.get(position);

        viewHolder.bind(beerObject);
    }

    @Override
    public int getItemCount() {
        return beerObjectList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView beerLabelImageView;
        private TextView nameTextView;
        private TextView aboutTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            beerLabelImageView = itemView.findViewById(R.id.beer_label);
            nameTextView = itemView.findViewById(R.id.beer_name);
            aboutTextView = itemView.findViewById(R.id.about);
        }

        void bind(BeerObject beerObject){
            Picasso.get()
                    .load(beerObject
                            .getScreen())
                    .into(beerLabelImageView);
            nameTextView.setText(beerObject.getName());
            aboutTextView.setText(beerObject.getAbout());
        }
    }
}
