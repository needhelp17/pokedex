package com.example.pokedex.activity.showPokemon.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.pokedex.R;
import com.example.pokedex.dataRepository.db.PokemonViewModel;
import com.example.pokedex.dataRepository.pokemonService.pokemonCalls.PokemonCalls;
import com.example.pokedex.dataRepository.entitites.pokemon.GameIndex;
import com.example.pokedex.dataRepository.entitites.pokemon.Pokemon;
import com.example.pokedex.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;

public class FragmentShowDetails extends Fragment implements PokemonCalls.Callbacks {

    public static final String TAB_NAME = "Détail";
    private int id;
    private Presenter presenter;
    private View rootView;
    private boolean front = true;
    private ImageView img;
    private Pokemon p;
    private TextView nameText;
    private TextView idText;
    private Button type1Text;
    private Button type2Text;
    private TextView heighText;
    private TextView weightText;
    private TextView versionText;
    private Switch shinySwitch;
    private Button buttonPrevious;
    private Button buttonNext;
    private Button starbutton;
    private PokemonViewModel pokemonViewModel;
    private List<Integer> pokefavlist;
    private boolean is_fav=false;
    private TextView favoriteText;
    private FragmentStatAndCatch fragmentStatAndCatch;
    private boolean is_on_fav;


    public FragmentShowDetails(int id,boolean is_on_fav) {
        if (id != 0) {
            id = id;
            is_on_fav = is_on_fav;
            PokemonCalls.fetchPokemonById(this, id);
        }
    }

    public static FragmentShowDetails newInstance(int id,boolean is_on_fav) {
        return new FragmentShowDetails(id,is_on_fav);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter = new Presenter();
        for (Fragment f : getFragmentManager().getFragments()){
            if (f instanceof  FragmentStatAndCatch)
                fragmentStatAndCatch = (FragmentStatAndCatch)f;
        }

        pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel.class);
        rootView = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_preview, null);
        nameText = rootView.findViewById(R.id.pokemonName);
        idText = rootView.findViewById(R.id.pokemonId);
        heighText = rootView.findViewById(R.id.pokemonHeigh);
        weightText = rootView.findViewById(R.id.pokemonWeigth);
        img = rootView.findViewById(R.id.pokemonImage);
        type1Text = rootView.findViewById(R.id.buttonType1);
        type2Text = rootView.findViewById(R.id.buttonType2);
        versionText = rootView.findViewById(R.id.pokemonVersion);
        shinySwitch = rootView.findViewById(R.id.pokemonShiny);
        buttonPrevious = rootView.findViewById(R.id.buttonprevious);
        buttonNext = rootView.findViewById(R.id.buttonnext);
        starbutton = rootView.findViewById(R.id.star);
        pokefavlist = new ArrayList<>();
        favoriteText = rootView.findViewById(R.id.favoriteText);
        return rootView;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        img = rootView.findViewById(R.id.pokemonImage);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImg(img, false);
            }
        });
        shinySwitch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                changeImg(img, true);
            }
        });
    }

    /**
     * chznge the image on click
     * @param v the imageview
     * @param is_shiny the switch is on or not
     */
    public void changeImg(View v, Boolean is_shiny) {
        String url_to_set = "";
        if (!is_shiny) {
            front = !front;
        }
        if (front) {
            if (shinySwitch.isChecked()) {
                url_to_set = p.getSprites().getFrontShiny();
            } else {
                url_to_set = p.getSprites().getFrontDefault();
            }
        } else {
            if (shinySwitch.isChecked()) {
                url_to_set = p.getSprites().getBackShiny();
            } else {
                url_to_set = p.getSprites().getBackDefault();
            }
        }
        Glide.with(v)
                .load(url_to_set)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(img);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onResponse(@Nullable Pokemon pokemon) {
        if (pokemon != null) {
            p = pokemon;
            String name = p.getName().substring(0,1).toUpperCase().concat(p.getName().substring(1));
            nameText.setText(name);
            idText.setText("No. " + String.valueOf(p.getId()));
            String heigh = String.valueOf(p.getHeight());
            heigh = heigh.substring(0, heigh.length() - 1) + "," + heigh.substring(heigh.length() - 1);
            heigh = heigh.length() == 2 ? "0" + heigh : heigh;
            heighText.setText("Heigh : " + heigh + " m ");
            String weight = String.valueOf(p.getWeight());
            weight = weight.substring(0, weight.length() - 1) + "," + weight.substring(weight.length() - 1);
            weight = weight.length() == 2 ? "0" + weight : weight;
            weightText.setText("Weight : " + weight + " kg ");
            type1Text.setText(p.getTypes().get(0).getType().getName());
            int color = presenter.getColorType(p.getTypes().get(0).getType().getName());
            type1Text.setBackgroundColor(getResources().getColor(color));
            if (p.getTypes().size() > 1) {
                type2Text.setVisibility(View.VISIBLE);
                type2Text.setText(p.getTypes().get(1).getType().getName());
                int color2 = presenter.getColorType(p.getTypes().get(1).getType().getName());
                type2Text.setBackgroundColor(getResources().getColor(color2));
            } else {
                type2Text.setText("");
                type2Text.setVisibility(View.INVISIBLE);
            }
            String version = "";
            for (GameIndex gi : p.getGameIndices()) {
                version += gi.getVersion().getName() + ", ";
            }
            version = version.substring(0, version.length() - 1);
            versionText.setText("Originial Version  : " + p.getGameIndices().get(p.getGameIndices().size() - 1).getVersion().getName());
            changeImg(img, true);
            final FragmentShowDetails thisfragment = this;

            buttonNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragmentStatAndCatch.reload(getNext(p.getId()));
                    PokemonCalls.fetchPokemonById(thisfragment, getNext(p.getId()));
                }
            });
            buttonPrevious.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragmentStatAndCatch.reload(getPrevious(p.getId()));
                    PokemonCalls.fetchPokemonById(thisfragment, getPrevious(p.getId()));

                }
            });
            pokemonViewModel.getfavoris().observe(this, new Observer<List<Integer>>() {
                @Override
                public void onChanged(List<Integer> list) {
                    pokefavlist = list;
                    if (pokefavlist.contains(p.getId())){
                        is_fav =true;
                        favoriteText.setText("Remove of Favorite");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            starbutton.setBackground(getResources().getDrawable(R.drawable.favorite_fill));
                        }
                    }else{
                        is_fav =false;
                        favoriteText.setText("Add of Favorite");
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            starbutton.setBackground(getResources().getDrawable(R.drawable.favorite_default));
                        }
                    }
                }
            });
            starbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(is_fav) {
                        favoriteText.setText("Add to Favorite");
                        is_fav=false;
                        pokemonViewModel.deletePokemon(p);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            starbutton.setBackground(getResources().getDrawable(R.drawable.favorite_default));
                        }
                    }
                    else {
                        is_fav=true;
                        favoriteText.setText("Remove of Favorite");
                        pokemonViewModel.insert(p);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            starbutton.setBackground(getResources().getDrawable(R.drawable.favorite_fill));
                        }
                    }
                }
            });

        }
    }

    @Override
    public void onFailure() {
    }

    public int getPrevious(int id) {
        if(!is_on_fav) {
            return id == 1 ? 151 : id - 1;
        }else{
            if(pokefavlist.size()!=0){
                for (int i = 0; i< pokefavlist.size();i++){
                    if(pokefavlist.get(i)==p.getId()){
                        return pokefavlist.get(i==0?pokefavlist.size()-1:i-1);
                    }
                }
            }
            return id;
        }
    }


    public int getNext(int id) {
        if(!is_on_fav) {
            return id == 151 ? 1 : id + 1;
        }else{
            if(pokefavlist.size()!=0){
                for (int i = 0; i< pokefavlist.size();i++){
                    if(pokefavlist.get(i)==p.getId()){
                        return pokefavlist.get(i==pokefavlist.size()-1?0:i+1);
                    }
                }
            }
            return id;
        }

    }


}