package com.zzz.library

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

class InvisibleFragment : Fragment() {

    private var callback : PerissionCallBack? = null

    fun requestNow(cb: PerissionCallBack , vararg permissions: String) {
        callback = cb
        requestPermissions(permissions,1)

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray) {
        if (requestCode == 1){
            val  deniedList = ArrayList<String>()
            for ((index,result) in grantResults.withIndex()){
                if (result != PackageManager.PERMISSION_GRANTED){
                    deniedList.add(permissions[index])
                }
            }
            val  allGanted = deniedList.isEmpty()
            callback?.let { it(allGanted,deniedList) }
        }

    }
}

typealias PerissionCallBack = ((Boolean, List<String>) -> Unit)