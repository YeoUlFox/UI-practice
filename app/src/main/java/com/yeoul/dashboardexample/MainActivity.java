package com.yeoul.dashboardexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        /* ----- Hooks ----- */
        drawerLayout = findViewById(R.id.drawerlayout_main);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.main_toolbar);

        /* ----- Toolbar ----- */
        setSupportActionBar(toolbar);

        /* ----- Navibation Drawer Menu ----- */
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_g1_home);

        // TODO : set this option by Keep Login Options
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_g2_profile).setVisible(false);
        menu.findItem(R.id.nav_g2_logout).setVisible(false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_g1_home:

            case R.id.nav_g1_example2:
            case R.id.nav_g1_example1:
            case R.id.nav_g1_example3:
            case R.id.nav_g2_profile:

            case R.id.nav_g2_login:


            case R.id.nav_g2_logout:
                toast_not_implemented();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

    private void toast_not_implemented() {
        Toast.makeText(this, "Not implmented", Toast.LENGTH_LONG).show();
        return;
    }
}