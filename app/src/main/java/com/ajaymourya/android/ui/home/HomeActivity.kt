package com.ajaymourya.android.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ajaymourya.android.R
import com.ajaymourya.android.ui.list.MovieListFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MovieListFragment.newInstance())
                .commitNow()
        }
    }
}
