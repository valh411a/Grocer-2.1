package com.example.grocer21;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.grocer21.Database.Allergy;
import com.example.grocer21.Database.Diet;
import com.example.grocer21.Database.Food;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements
        FoodFragment.OnListFragmentInteractionListener,
        HomeScreenFragment.OnFragmentInteractionListener,
        AllergyFragment.OnListFragmentInteractionListener,
        DietFragment.OnListFragmentInteractionListener {

    DrawerLayout mDrawerLayout;
    Fragment fragment = null;
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;
    boolean onTopLevelNav = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        fragment = new HomeScreenFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        final DatabaseViewModel databaseViewModel = ViewModelProviders.of(this).get(DatabaseViewModel.class);

        databaseViewModel.allFoods.observe(this, new Observer<List<Food>>() {
            @Override
            public void onChanged(@Nullable List<Food> foods) {

            }
        });
        databaseViewModel.allAllergies.observe(this, new Observer<List<Allergy>>() {
            @Override
            public void onChanged(@Nullable List<Allergy> allergies) {

            }
        });
        databaseViewModel.allDiets.observe(this, new Observer<List<Diet>>() {
            @Override
            public void onChanged(@Nullable List<Diet> diets) {

            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        int id = menuItem.getItemId();

                        if (id == R.id.nav_food_list) {
                            fragment = new FoodFragment();
                        } else if (id == R.id.nav_allergy_list) {
                            fragment = new AllergyFragment();
                        } else if (id == R.id.nav_diet_list) {
                            fragment = new DietFragment();
                        }

                        setTitle(menuItem.getTitle());
                        mDrawerLayout.closeDrawers();
                        if (onTopLevelNav) {
                            if (fragment != null) {
                                fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).addToBackStack(null).commit();
                                onTopLevelNav = false;
                            }
                        } else {
                            fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
                        }

                        return true;
                    }
                });



        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListFragmentInteraction(Food item) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void displayHelp(View view) {
        DialogFragment newHelpFragment = new HelpDialogFragment();
        newHelpFragment.show(getSupportFragmentManager(), "HelpDialog");
    }

    @Override
    public void onListFragmentInteraction(Allergy item) {

    }

    @Override
    public void onListFragmentInteraction(Diet item) {

    }

    public void onBackPressed() { //or use on menu item clicked
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragment = new HomeScreenFragment();
            fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).addToBackStack(null).commit();
            onTopLevelNav = true;
        }else {
            super.onBackPressed();
        }
    }
}
