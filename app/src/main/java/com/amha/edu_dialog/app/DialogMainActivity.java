package com.amha.edu_dialog.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class DialogMainActivity extends Activity {

    //ViewPager that swipes between images.
    ViewPager mPager;

    //Static number of pages.
    //private static int VIEW_PAGER_PAGES = 4;

    //Page adapter populates the viewpager.
    //CustomPageAdapter pageAdapter;

    ImageFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_main);

        // Check we're using the layout version of the frame. {Not sure why.}

        if((findViewById(R.id.frame)) != null){

            Log.d("AMHA-OUT", "Check 1");

            // A fragment has already been created, no need to instantiate a new one.
            if(savedInstanceState != null){
                Log.d("AMHA-OUT", "Check 2");
                return;
            }

            //Currently not working - may not need this either.
            //fragment.newInstance("Lemon");

            Bundle args = new Bundle();
            args.putString("param1", "Default");

            fragment = new ImageFragment();
            fragment.setArguments(args);

            getFragmentManager().beginTransaction()
                    .add(R.id.frame, fragment).commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dialog_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
