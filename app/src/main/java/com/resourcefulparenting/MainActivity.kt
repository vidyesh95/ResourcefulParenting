package com.resourcefulparenting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.resourcefulparenting.databinding.ActivityMainBinding
import com.resourcefulparenting.ui.account.AccountFragment
import com.resourcefulparenting.ui.activity.ActivityFragment
import com.resourcefulparenting.ui.explore.ExploreFragment
import com.resourcefulparenting.ui.home.HomeFragment

private const val TAG_HOME_FRAGMENT = "TAG_HOME_FRAGMENT"
private const val TAG_EXPLORE_FRAGMENT = "TAG_EXPLORE_FRAGMENT"
private const val TAG_ACTIVITY_FRAGMENT = "TAG_ACTIVITY_FRAGMENT"
private const val TAG_ACCOUNT_FRAGMENT = "TAG_ACCOUNT_FRAGMENT"

private const val KEY_SELECTED_INDEX = "KEY_SELECTED_INDEX"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var homeFragment: HomeFragment
    private lateinit var exploreFragment: ExploreFragment
    private lateinit var activityFragment: ActivityFragment
    private lateinit var accountFragment: AccountFragment

    private val fragments: Array<Fragment>
        get() = arrayOf(
            homeFragment,
            exploreFragment,
            activityFragment,
            accountFragment
        )

    private var selectedIndex = 0

    private val selectedFragment get() = fragments[selectedIndex]

    private fun selectFragment(selectedFragment: Fragment) {

        var transaction = supportFragmentManager.beginTransaction()

        fragments.forEachIndexed { index, fragment ->
            if (selectedFragment == fragment) {
                transaction = transaction.attach(fragment)
                selectedIndex = index
            } else {
                transaction = transaction.detach(fragment)
            }
        }
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_ResourcefulParenting)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (savedInstanceState == null) {
            homeFragment = HomeFragment()
            exploreFragment = ExploreFragment()
            activityFragment = ActivityFragment()
            accountFragment = AccountFragment()

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, homeFragment, TAG_HOME_FRAGMENT)
                .add(R.id.fragment_container, exploreFragment, TAG_EXPLORE_FRAGMENT)
                .add(R.id.fragment_container, activityFragment, TAG_ACTIVITY_FRAGMENT)
                .add(R.id.fragment_container, accountFragment, TAG_ACCOUNT_FRAGMENT)
                .commit()
        } else {
            homeFragment =
                supportFragmentManager.findFragmentByTag(TAG_HOME_FRAGMENT) as HomeFragment
            exploreFragment =
                supportFragmentManager.findFragmentByTag(TAG_EXPLORE_FRAGMENT) as ExploreFragment
            activityFragment =
                supportFragmentManager.findFragmentByTag(TAG_ACTIVITY_FRAGMENT) as ActivityFragment
            accountFragment =
                supportFragmentManager.findFragmentByTag(TAG_ACCOUNT_FRAGMENT) as AccountFragment

            selectedIndex = savedInstanceState.getInt(KEY_SELECTED_INDEX, 0)
        }
        selectFragment(selectedFragment)

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.bottom_navigation_home -> homeFragment
                R.id.bottom_navigation_explore -> exploreFragment
                R.id.bottom_navigation_activity -> activityFragment
                R.id.bottom_navigation_account -> accountFragment
                else -> throw IllegalArgumentException("Unexpected itemId")
            }
            selectFragment(fragment)
            true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_SELECTED_INDEX, selectedIndex)
    }

    override fun onBackPressed() {
        if (selectedIndex != 0) {
            binding.bottomNavigation.selectedItemId = R.id.bottom_navigation_home
        } else {
            super.onBackPressed()
        }
    }
}