package com.example.materialdesign2toolbarstandlone;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class StandaloneToolbar extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        //----------------------------------------------------

        Toolbar mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle("Standalone Toolbar !");
        mToolbar.setSubtitle("by Smartherd !");
        mToolbar.setNavigationIcon(R.drawable.navigation_back);

       // mToolbar.setElevation(10f);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            mToolbar.setElevation(10f);
        }

        //---------------------------------------------------------------------

        // code for Menu item inflation
        mToolbar.inflateMenu(R.menu.menu_main);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                //for any item clicked
                String title1 = (String) item.getTitle();
                Toast.makeText(StandaloneToolbar.this,title1 + " Selected !",Toast.LENGTH_SHORT).show();

                //Perform the individual Action as per selected
                //we write action command for all , but only that work which is selected that how switch is used
                switch (item.getItemId()){

                    case R.id.save:
                        // Perform the individual Action as per selected
                        break;

                    case R.id.mail:
                        //Perform some Actions
                        break;
                }

                return true;
            }
        });

        //----------------------------------------------------------------------
    }
}
