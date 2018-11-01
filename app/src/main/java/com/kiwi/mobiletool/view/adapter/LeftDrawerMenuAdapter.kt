package com.kiwi.mobiletool.view.adapter

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.kiwi.mobiletool.R
import com.kiwi.mobiletool.databinding.ItemLeftDrawerMenuBinding
import com.kiwi.mobiletool.model.MenuEntity

/**
 * @author: Kiwi
 * @date: 2018/11/1
 * @describe:
 * @email: ximenchuiniubi@gmail.com
 */
class LeftDrawerMenuAdapter(private val menuData: MutableList<MenuEntity>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ItemLeftDrawerMenuBinding =
            if (convertView == null) DataBindingUtil.inflate(
                LayoutInflater.from(parent!!.context),
                R.layout.item_left_drawer_menu,
                parent,
                false
            )
            else DataBindingUtil.getBinding(convertView)!!
        binding.menu = menuData[position]
        binding.executePendingBindings()
        return binding.root
    }

    override fun getItem(position: Int): MenuEntity {
        return menuData[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return menuData.size
    }

}