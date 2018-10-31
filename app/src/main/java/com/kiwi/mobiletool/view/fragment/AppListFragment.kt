package com.kiwi.mobiletool.view.fragment

import android.app.Fragment
import android.databinding.DataBindingUtil
import android.os.Build
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.DividerItemDecoration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kiwi.mobiletool.R
import com.kiwi.mobiletool.databinding.FragmentAppListBinding
import com.kiwi.mobiletool.model.AppEntity
import com.kiwi.mobiletool.util.e

/**
 * @author: Kiwi
 * @date: 2018/10/31
 * @describe:
 * @email: ximenchuiniubi@gmail.com
 */
class AppListFragment : Fragment() {
    companion object {
        const val TAG: String = "AppListFragment"
    }

    private lateinit var mBinding: FragmentAppListBinding
    private val mData: ArrayList<AppEntity> = ArrayList()
    private var mHasGotData: Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_app_list, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        init()
        if (!mHasGotData) getAllApplications()
    }

    private fun init() {
        mBinding.data = mData
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mBinding.idAppList.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
        }
    }

    private fun getAllApplications() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val packages = context.packageManager.getInstalledPackages(0)
            e(TAG, "packages count " + packages.size + "......")
            for (packageInfo in packages) mData.add(
                AppEntity(
                    packageInfo.applicationInfo.loadLabel(context.packageManager).toString(),
                    packageInfo.versionName,
                    packageInfo.versionCode,
                    packageInfo.packageName,
                    packageInfo.applicationInfo.loadIcon(context.packageManager)
                )
            )
            mHasGotData = true
        } else {
            Snackbar.make(mBinding.root, "仅支持API " + Build.VERSION_CODES.M + "以上版本", 3000).show()
        }
    }
}