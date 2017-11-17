package com.morfly.arch.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.morfly.arch.R
import com.morfly.arch.presentation.repolist.RepoListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, RepoListFragment())
                    .commit()
        }
    }
}
