package com.example.pokedex.activity.showPokemon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.pokedex.R;
import com.example.pokedex.activity.showPokemon.fragment.FragmentItemHeld;
import com.example.pokedex.activity.showPokemon.fragment.FragmentShowDetails;
import com.example.pokedex.dataRepository.Utils.NetworkAsyncTask;
import com.example.pokedex.dataRepository.Utils.PokemonCalls;
import com.example.pokedex.entitites.Pokemon;
import com.google.android.material.snackbar.Snackbar;


public class PokemonShowActivity extends AppCompatActivity {
    private int id;
    private String name;
    private ViewPager viewPager;
    private Pokemon p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_detail_activity);
        Intent i = getIntent();
        id = i.getIntExtra("id",0);
        name = i.getStringExtra("name");
        setupViewPagerAndTabs();

    }


    public void displaySnackBar(String message) {
        Snackbar.make(findViewById(R.id.fragment_preview),message,Snackbar.LENGTH_LONG)
                .show();
    }

    private void setupViewPagerAndTabs() {
        final FragmentShowDetails fragmentShowDetails = new FragmentShowDetails(id);
        final FragmentItemHeld fragmentItemHeld = new FragmentItemHeld(id);
        viewPager = findViewById(R.id.tab_viewpager);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return (position==1) ? fragmentItemHeld : fragmentShowDetails;
            }


            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                if (position == 0) {
                    return fragmentShowDetails.TAB_NAME;
                }
                return fragmentItemHeld.TAB_NAME;
            }
        });


        //TODO we want two fragments with layouts : fragment_one, fragment_two.

        //TODO set adapter to viewpager and handle fragment change inside
        //viewpager.setAdapter(...);

    }
}
