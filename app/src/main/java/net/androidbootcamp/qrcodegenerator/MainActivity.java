package net.androidbootcamp.qrcodegenerator;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import net.androidbootcamp.qrcodegenerator.ui.main.PageAdapter;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager; // viewpager is for swiping between pages (tabs)
    private TabLayout tabLayout;
    private PageAdapter pageAdapter; // page adapter will show fragment based on which tab its on

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);

        // adds tabs to tablayout and sets their names to be displayed on tab
        tabLayout.addTab(tabLayout.newTab().setText("Line1"));
        tabLayout.addTab(tabLayout.newTab().setText("Line2"));
        tabLayout.addTab(tabLayout.newTab().setText("Line3"));
        tabLayout.addTab(tabLayout.newTab().setText("Line4"));
        tabLayout.addTab(tabLayout.newTab().setText("Line5"));
        tabLayout.addTab(tabLayout.newTab().setText("Line6"));
        tabLayout.addTab(tabLayout.newTab().setText("Line7"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);




        viewPager = findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(7); // keeps the already entered data on each page instead of disappearing when switching pages


        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




    }


}