package de.hackathon.adidas.adidasproject;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.choice_pager);
        PagerAdapter pagerAdapter = new TabsPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(4);

        TabLayout tabLayout = findViewById(R.id.choice_layout);
        tabLayout.setTabTextColors(
                getResources().getColor(R.color.white),
                getResources().getColor(R.color.white));
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorAccent));
        tabLayout.setupWithViewPager(viewPager);
    }

}