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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.pokedex.R;
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



    public FragmentShowDetails(int id) {
        if (id != 0) {
            id = id;
            PokemonCalls.fetchPokemonById(this, id);
        }
    }

    public static FragmentShowDetails newInstance(int id) {
        return new FragmentShowDetails(id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter = new Presenter(this.getContext().getApplicationContext());
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
        List<Integer> idpoke = new ArrayList<>();
        idpoke = presenter.getFavoris();
        if (idpoke!= null && idpoke.contains(id)){
            starbutton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }
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
        /*starbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(starbutton.getBackground()==getResources().getDrawable(R.drawable.star_default)) {
                    presenter.addFavoris(id,p.getName(),p.getSprites().getFrontDefault());
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        starbutton.setBackground(getResources().getDrawable(R.drawable.star_fav));
                    }
                }
            }
        });*/
    }

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
        System.out.println("ici" + pokemon.getName());
        if (pokemon != null) {
            p = pokemon;
            nameText.setText(p.getName());
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
                    PokemonCalls.fetchPokemonById(thisfragment, getNext(p.getId()));
                    for (Fragment f :getActivity().getSupportFragmentManager().getFragments()){
                        if(f.getClass() != thisfragment.getClass()){
                            if (f instanceof FragmentStatAndCatch){
                                ((FragmentStatAndCatch) f).reload(p.getId());
                            }
                        }
                    }
                }
            });
            buttonPrevious.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PokemonCalls.fetchPokemonById(thisfragment, getPrevious(p.getId()));
                    for (Fragment f :getActivity().getSupportFragmentManager().getFragments()){
                        if(f.getClass() != thisfragment.getClass()){
                            if (f instanceof FragmentStatAndCatch){
                                ((FragmentStatAndCatch) f).reload(p.getId());
                            }
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
        return id == 1 ? 151 : id - 1;
    }


    public int getNext(int id) {
        return id == 151 ? 1 : id + 1;
    }

}