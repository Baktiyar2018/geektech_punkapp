package com.geektech.punkapp.presentation.beerdetails;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geektech.punkapp.R;
import com.geektech.punkapp.data.RepositoryProvider;
import com.geektech.punkapp.data.beer.BeerDataSource;
import com.geektech.punkapp.data.beer.model.Beer;

/**
 * Created by askar on 12/15/18
 * with Android Studio
 */
//TODO: All setup is in your hands
public class BeerDetailsFragment extends Fragment {
    private TextView mName,mDesc,mUrl;
    public  static BeerDetailsFragment newInstance(){
        return new BeerDetailsFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView = inflater.from(getContext())
                .inflate(R.layout.fragment_beer_details,container,false);

        BeerDetailsActivity DetailsActivity = (BeerDetailsActivity)getActivity();
        Integer mId = DetailsActivity.getBeerId();
        mName = rootView.findViewById(R.id.txtnamed);
        mDesc = rootView.findViewById(R.id.txtdescd);
        mUrl = rootView.findViewById(R.id.txturld);
        loadBeer(mId,rootView);

        return rootView;
    }



    private void loadBeer(int id,View view){
        RepositoryProvider.getBeerSource().getBeer(id, new BeerDataSource.BeerCallback() {
            @Override
            public void onSuccess(Beer beer) {
                mName.setText(beer.getName());
                mDesc.setText(beer.getDescription());
                mUrl.setText(beer.getImageUrl());

            }

            @Override
            public void onError(Exception e) {

            }
        });

    }




}
