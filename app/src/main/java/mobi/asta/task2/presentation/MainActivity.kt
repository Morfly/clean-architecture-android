package mobi.asta.task2.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import mobi.asta.task2.R
import mobi.asta.task2.presentation.repolist.RepoListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, RepoListFragment())
                .commit()
    }
}
