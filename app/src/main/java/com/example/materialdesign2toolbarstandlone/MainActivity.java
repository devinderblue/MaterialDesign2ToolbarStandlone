package com.example.materialdesign2toolbarstandlone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showToolbarAsActionbar(View view){

        Intent intent = new Intent(this, ActionBarToolbar.class);

        startActivity(intent);
    }

    public void showStandaloneToolbar(View view){

        Intent intent = new Intent(this, StandaloneToolbar.class);
        startActivity(intent);

    }

    public void showContextualMenu(View view){

        Intent intent = new Intent(this, ContextualMenu.class);
        startActivity(intent);
    }

}
