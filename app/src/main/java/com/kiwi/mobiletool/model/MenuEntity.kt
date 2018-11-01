package com.kiwi.mobiletool.model

import android.databinding.BaseObservable
import android.databinding.Bindable

/**
 * @author: Kiwi
 * @date: 2018/11/1
 * @describe:
 * @email: ximenchuiniubi@gmail.com
 */
class MenuEntity: BaseObservable {
    @Bindable
    var itemName: String
    @Bindable
    var iconId:Int

    constructor(itemName: String, iconId: Int) : super() {
        this.itemName = itemName
        this.iconId = iconId
    }
}