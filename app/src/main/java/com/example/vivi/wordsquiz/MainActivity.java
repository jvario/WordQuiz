package com.example.vivi.wordsquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Point;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TEST";
    private boolean phoneDevice = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenSize = getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK;

        if (screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE ||
                screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE )
            phoneDevice = false;

        if (phoneDevice)
            setRequestedOrientation(
                    ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        Button button= (Button) findViewById(R.id.play_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PlayActivity.class);
                startActivity(i);
            }
        });

    }


    @Override
    protected void onStart(){
        super.onStart();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Words Quiz");
        setSupportActionBar(toolbar);
        Intent i=getIntent();
        Log.i(TAG, "onStart: ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Display display = ((WindowManager)
                getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        Point screenSize = new Point();
        Log.i(TAG, "onCreateOptionsMenu: ");
        display.getRealSize(screenSize);
        if (screenSize.x < screenSize.y) // x είναι το πλάτος,  y είναι το ύψος
        {
            getMenuInflater().inflate(R.menu.main_menu, menu); // διογκώνει το μενού
            return true;
        } else
            return false;

    }


    //ToolBar
    private void open(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Do you really want to exit?");
        alertDialogBuilder.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                        System.exit(0);
                    }
                });

        alertDialogBuilder.setNegativeButton("NO",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    @Override
    public boolean onSupportNavigateUp() {              //Back Button
        onBackPressed();
        return true;
    }


    private void exitdialog(){
        open();
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_menu:
                Intent a=new Intent(this,AboutActivity.class); //some code here
                startActivity(a);
                return true;
            case R.id.exit:
                exitdialog();
                return true;
            case R.id.help:
                Intent b=new Intent(this,HelpActivity.class); //some code here
                startActivity(b);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }


}
