package com.geektech.punkapp.presentation.beerlist.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.geektech.punkapp.R;
import com.geektech.punkapp.data.beer.model.Beer;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
public class BeerListViewHolder extends RecyclerView.ViewHolder {
    private TextView mName,mDesc,mUrl;
    private ImageView imageView;
    private BeerVHClickListener mListener;
    private View mView;
    public BeerListViewHolder(@NonNull View itemView,@Nullable BeerVHClickListener listener)
    {
        super(itemView);
        mName = itemView.findViewById(R.id.txtname);
        imageView = itemView.findViewById(R.id.item_images);

        mView = itemView;
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

        RequestOptions options = new RequestOptions();
        options.circleCropTransform();

        mName.setText(beer.getName());
        Glide.with(mView)
                .load(beer.getImageUrl())
                .apply(options)
                .into(imageView);
        //beerVHClickListener.onClick(beer.getId());

    }

    public interface BeerVHClickListener {
        void onClick(int position);
    }
}
