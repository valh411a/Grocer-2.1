package com.example.grocer21;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import java.util.Objects;

public class MainActivity extends AppCompatActivity
        implements
        FoodFragment.OnListFragmentInteractionListener,
        HomeScreenFragment.OnFragmentInteractionListener,
        AllergyFragment.OnListFragmentInteractionListener,
        DietFragment.OnListFragmentInteractionListener,
        FoodItemFragment.OnFragmentInteractionListener,
        DietItemFragment.OnFragmentInteractionListener,
        AllergyItemFragment.OnFragmentInteractionListener,
        AllergyListContainer.OnFragmentInteractionListener,
        FoodListContainer.OnFragmentInteractionListener,
        DietListContainer.OnFragmentInteractionListener {

    private DrawerLayout mDrawerLayout;
    private Fragment fragment = null;
    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private boolean onTopLevelNav = true;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        Objects.requireNonNull(actionbar).setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        fragment = new HomeScreenFragment();
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
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        int id = menuItem.getItemId();

                        if (id == R.id.nav_food_list) {
                            fragment = new FoodListContainer();
                            toolbar.setTitle("Food");
                        } else if (id == R.id.nav_allergy_list) {
                            fragment = new AllergyListContainer();
                            toolbar.setTitle("Allergies");
                        } else if (id == R.id.nav_diet_list) {
                            fragment = new DietListContainer();
                            toolbar.setTitle("Diet");
                        }

                        setTitle(menuItem.getTitle());
                        mDrawerLayout.closeDrawers();
                        if (onTopLevelNav) {
                            if (fragment != null) {
                                fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).addToBackStack(null).commit();
                                onTopLevelNav = false;
                            }
                        } else {
                            fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
                        }

                        return true;
                    }
                });

        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(@NonNull View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(@NonNull View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );
    }

    public MainActivity() {
        toolbar = null;
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

        FragmentManager fragmentManager = getSupportFragmentManager();
        String name = item.getName();
        toolbar.setTitle(name);
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        FoodItemFragment foodItemFragment = new FoodItemFragment();
        foodItemFragment.setArguments(bundle);
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, foodItemFragment)
                .addToBackStack(null)
                .commit();
        onTopLevelNav = false;

    }

    public void displayHelp(View view) {
        DialogFragment newHelpFragment = new HelpDialogFragment();
        newHelpFragment.show(getSupportFragmentManager(), "HelpDialog");
    }

    @Override
    public void onListFragmentInteraction(Allergy item) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        String name = item.getName();
        toolbar.setTitle(name);
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        AllergyItemFragment allergyItemFragment = new AllergyItemFragment();
        allergyItemFragment.setArguments(bundle);
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, allergyItemFragment)
                .addToBackStack(null)
                .commit();
        onTopLevelNav = false;

    }

    @Override
    public void onListFragmentInteraction(Diet item) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        String name = item.getName();
        toolbar.setTitle(name);
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        DietItemFragment dietItemFragment = new DietItemFragment();
        dietItemFragment.setArguments(bundle);
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, dietItemFragment)
                .addToBackStack(null)
                .commit();
        onTopLevelNav = false;

    }

    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() >= 0) {
            fragment = new HomeScreenFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .addToBackStack(null)
                    .commit();
            onTopLevelNav = true;
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public void onFragmentInteraction() {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
