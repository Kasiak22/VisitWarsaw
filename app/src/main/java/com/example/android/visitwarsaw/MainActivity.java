package com.example.android.visitwarsaw;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // finding Viewpager
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter for fragments
        WarsawAdapter adapter = new WarsawAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        //finding TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        //Set TabLayout with ViewPager
        tabLayout.setupWithViewPager(viewPager);


    }


}
