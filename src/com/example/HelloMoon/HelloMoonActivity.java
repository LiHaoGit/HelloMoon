package com.example.HelloMoon;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class HelloMoonActivity extends FragmentActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hellomoon_activity);

        FragmentManager fm= getSupportFragmentManager();
        Fragment fragment=fm.findFragmentById(R.id.helloMoonFragment);

        if (fragment==null){
            fragment=new HelloMoonFragment();
            fm.beginTransaction().add(R.id.helloMoonFragment,fragment).commit();
        }


    }
}
