package com.wardrobe;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_SMALL || (getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_NORMAL)
        {
            setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        }

        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {

            setStartFragment(new StartFragment());
        }

        System.out.println("Hej på dig");


    }
    public void setStartFragment(Fragment fragment)
    {
        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.placeholder, fragment);
        mFragmentTransaction.commit();
    }
}
