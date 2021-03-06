package com.kiwi.mobiletool.util

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.ListView
import com.kiwi.mobiletool.model.AppEntity
import com.kiwi.mobiletool.model.MenuEntity
import com.kiwi.mobiletool.view.adapter.AppListAdapter
import com.kiwi.mobiletool.view.adapter.LeftDrawerMenuAdapter

/**
 * @author: Kiwi
 * @date: 2018/10/31
 * @describe: DataBinding自定义属性绑定
 * @email: ximenchuiniubi@gmail.com
 */

@BindingAdapter("bind:data")
fun setAppListData(recyclerView: RecyclerView, data: List<AppEntity>) {
    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, false)
    recyclerView.adapter = AppListAdapter(data)
}

@BindingAdapter("bind:imgSrc")
fun setAppListItemIcon(icon: ImageView, drawable: Drawable) {
    icon.setImageDrawable(drawable)
}

@BindingAdapter("bind:data")
fun setMenuData(listView: ListView, data: MutableList<MenuEntity>) {
    val leftDrawerMenuAdapter = LeftDrawerMenuAdapter(data)
    listView.adapter = leftDrawerMenuAdapter
}

@BindingAdapter("android:src")
fun setImageSrc(imageView: ImageView, resId: Int) {
    imageView.setImageResource(resId)
}