package com.example.materialdesign2toolbarstandlone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContextualMenu extends AppCompatActivity {


    Button button;

    //5 for implementation of contextual menu in our toolbar we first need to define an actionMOde
    ActionMode actionMode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1
        setContentView(R.layout.contextual_menu);
        //2
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("StandaloneContextual Toolbar");
        mToolbar.setSubtitle("by Smartherd !");
        //3
        button = (Button) findViewById(R.id.button);
        mToolbar.inflateMenu(R.menu.menu_main);
        //4
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                String title = (String) item.getTitle(); //here show how to get title directly

                Toast.makeText(ContextualMenu.this,title + " Selected !",Toast.LENGTH_SHORT).show();

                //Perform function as per item selected
                switch (item.getItemId()){

                    case R.id.save:
                        //Perform the save action
                        break;

                    case R.id.mail:
                        //perfrom mail action
                        break;
                }


                return true;
            }
        });

        //6  code for setting contextual menu when our new button is presed/click
        // se we can call this other way also like on long press any thing conext menu come up
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //7 goto menu>make new contextual_menu.xml
                //8
                //when button is clicked the action mode we define above is assigned a value
                //when button is clicked then action mode is initialized
                //10                                        calling function we define in last
                actionMode = ContextualMenu.this.startActionMode(new ContextualCallback());


            }
        });
    }

    //9
    class ContextualCallback implements ActionMode.Callback{

        //9b implement all methods

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {

            //9c when action mode is call in line 10 then this method is
            // is called first and it will inflate new menu
            actionMode.getMenuInflater().inflate(R.menu.contextual_menu,menu);

            return true;
        }

        //9d after inflation we come here
        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {

            //9e
            actionMode.setTitle("My Action Mode");
            actionMode.setSubtitle("By Smartherd");
            return false;
        }

        //9f this is called when we clicked item on contextual toolbar
        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem item) {

            //9g  we use switch to apply action as per item clicked
            //switch code

            return false;
        }

        //9h  this is called when contextual toolbar/menu is shut down
        //                  that is when we clicked the back button
        //                  or we unselect the selected item due to which contextual toolbar/menu inflated
        //                  or when action mode is completed
        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

        }
    }

}
