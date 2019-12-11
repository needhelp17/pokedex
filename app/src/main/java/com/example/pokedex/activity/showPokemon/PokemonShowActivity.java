package com.example.pokedex.activity.showPokemon;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.pokedex.R;
import com.example.pokedex.activity.showPokemon.fragment.FragmentStatAndCatch;
import com.example.pokedex.activity.showPokemon.fragment.FragmentShowDetails;
import com.google.android.material.snackbar.Snackbar;


public class PokemonShowActivity extends AppCompatActivity {
    private int id;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_detail_activity);
        Intent i = getIntent();
        id = i.getIntExtra("id",0);
        setupViewPagerAndTabs();

    }

    public void displaySnackBar(String message) {
        Snackbar.make(findViewById(R.id.show_detail_activity),message,Snackbar.LENGTH_LONG)
                .show();
    }

    private void setupViewPagerAndTabs() {
        final FragmentShowDetails fragmentShowDetails = new FragmentShowDetails(id);
        final FragmentStatAndCatch fragmentStatAndCatch = new FragmentStatAndCatch(id);
        viewPager = findViewById(R.id.tab_viewpager);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return (position==1) ? fragmentStatAndCatch : fragmentShowDetails;
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
                return fragmentStatAndCatch.TAB_NAME;
            }
        });


        //TODO we want two fragments with layouts : fragment_one, fragment_two.

        //TODO set adapter to viewpager and handle fragment change inside
        //viewpager.setAdapter(...);

    }

}
