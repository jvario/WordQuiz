package com.example.vivi.wordsquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {
    private static final String TAG = "TEST";
    private boolean phoneDevice = true;
    private Animation shakeAnimation;
    private TextView questionNumberTextView,wordTxtView,Write_EditText;
    private Button check_btn;
    private static int counter = 1;
    private static int tries=0;
    static int j=0,l=0,m=0;

    private Handler handler;
    private String [] easy_words= {"dog","cat","ball","bee","life","apple","queen","doll","pig","zebra"};
    private String [] med_words= {"dolphin","octapus","jelly","umbrella","giraffe","ice-cream","snake","xylophone","vase","kite"};
    private String [] hard_words= {"manager","football","glory","saviour","crossword","application","android","custom","create","android"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);  //syndesh kwdika me antistoixo activity
        loadActivity();


    }


    private  void loadActivity() {
        wordTxtView = (TextView) findViewById(R.id.wordTxtView);  //syndesh user interface me kwdika
        questionNumberTextView = (TextView) findViewById(R.id.questionNumberTextView);
        Write_EditText = (EditText) findViewById(R.id.Write_EditText);
        check_btn = (Button) findViewById(R.id.check_btn);
        handler = new Handler();
        Random r = new Random();


        shakeAnimation = AnimationUtils.loadAnimation(this,
                R.anim.incorrect_shake);
        shakeAnimation.setRepeatCount(3);
        Log.i(TAG, "onCreate: ");


        questionNumberTextView.setText("Ερώτηση 1 από 10");
        Intent i = getIntent();
        final String q_number = i.getStringExtra("number");
        final String level = i.getStringExtra("key");
        if (counter > 1) {

            questionNumberTextView.setText(q_number);
        }

switch(level) {

    case "easy":

        String word = shuffle(r, easy_words[j]);
        wordTxtView.setText(word);
        break;
    case "medium":
        word = shuffle(r, med_words[l]);
        wordTxtView.setText(word);
        break;
    case "hard":
        word = shuffle(r, hard_words[m]);
        wordTxtView.setText(word);
        break;
}


        if (Write_EditText.getText().toString().trim().length() == 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "Empty Space!!!", Toast.LENGTH_SHORT);
            Log.i(TAG, "loadActivity: ");
        }


        check_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String answer = Write_EditText.getText().toString();


                switch (level) {

                    case "easy":


                        if (easy_words[j].equals(answer)) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Μπράβο!!!", Toast.LENGTH_SHORT);
                            toast.show();
                            handler.postDelayed(
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            loadnext();

                                        }
                                    }, 1000);
                            Log.i(TAG, "onClick: ");
                            break;

                        } else if (Write_EditText.getText().toString().length() == 0) {
                            Write_EditText.setError("Required");
                            break;
                        } else {
                            check_btn.startAnimation(shakeAnimation);
                            Toast toast = Toast.makeText(getApplicationContext(), "Προσπάθησε ξανά", Toast.LENGTH_SHORT);
                            toast.show();
                            tries++;
                            Intent i = new Intent(getApplicationContext(), PlayActivity.class);
                            i.putExtra("tries", tries);
                            Log.i(TAG, "onClick: ");
                            break;

                        }

                    case "medium":


                        if (med_words[l].equals(answer)) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Μπράβο!!!", Toast.LENGTH_SHORT);
                            toast.show();
                            handler.postDelayed(
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            loadnext();

                                        }
                                    }, 1000);
                            Log.i(TAG, "onClick: ");
                            break;

                        } else if (Write_EditText.getText().toString().length() == 0) {
                            Write_EditText.setError("Required");
                            break;
                        } else {
                            check_btn.startAnimation(shakeAnimation);
                            Toast toast = Toast.makeText(getApplicationContext(), "Προσπάθησε ξανά", Toast.LENGTH_SHORT);
                            toast.show();
                            tries++;
                            Intent i = new Intent(getApplicationContext(), PlayActivity.class);
                            i.putExtra("tries", tries);
                            Log.i(TAG, "onClick: ");
                            break;

                        }

                    case "hard":


                        if (hard_words[m].equals(answer)) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Μπράβο!!!", Toast.LENGTH_SHORT);
                            toast.show();
                            handler.postDelayed(
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            loadnext();

                                        }
                                    }, 1000);
                            Log.i(TAG, "onClick: ");
                            break;

                        } else if (Write_EditText.getText().toString().length() == 0) {
                            Write_EditText.setError("Required");
                            break;
                        } else {
                            check_btn.startAnimation(shakeAnimation);
                            Toast toast = Toast.makeText(getApplicationContext(), "Προσπάθησε ξανά", Toast.LENGTH_SHORT);
                            toast.show();
                            tries++;
                            Intent i = new Intent(getApplicationContext(), PlayActivity.class);
                            i.putExtra("tries", tries);
                            Log.i(TAG, "onClick: ");
                            break;

                        }


                }

            }

                });




        int screenSize = getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK;

        if (screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE ||
                screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE )
            phoneDevice = false;

        if (phoneDevice)
            setRequestedOrientation(
                    ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        else {
            Toast toast = Toast.makeText(getApplicationContext(), "Γίνετε Επανεκκίνηση του quiz...", Toast.LENGTH_SHORT);
            toast.show();
            loadActivity();
        }

    }







    public static String shuffle(Random random, String inputString )
    {
        // Convert your string into a simple char array:
        char a[] = inputString.toCharArray();

        // Scramble the letters using the standard Fisher-Yates shuffle,
        for( int i=0 ; i<a.length ; i++ )
        {
            int j = random.nextInt(a.length);
            // Swap letters
            char temp = a[i]; a[i] = a[j];  a[j] = temp;
        }

        return new String( a );
    }


        @Override
        protected void onStart () {
            super.onStart();

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("Play");
            setSupportActionBar(toolbar);
            Intent i = getIntent();
            Log.i(TAG, "onStart: ");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        @Override
        public boolean onCreateOptionsMenu (Menu menu){
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


    private void loadnext() {
        if (counter < 10) {

            counter++;
            String a = "Ερώτηση " + counter + " από 10";
            Intent i = new Intent(getApplicationContext(), PlayActivity.class);
            Random r = new Random();
            Intent k = new Intent(getApplicationContext(), ChoiceActivity.class);
            k = getIntent();
            final String level = k.getStringExtra("key");

            switch(level) {

                case "easy":

                    j++;
                    break;
                case "medium":
                    l++;
                    break;
                case "hard":
                    m++;
                    break;
            }


            i.putExtra("key", level);
            i.putExtra("number", a);
            startActivity(i);
        }
         else {

            Intent i = new Intent(getApplicationContext(), PlayActivity.class);
            DecimalFormat df= new DecimalFormat("##.#");
            DecimalFormat df2= new DecimalFormat("###");
            float tries2  = i.getIntExtra("tries",tries);
            int qs=10;
            int perc=100;
            float percentage = (qs/(tries2+qs))*perc;
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Ανεπιτυχείς προσπάθειες: "+df2.format(tries2)+ ", Ποσοστό Επιτυχίας: " +df.format(percentage)+"%");
            alertDialogBuilder.setPositiveButton("Αρχική σελίδα",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            counter=1;
                            j=0;
                            l=0;
                            m=0;
                            Intent a = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(a);

                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }
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
