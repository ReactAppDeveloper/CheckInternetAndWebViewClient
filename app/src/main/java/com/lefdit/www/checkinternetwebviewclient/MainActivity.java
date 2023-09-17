package com.lefdit.www.checkinternetwebviewclient;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!isNetworkAvailable()){
            //Create an alertdialog
            AlertDialog.Builder Checkbuilder=new  AlertDialog.Builder(MainActivity.this);
            Checkbuilder.setIcon(R.drawable.error);
            Checkbuilder.setTitle("Error!");
            Checkbuilder.setMessage("Check Your Internet Connection.");
            //Builder Retry Button

            Checkbuilder.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    //Restart The Activity
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);

                }
            });

           Checkbuilder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                   finish();
               }
           }) ;

            AlertDialog alert=Checkbuilder.create();
            alert.show();

        }



 else {
            if (isNetworkAvailable()){

                Thread tr=new Thread(){
                    public  void  run(){
                        try {
                            sleep(4500);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                        finally {
                            startActivity(new Intent(MainActivity.this,Website.class));
                            finish();
                        }
                    }
                };
                tr.start();

            }
        }

    }



    private boolean isNetworkAvailable(){
        ConnectivityManager connectivityManager=(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo=connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo !=null;
    }
}
