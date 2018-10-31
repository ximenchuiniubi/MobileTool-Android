package com.kiwi.mobiletool.view.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kiwi.mobiletool.R
import com.kiwi.mobiletool.databinding.ActivityMainBinding
import com.kiwi.mobiletool.view.fragment.AppListFragment

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "MainActivity"
    }
    private lateinit var mBinding: ActivityMainBinding
    private var mAppListFragment: AppListFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
    }

    private fun init() {
        mAppListFragment = AppListFragment()
        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.id_main_content, mAppListFragment)
        fragmentTransaction.commit()
    }
}
