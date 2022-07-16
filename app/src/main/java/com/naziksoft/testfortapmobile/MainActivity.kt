package com.naziksoft.testfortapmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naziksoft.testfortapmobile.databinding.ActivityMainBinding
import com.naziksoft.testfortapmobile.view.SearchFragment

class MainActivity : AppCompatActivity() {

    private val viewBinding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        supportFragmentManager.beginTransaction()
            .add(viewBinding.container.id, SearchFragment())
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}