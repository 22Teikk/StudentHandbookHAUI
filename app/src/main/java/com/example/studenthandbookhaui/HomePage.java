package com.example.studenthandbookhaui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.studenthandbookhaui.fragment.HomeFragment;
import com.example.studenthandbookhaui.fragment.ScheduleFragment;
import com.example.studenthandbookhaui.fragment.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class HomePage extends AppCompatActivity {
    private ViewPager viewPager;
    private BottomNavigationView navigationView;
    ViewPagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        getWidget();
        pageChange();
    }

    private void getWidget(){
        viewPager = findViewById(R.id.viewPager);
        navigationView = findViewById(R.id.bottom_navigation);
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(pagerAdapter);
    }

    //Chuyển đổi ViewPager(Vuốt và click)
    private void pageChange(){
        //Vuốt
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        navigationView.getMenu().findItem(R.id.schedule).setChecked(true);
                        break;
                    case 1:
                        navigationView.getMenu().findItem(R.id.home).setChecked(true);
                        break;
                    case 2:
                        navigationView.getMenu().findItem(R.id.user).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //Click
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.schedule:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.home:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.user:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }
}