package com.masudinn.fp_pam_2087.UI.Dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.masudinn.fp_pam_2087.R
import com.masudinn.fp_pam_2087.UI.Favorite.FavoriteFragment
import com.masudinn.fp_pam_2087.UI.LastMatch.LastMatchFragment
import com.masudinn.fp_pam_2087.UI.NextMatch.NextFragment
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
//                R.id.lastMatch -> {
//                    Toasty.info(this, "Last Match", Toast.LENGTH_SHORT, true).show();
//                    loadViewLastMatch(savedInstanceState)
//                }
                R.id.nextMatch -> {
                    Toasty.info(this, "Next Match", Toast.LENGTH_SHORT, true).show();
                    loadViewNextMatch(savedInstanceState)
                }
                R.id.favMatch -> {
                    Toasty.info(this, "Favorite Match", Toast.LENGTH_SHORT, true).show();
                    loadViewFavoritesMatch(savedInstanceState)
                }
            }
            true
        }

        bottom_navigation.selectedItemId = R.id.nextMatch
    }

    private fun loadViewFavoritesMatch(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, FavoriteFragment(), FavoriteFragment::class.java.simpleName)
                .commit()
        }
    }

    private fun loadViewNextMatch(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, NextFragment(), NextFragment::class.java.simpleName)
                .commit()
        }
    }

//    private fun loadViewLastMatch(savedInstanceState: Bundle?) {
//        if (savedInstanceState == null) {
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.main_container, LastMatchFragment(), LastMatchFragment::class.java.simpleName)
//                .commit()
//        }
//    }
}