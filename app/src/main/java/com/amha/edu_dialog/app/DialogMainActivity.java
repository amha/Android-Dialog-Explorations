package com.amha.edu_dialog.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class DialogMainActivity extends Activity {

    // Debug identifier written to the console.
    private final String TAG = "AMHA";

    // List of dialog titles that have been implemented.
    private final String[] dialog_list = {"Default","Fancy"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_main);

        // Setting up the adapter that will populate the list view.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,                                   // The application context.
                android.R.layout.simple_list_item_1,    // Android defined layout.
                dialog_list                             // Data source.
                );


        // Retrieving the list view and setting it's adapter.
        ListView mList = (ListView)findViewById(R.id.list);
        mList.setAdapter(adapter);


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
