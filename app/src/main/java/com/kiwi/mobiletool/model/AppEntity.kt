package com.kiwi.mobiletool.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.graphics.drawable.Drawable

/**
 * @author Kiwi
 * @date 2018/10/31
 * @describe
 */
class AppEntity:BaseObservable {
    @Bindable
    var appName: String
    @Bindable
    var versionName: String
    @Bindable
    var versionCode: Int
    @Bindable
    var packageName: String
    @Bindable
    var icon: Drawable

    constructor(appName: String, versionName: String, versionCode: Int, packageName: String, icon: Drawable) {
        this.appName = appName
        this.versionName = versionName
        this.versionCode = versionCode
        this.packageName = packageName
        this.icon = icon
    }
}