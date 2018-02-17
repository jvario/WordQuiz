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



public class ChoiceActivity extends AppCompatActivity {
    private static final String TAG = "TEST";
    private boolean phoneDevice = true;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);
        Log.i(TAG, "onCreate: ");


        int screenSize = getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK;

        if (screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE ||
                screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE )
            phoneDevice = false;

        if (phoneDevice)
            setRequestedOrientation(
                    ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);












                final Button easy_button= (Button) findViewById(R.id.easy_btn);
                Log.i(TAG, "onCreate: ");
                easy_button.setOnClickListener(new View.OnClickListener(){
                    public void  onClick(View V) {
                        Intent i = new Intent(getApplicationContext(),PlayActivity.class);
                        String mystring= "easy";
                        i.putExtra("key",mystring);
                        startActivity(i);
                        Log.i(TAG, "onClick: ");
                    }
                });
                final Button med_button= (Button) findViewById(R.id.medium_btn);
                Log.i(TAG, "onCreate: ");
                med_button.setOnClickListener(new View.OnClickListener(){
                    public void  onClick(View V) {
                        Intent i = new Intent(getApplicationContext(),PlayActivity.class);
                        String mystring= "medium";
                        i.putExtra("key",mystring);
                        startActivity(i);
                        Log.i(TAG, "onClick: "); }
                });



                final Button hard_button= (Button) findViewById(R.id.hard_btn);
                Log.i(TAG, "onCreate: ");
                hard_button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View V) {
                        Intent i = new Intent(getApplicationContext(), PlayActivity.class);
                        String mystring = "hard";
                        i.putExtra("key", mystring);
                        startActivity(i);
                        Log.i(TAG, "onClick: ");
                    }
                });


    }











                @Override
                protected void onStart() {
                    super.onStart();

                    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                    toolbar.setTitle("Quiz Μαθηματικών");
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



                private void open(){
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                    alertDialogBuilder.setMessage(R.string.Qalert);
                    alertDialogBuilder.setPositiveButton(R.string.YesAlert,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    finish();
                                    System.exit(0);
                                }
                            });

                    alertDialogBuilder.setNegativeButton(R.string.NoAlert,new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }

                private void exitdialog(){
                    open();
                }


                public boolean onOptionsItemSelected(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.help:
                            return true;
                        case R.id.about_menu:
                            Log.i(TAG, "onOptionsItemSelected: ");
                            Intent h=new Intent(this,AboutActivity.class);
                            startActivity(h);
                            return true;
                        case R.id.exit:
                            exitdialog();
                            return true;




                        default:
                            return super.onOptionsItemSelected(item);


                    }
                }

            }