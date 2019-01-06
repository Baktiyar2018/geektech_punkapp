package com.geektech.punkapp.presentation.beerlist.recycler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.geektech.punkapp.R;
import com.geektech.punkapp.data.beer.model.Beer;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public class BeerListViewHolder extends RecyclerView.ViewHolder {
    private TextView mName,mDesc,mUrl;
    private BeerVHClickListener mListener;
    public BeerListViewHolder(@NonNull View itemView,@Nullable BeerVHClickListener listener)
    {
        super(itemView);
        mName = itemView.findViewById(R.id.txtname);
        mDesc = itemView.findViewById(R.id.txtdesc);
        mUrl = itemView.findViewById(R.id.txturl);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(getAdapterPosition());
                Log.d("ololo",Integer.toString(getAdapterPosition()));
            }
        });

    }


    void onBind(Beer beer){
        //TODO: Display beer data in views
        mName.setText(beer.getName());
        mDesc.setText(beer.getDescription());
        mUrl.setText(beer.getImageUrl());
        //beerVHClickListener.onClick(beer.getId());

    }

    public interface BeerVHClickListener {
        void onClick(int position);
    }
}
