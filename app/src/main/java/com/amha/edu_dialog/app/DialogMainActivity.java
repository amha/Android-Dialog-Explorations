package com.amha.edu_dialog.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class DialogMainActivity extends Activity {

    // Debug identifier written to the console.
    private final String TAG = "AMHA";

    // List of dialog titles that have been implemented.
    private final String[] dialog_list = {"Alert Dialog 1","Alert Dialog 2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_main);


        // TODO: Create custom layout for the list view.
        // Setting up the adapter that will populate the list view.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,                                   // The application context.
                android.R.layout.simple_list_item_1,    // Android defined layout.
                dialog_list                             // Data source.
                );


        // Retrieving the list view and setting it's
        // adapter and click handler.
        ListView mList = (ListView)findViewById(R.id.list);
        mList.setAdapter(adapter);
        mList.setOnItemClickListener(click_handler);

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

    // Respond to user click/tap.
    private AdapterView.OnItemClickListener click_handler =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(
                        AdapterView<?> parent, View view, int position, long id) {

                    if(position > -1){

                       switch(position){
                           case 0:
                               creatAlertDialog();
                               break;
                           case 1:
                               break;

                       }
                    }
                }
            };

    protected void creatAlertDialog (){

        AlertDialog.Builder mBuilder= new AlertDialog.Builder(this);
        mBuilder.setTitle("Alert Dialog")
                .setMessage("I'm an alert dialog, but don't call me an alarmist.")
                .setPositiveButton(R.string.postive_btn, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "CLICKING FROM THE DIALOG.");
                    }
                });
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }
}
