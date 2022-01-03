package com.example.jinx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
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

public class Draven extends AppCompatActivity {
    private ImageView imgS;
    private Animation animation;
    private Button btn;
    private  LinearLayout linearLayout1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draven);
        linearLayout1 = findViewById(R.id.dravenlayout);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));
        getSupportActionBar().setTitle("Draven");
        List<ac1> ac1List = new ArrayList<>();
        ac1List.add(new ac1("SPINNING AXE ","@drawable/spinning","Draven's next attack will deal bonus physical damage. This axe will ricochet off the target high up into the air. If Draven catches it, he automatically readies another Spinning Axe. Draven can have two Spinning Axes at once."));
        ac1List.add(new ac1("BLOOD RUSH","@drawable/blood_rush","Draven gains increased Movement Speed and Attack Speed. The Movement Speed bonus decreases rapidly over its duration. Catching a Spinning Axe will refresh the cooldown of Blood Rush."));
        ac1List.add(new ac1("STAND ASIDE","@drawable/stand_aside","Draven throws his axes, dealing physical damage to targets hit and knocking them aside. Targets hit are slowed."));
        ac1List.add(new ac1("WHIRLING DEATH","@drawable/whirling_death","Draven hurls two massive axes to deal physical damage to each unit struck. Whirling Death slowly reverses direction and returns to Draven after striking an enemy champion. Draven may also activate this ability while the axes are in flight to cause it to return early. Deals less damage for each unit hit and resets when the axes reverse direction. Executes enemies who have less health than Draven's number of Adoration stacks."));
imgS = findViewById(R.id.imageViewdraven);
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
                Intent intent = new Intent(Draven.this,jinx.class);
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
switch (item.getItemId()){
    case R.id.parametres:
        startActivity(new Intent(Settings.ACTION_SETTINGS));
        return true;
    case R.id.langues:
        startActivity(new Intent(Settings.ACTION_LOCALE_SETTINGS));
        return true;
    case R.id.Quitter:
        System.exit(0);

    case R.id.bgblack:
        linearLayout1.getBackground().setTint(getResources().getColor(R.color.black));
        return true;
    case R.id.bggreen:
        linearLayout1.getBackground().setTint(getResources().getColor(R.color.green));
        return true;

    default:
        return super.onOptionsItemSelected(item);

}

    }



}