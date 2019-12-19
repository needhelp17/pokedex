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
    private boolean is_on_fav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_detail_activity);
        Intent i = getIntent();
        id = i.getIntExtra("id",0);
        is_on_fav = i.getBooleanExtra("is_fav",false);
        setupViewPagerAndTabs();

    }

    public void displaySnackBar(String message) {
        Snackbar.make(findViewById(R.id.show_detail_activity),message,Snackbar.LENGTH_LONG)
                .show();
    }

    /**
     * launch the 2 fragments
     */
    private void setupViewPagerAndTabs() {
        final FragmentShowDetails fragmentShowDetails = new FragmentShowDetails(id,is_on_fav);
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

    }

}
