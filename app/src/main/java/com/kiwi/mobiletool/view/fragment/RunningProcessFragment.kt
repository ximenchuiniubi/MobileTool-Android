package com.kiwi.mobiletool.view.fragment

import android.app.Fragment
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kiwi.mobiletool.R
import com.kiwi.mobiletool.databinding.FragmentRunningProcessBinding

/**
 * @author: Kiwi
 * @date: 2018/11/1
 * @describe: 运行中的进程
 * @email: ximenchuiniubi@gmail.com
 */
class RunningProcessFragment : Fragment() {
    private lateinit var mBinding: FragmentRunningProcessBinding
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mBinding = DataBindingUtil.inflate(inflater!!, R.layout.fragment_running_process, container, false)
        return mBinding.root
    }
}