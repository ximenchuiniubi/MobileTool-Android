package com.kiwi.mobiletool.view.activity

import android.app.Fragment
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import com.kiwi.mobiletool.R
import com.kiwi.mobiletool.databinding.ActivityMainBinding
import com.kiwi.mobiletool.model.MenuEntity
import com.kiwi.mobiletool.view.fragment.AppListFragment
import com.kiwi.mobiletool.view.fragment.RunningProcessFragment

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mFragments: MutableList<Fragment>
    private lateinit var menuItems: MutableList<MenuEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initToolBar()
        initDrawer()
        initMenuList()
        initFragment()
    }

    private fun initMenuList() {
        menuItems = mutableListOf(
            MenuEntity(getString(R.string.all_applications), R.mipmap.icon_application),
            MenuEntity(getString(R.string.is_running), R.mipmap.icon_progress)
        )
        mBinding.menuData = menuItems
        mBinding.idLeftDrawer.setOnItemClickListener { _, _, position, _ ->
            setFragment(position)
            mBinding.idDrawer.closeDrawers()
        }
    }

    private fun initDrawer() {
        val toggle = ActionBarDrawerToggle(
            this,
            mBinding.idDrawer,
            mBinding.idMainToolBar,
            R.string.open_menu,
            R.string.close_menu
        )
        toggle.syncState()
        mBinding.idDrawer.addDrawerListener(toggle)
    }

    private fun initToolBar() {
        mBinding.idMainToolBar.setTitleTextColor(getColor(R.color.deep_black))
        setSupportActionBar(mBinding.idMainToolBar)
    }

    private fun initFragment() {
        val appListFragment = AppListFragment()
        val runningProcessFragment = RunningProcessFragment()
        mFragments = mutableListOf(appListFragment, runningProcessFragment)
        setFragment(0)
    }

    private fun setFragment(i: Int) {
        if (i < mFragments.size) {
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.id_main_content, mFragments[i])
            fragmentTransaction.commit()
            mBinding.idMainToolBar.title = menuItems[i].itemName
        }
    }

    override fun onBackPressed() {
        if (mBinding.idDrawer.isDrawerOpen(Gravity.LEFT)) mBinding.idDrawer.closeDrawers()
        else super.onBackPressed()
    }
}
