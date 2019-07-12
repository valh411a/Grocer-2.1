package com.example.grocer21

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import com.example.grocer21.database.Allergy
import com.example.grocer21.database.Diet
import com.example.grocer21.database.Food
import java.util.*

class MainActivity : AppCompatActivity(), FoodFragment.OnListFragmentInteractionListener, HomeScreenFragment.OnFragmentInteractionListener, AllergyFragment.OnListFragmentInteractionListener, DietFragment.OnListFragmentInteractionListener, FoodItemFragment.OnFragmentInteractionListener, DietItemFragment.OnFragmentInteractionListener, AllergyItemFragment.OnFragmentInteractionListener, AllergyListContainer.OnFragmentInteractionListener, FoodListContainer.OnFragmentInteractionListener, DietListContainer.OnFragmentInteractionListener {

    private var mDrawerLayout: DrawerLayout? = null
    private var fragment: Fragment? = null
    private val fragmentManager = supportFragmentManager
    private var onTopLevelNav = true
    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionbar = supportActionBar
        Objects.requireNonNull(actionbar).setDisplayHomeAsUpEnabled(true)
        actionbar!!.setHomeAsUpIndicator(R.drawable.ic_menu)

        mDrawerLayout = findViewById(R.id.drawer_layout)

        fragment = HomeScreenFragment()
        fragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment!!).commit()

        val databaseViewModel = ViewModelProviders.of(this).get(DatabaseViewModel::class.java!!)
        databaseViewModel.allFoods.observe(this, object : Observer<List<Food>> {
            override fun onChanged(t: List<Food>?) {
                foods: List<Food>?
            }

            override fun onChanged(foods: List<Food>?) {

            }
        })
        databaseViewModel.allAllergies.observe(this, object : Observer<List<Allergy>> {
            override fun onChanged(allergies: List<Allergy>?) {

            }
        })
        databaseViewModel.allDiets.observe(this, object : Observer<List<Diet>> {
            override fun onChanged(diets: List<Diet>?) {

            }
        })

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            val id = menuItem.itemId

            if (id == R.id.nav_food_list) {
                fragment = FoodListContainer()
                toolbar!!.title = "Foods"
            } else if (id == R.id.nav_allergy_list) {
                fragment = AllergyListContainer()
                toolbar!!.title = "Allergies"
            } else if (id == R.id.nav_diet_list) {
                fragment = DietListContainer()
                toolbar!!.title = "Diet"
            }

            title = menuItem.title
            mDrawerLayout!!.closeDrawers()
            if (onTopLevelNav) {
                if (fragment != null) {
                    fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment!!).addToBackStack(null).commit()
                    onTopLevelNav = false
                }
            } else {
                fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment!!).commit()
            }

            true
        }

        mDrawerLayout!!.addDrawerListener(
                object : DrawerLayout.DrawerListener {
                    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                        // Respond when the drawer's position changes
                    }

                    override fun onDrawerOpened(drawerView: View) {
                        // Respond when the drawer is opened
                    }

                    override fun onDrawerClosed(drawerView: View) {
                        // Respond when the drawer is closed
                    }

                    override fun onDrawerStateChanged(newState: Int) {
                        // Respond when the drawer motion state changes
                    }
                }
        )
    }

    init {
        toolbar = null
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                mDrawerLayout!!.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onListFragmentInteraction(item: Food) {

        val fragmentManager = supportFragmentManager
        val name = item.getName()
        toolbar!!.setTitle(name)
        val bundle = Bundle()
        bundle.putString("name", name)
        val foodItemFragment = FoodItemFragment()
        foodItemFragment.arguments = bundle
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, foodItemFragment)
                .addToBackStack(null)
                .commit()
        onTopLevelNav = false

    }

    fun displayHelp(view: View) {
        val newHelpFragment = HelpDialogFragment()
        newHelpFragment.show(supportFragmentManager, "HelpDialog")
    }

    override fun onListFragmentInteraction(item: Allergy) {

        val fragmentManager = supportFragmentManager
        val name = item.getName()
        toolbar!!.setTitle(name)
        val bundle = Bundle()
        bundle.putString("name", name)
        val allergyItemFragment = AllergyItemFragment()
        allergyItemFragment.arguments = bundle
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, allergyItemFragment)
                .addToBackStack(null)
                .commit()
        onTopLevelNav = false

    }

    override fun onListFragmentInteraction(item: Diet) {

        val fragmentManager = supportFragmentManager
        val name = item.getName()
        toolbar!!.setTitle(name)
        val bundle = Bundle()
        bundle.putString("name", name)
        val dietItemFragment = DietItemFragment()
        dietItemFragment.arguments = bundle
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, dietItemFragment)
                .addToBackStack(null)
                .commit()
        onTopLevelNav = false

    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        if (fragmentManager.backStackEntryCount >= 0) {
            fragment = HomeScreenFragment()
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment!!)
                    .addToBackStack(null)
                    .commit()
            onTopLevelNav = true
        } else {
            super.onBackPressed()
        }
    }

    override fun onFragmentInteraction() {

    }

    override fun onFragmentInteraction(uri: Uri) {
        val fragmentManager = supportFragmentManager
        val anfFragment = AddNewFood()
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, anfFragment)
                .addToBackStack(null)
                .commit()
    }

    override fun onClick(v: View) {

    }
}
