package com.kiwi.utilslibrary.utils

import android.util.Log
import com.kiwi.utilslibrary.BuildConfig

/**
 * @author: Kiwi
 * @date: 2018/10/31
 * @describe: Log工具类
 * @email: ximenchuiniubi@gmail.com
 */

fun e(tag: String, msg: String) {
    if (BuildConfig.DEBUG) Log.e(tag, msg)
}

fun i(tag: String, msg: String) {
    if (BuildConfig.DEBUG) Log.i(tag, msg)
}

fun w(tag: String, msg: String) {
    if (BuildConfig.DEBUG) Log.w(tag, msg)
}