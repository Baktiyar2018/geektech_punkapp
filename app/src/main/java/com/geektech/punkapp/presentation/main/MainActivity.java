package com.geektech.punkapp.presentation.main;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.geektech.punkapp.R;
import com.geektech.punkapp.data.RepositoryProvider;
import com.geektech.punkapp.data.beer.BeerDataSource;
import com.geektech.punkapp.data.beer.BeerRepository;
import com.geektech.punkapp.data.beer.model.Beer;
import com.geektech.punkapp.data.beer.remote.BeerRemoteDataSource;
import com.geektech.punkapp.presentation.beerlist.BeerListFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //TODO: Create #BeerListFragment instance and set it via #SupportFragmentManager
        if (savedInstanceState == null) {
            BeerListFragment fragment = BeerListFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_container,fragment)
                    .commit();


        }
    }
/*
    @Override
    protected void onResume() {
        super.onResume();

        RepositoryProvider
                .getBeerSource()
                .getBeer(5,new BeerDataSource.BeerCallback() {
                    @Override
                    public void onSuccess(Beer beer) {
                        Log.d("ololo", beer.getName());
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.d("ololo-error", e.getMessage());
                    }
                });
                */
/*
        RepositoryProvider
                .getBeerSource()
                .getBeerList(new BeerDataSource.BeerListCallback() {
                    @Override
                    public void onSuccess(ArrayList<Beer> beers) {
                        for(Beer beer : beers){
                            Log.d("ololo", beer.toString());
                        }
                    }

                    @Override
                    public void onError(Exception e) {
                            Log.d("ololo",e.getMessage());
                    }
                });
*/



}
