package com.example.pokedex.activity.showPokemon.fragment;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
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
import com.example.pokedex.dataRepository.Utils.NetworkAsyncTask;
import com.example.pokedex.dataRepository.Utils.PokemonCalls;
import com.example.pokedex.dataRepository.entitites.GameIndex;
import com.example.pokedex.dataRepository.entitites.Pokemon;
import com.example.pokedex.dataRepository.entitites.Type;
import com.example.pokedex.presenter.Presenter;

public class FragmentShowDetails extends Fragment implements NetworkAsyncTask.Listeners, PokemonCalls.CallbacksSimple {

    public static final String TAB_NAME = "Détail";
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

    public FragmentShowDetails(int id) {
        if(id!=0){
            PokemonCalls.fetchPokemonById(this,id);
        }
    }

    public static FragmentShowDetails newInstance(int id) {
        return new FragmentShowDetails(id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter = new Presenter();
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
        img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                changeImg(img,false);
            }
        });
        shinySwitch.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                changeImg(img,true);
            }
        });
    }

    public void changeImg(View v, Boolean is_shiny){
        System.out.println("value of front : " + front + "   value of shiny : "+shinySwitch.isChecked() +" value of is_shiny : "+is_shiny);
        String url_to_set = "";
        if (!is_shiny){
            front=!front;
        }
        if(front){
            if(shinySwitch.isChecked()){
                url_to_set = p.getSprites().getFrontShiny();
            }
            else{
                url_to_set = p.getSprites().getFrontDefault();
            }
        }
        else{
            if(shinySwitch.isChecked()){
                url_to_set = p.getSprites().getBackShiny();
            }
            else{
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
    public void onPreExecute() {

    }

    @Override
    public void doInBackground() {

    }

    @Override
    public void onPostExecute(String success) {

    }

    @Override
    public void onResponse(@Nullable Pokemon pokemon) {
        if (pokemon!=null){
            p = pokemon;
            nameText.setText(p.getName());
            idText.setText("No. "+String.valueOf(p.getId()));
            heighText.setText("Heigh : "+p.getHeight());
            weightText.setText("Weight : "+p.getWeight());
            type1Text.setText(p.getTypes().get(0).getType().getName());
            int color = presenter.getColorType(p.getTypes().get(0).getType().getName());
            type1Text.setBackgroundColor(color);
            if(p.getTypes().size()>1){
                type2Text.setText(p.getTypes().get(1).getType().getName());
                int color2 = presenter.getColorType(p.getTypes().get(1).getType().getName());
                type2Text.setBackgroundColor(color2);
                System.out.println(color2);
            }
            else {
                type2Text.setText("");
                type2Text.setVisibility(View.INVISIBLE);
            }
            String version="";
            for (GameIndex gi : p.getGameIndices()){
                version +=gi.getVersion().getName()+", ";
            }
            version = version.substring(0,version.length()-1);
            versionText.setText("Originial Version  : "+p.getGameIndices().get(p.getGameIndices().size()-1).getVersion().getName());
            changeImg(img,true);
        }
    }

    @Override
    public void onFailure() {

    }

    //TODO add listener to button and transmit the information to parent Activity
    //TODO read the Android doc, as suggested, to do it the right way
}