package com.echitey.designcheatsheet;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    private Toolbar toolbar;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openActivity(View view) {
        intent = new Intent(this, XmlParsing.class);
        startActivity(intent);
    }

    public void openDashboard(View view) {
        intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }

    public void openProfile(View view) {
        intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void openSlider(View view) {
        intent = new Intent(this, SliderActivity.class);
        startActivity(intent);
    }

    public void openCollapse(View view) {
        intent = new Intent(this, CollapsingToolbarActivity.class);
        startActivity(intent);
    }
}
