package com.kiwi.mobiletool.view.adapter

import android.databinding.DataBindingUtil
import android.support.annotation.NonNull
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kiwi.mobiletool.R
import com.kiwi.mobiletool.databinding.ItemAppListBinding
import com.kiwi.mobiletool.model.AppEntity

/**
 * @author: Kiwi
 * @date: 2018/10/31
 * @describe:
 * @email: ximenchuiniubi@gmail.com
 */
class AppListAdapter(private val appList: List<AppEntity>) : RecyclerView.Adapter<AppListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_app_list, parent, false))
    }

    override fun getItemCount(): Int {
        return appList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(appList[position])
    }

    class ViewHolder : RecyclerView.ViewHolder {
        private var mBinding: ItemAppListBinding

        constructor(itemView: View) : super(itemView) {
            mBinding = DataBindingUtil.bind(itemView)!!
        }

        fun bind(@NonNull appEntity: AppEntity) {
            mBinding!!.app = appEntity
            mBinding!!.executePendingBindings()
        }
    }
}