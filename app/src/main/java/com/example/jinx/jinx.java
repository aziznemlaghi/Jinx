package com.example.jinx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class jinx extends AppCompatActivity {
    private ImageView imgS;
    private Animation animation;
    private Button btn;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jinx);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));
        linearLayout = findViewById(R.id.jinxlayout);
        List<ac1> ac1List = new ArrayList<>();
        ac1List.add(new ac1("SWITCHEROO!","@drawable/pow_pow","Jinx modifies her basic attacks by swapping between Pow-Pow, her minigun and Fishbones, her rocket launcher"));
        ac1List.add(new ac1("ZAP!","@drawable/zap_21","Jinx uses Zapper, her shock pistol, to fire a blast that deals damage to the first enemy hit, slowing and revealing it."));
        ac1List.add(new ac1("FLAME CHOMPERS!","@drawable/flame","Jinx throws out a line of snare grenades that explode after 5 seconds, lighting enemies on fire. "));
        ac1List.add(new ac1("SUPER MEGA DEATH ROCKET!","@drawable/rocket","Jinx fires a super rocket across the map that gains damage as it travels. The rocket will explode upon colliding with an enemy champion, dealing damage to it and surrounding enemies based on their missing Health."));
        imgS = findViewById(R.id.imageViewjinx);
        imgS.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotation);
                                        imgS.startAnimation(animation);
                                    }
                                }

        );
        ListView listview1 = findViewById(R.id.listview);
        listview1.setAdapter(new adapter(this,ac1List));
        btn =findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(jinx.this, Draven.class);
                startActivity(intent);
            }
        });




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.parametres:
                startActivity(new Intent(Settings.ACTION_SETTINGS));
                return true;
            case R.id.langues:
                startActivity(new Intent(Settings.ACTION_LOCALE_SETTINGS));
                return true;
            case R.id.Quitter:
                System.exit(0);

            case R.id.bgblack:
                linearLayout.getBackground().setTint(getResources().getColor(R.color.black));
                return true;
            case R.id.bggreen:
                linearLayout.getBackground().setTint(getResources().getColor(R.color.green));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}