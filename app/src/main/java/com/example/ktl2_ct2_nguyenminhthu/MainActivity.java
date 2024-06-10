package com.example.ktl2_ct2_nguyenminhthu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.ktl2_ct2_nguyenminhthu.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        setSupportActionBar(activityMainBinding.toolbar);
        activityMainBinding.bottomNavigationMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                int id = item.getItemId();
                if (id == R.id.navigation_home) {
                    fragment = new HomeFragment();
                }
                else if (id == R.id.navigation_world) {
                    fragment = new WorldFragment();
                } else {
                    return false;
                }
                String title = item.getTitle().toString();
                activityMainBinding.textViewFragmentTitle.setText(title);
                loadFragment(fragment);
                return true;
            }
        });
        activityMainBinding.bottomNavigationMain.setSelectedItemId(R.id.navigation_home);
        loadFragment(new HomeFragment());
    }
    public void loadFragment(Fragment fragment)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(activityMainBinding.frameFragment.getId(), fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}