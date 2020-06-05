package com.zzz.library

import android.app.Activity
import android.nfc.Tag
import androidx.fragment.app.FragmentActivity
import javax.security.auth.callback.Callback

object PermissionX {

    private const val Tag = "InvisibleFragment"

    fun request(
        activity: FragmentActivity,
        vararg perissions: String,
        callback: PerissionCallBack
    ) {
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(Tag)
        val fragment = if (existedFragment != null) {
            existedFragment as InvisibleFragment
        } else {
            val invisibleFragment = InvisibleFragment();
            fragmentManager.beginTransaction().add(invisibleFragment, Tag).commit()
            invisibleFragment
        }
        fragment.requestNow(callback, *perissions)
    }
}