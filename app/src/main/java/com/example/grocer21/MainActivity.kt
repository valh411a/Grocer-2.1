package com.example.grocer21

import android.arch.lifecycle.Observer
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.grocer21.database.entities.Allergies
import com.example.grocer21.database.entities.Diets
import com.example.grocer21.database.entities.Foods

class MainActivity : AppCompatActivity(),
        FoodListFragment.OnListFragmentInteractionListener,
        HomeScreenFragment.OnFragmentInteractionListener,
        AllergyListFragment.OnListFragmentInteractionListener,
        DietListFragment.OnListFragmentInteractionListener,
        FoodItemFragment.OnFragmentInteractionListener,
        DietItemFragment.OnFragmentInteractionListener,
        AllergyItemFragment.OnFragmentInteractionListener,
        AllergyListContainer.OnFragmentInteractionListener,
        FoodListContainer.OnFragmentInteractionListener,
        DietListContainer.OnFragmentInteractionListener,
        AddNewFood.OnSaveButtonPressedListener {


    private var mDrawerLayout: DrawerLayout? = null
    private var fragment: Fragment? = null
    private val fragmentManager = supportFragmentManager
    private var onTopLevelNav = true
    private var toolbar: Toolbar? = null
    private lateinit var databaseViewModel: ViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionbar = supportActionBar
        (actionbar)?.setDisplayHomeAsUpEnabled(true)
        actionbar!!.setHomeAsUpIndicator(R.drawable.ic_menu)

        mDrawerLayout = findViewById(R.id.drawer_layout)

        fragment = HomeScreenFragment()
        fragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment!!).commit()

        databaseViewModel = DatabaseViewModel(application)

        if (findViewById<RecyclerView>(R.id.foodRecyclerView) != null) {
            val recyclerView = findViewById<RecyclerView>(R.id.foodRecyclerView)!!
            val foodAdapter = FoodListAdapter(this)
            recyclerView.adapter = foodAdapter
            recyclerView.layoutManager = LinearLayoutManager(this)

            (databaseViewModel as DatabaseViewModel).allFoods.observe(this, Observer { foods ->
                foods?.let { foodAdapter.setFoods(it) }
            })
        }

        if (findViewById<RecyclerView>(R.id.allergyRecyclerView) != null) {
            val recyclerView = findViewById<RecyclerView>(R.id.allergyRecyclerView)!!
            val allergyAdapter = AllergyListAdapter(this)
            recyclerView.adapter = allergyAdapter
            recyclerView.layoutManager = LinearLayoutManager(this)

            (databaseViewModel as DatabaseViewModel).allAllergies.observe(this, Observer { allergies ->
                allergies?.let { allergyAdapter.setAllergies(it) }
            })
        }

        if (findViewById<RecyclerView>(R.id.dietRecyclerView) != null) {
            val recyclerView = findViewById<RecyclerView>(R.id.dietRecyclerView)!!
            val dietAdapter = DietListAdapter(this)
            recyclerView.adapter = dietAdapter
            recyclerView.layoutManager = LinearLayoutManager(this)

            (databaseViewModel as DatabaseViewModel).allDiets.observe(this, Observer { diets ->
                diets?.let { dietAdapter.setDiets(it) }
            })
        }

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->

            when (menuItem.itemId) {
                R.id.nav_food_list -> {
                    fragment = FoodListContainer()
                    toolbar!!.title = "Foods"
                }
                R.id.nav_allergy_list -> {
                    fragment = AllergyListContainer()
                    toolbar!!.title = "Allergies"
                }
                R.id.nav_diet_list -> {
                    fragment = DietListContainer()
                    toolbar!!.title = "Diet"
                }
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

    override fun onListFragmentInteraction(item: Foods) {

        val fragmentManager = supportFragmentManager
        val name = item.getName()
        toolbar!!.title = name
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

    fun displayHelp() {
        val newHelpFragment = HelpDialogFragment()
        newHelpFragment.show(supportFragmentManager, "HelpDialog")
    }

    override fun onListFragmentInteraction(item: Allergies) {

        val fragmentManager = supportFragmentManager
        val name = item.getName()
        toolbar!!.title = name
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

    override fun onListFragmentInteraction(item: Diets) {

        val fragmentManager = supportFragmentManager
        val name = item.getName()
        toolbar!!.title = name
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

    }

    override fun onClick(v: View) {
        fragment = AddNewFood()
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment!!)
                .addToBackStack(null)
                .commit()
    }

    override fun onNewFoodSaved(position: Bundle) {
        val newFood = Foods(position.getLong("upc"), position.getString("name"))
        (databaseViewModel as DatabaseViewModel).insertWrapper(newFood)
    }

    override fun onAttachFragment(fragment: Fragment) {
        if (fragment is AddNewFood) {
            fragment.setOnSaveButtonPressedListener(this)
        }
    }
}

