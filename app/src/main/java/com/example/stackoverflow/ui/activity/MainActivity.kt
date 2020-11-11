package com.example.stackoverflow.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.stackoverflow.R
import com.example.stackoverflow.ui.fragment.answer.AnswerFragment
import com.example.stackoverflow.ui.fragment.home.HomeFragment
import com.example.stackoverflow.viewmodels.HomeViewModel
import com.example.stackoverflow.utils.loadFragment
import com.example.stackoverflow.utils.toHtml

class MainActivity : AppCompatActivity() {

    private lateinit var homeFragment: HomeFragment
    private lateinit var answerFragment: AnswerFragment
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActionBar(true)
        initFragments()
        initObservers()
    }

    private fun initFragments() {
        homeFragment = HomeFragment.newInstance()
        loadFragment(R.id.container, homeFragment)
    }

    private fun setupActionBar(isHome: Boolean, title: String = "") {
        if (isHome) {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            supportActionBar?.setLogo(R.drawable.stackoverflow_round)
            supportActionBar?.setDisplayUseLogoEnabled(true)
        } else {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setLogo(null)
            supportActionBar?.setDisplayUseLogoEnabled(false)
            supportActionBar?.title = title
        }
    }

    private fun initObservers() {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.questionMutableLiveData.observe(this, {
            answerFragment = AnswerFragment.newInstance(it)
            loadFragment(R.id.container, answerFragment, false)
            setupActionBar(false, it.title.toHtml())
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            setupActionBar(true)
        }
        return super.onOptionsItemSelected(item)
    }
}