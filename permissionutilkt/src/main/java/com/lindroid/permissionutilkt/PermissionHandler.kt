package com.lindroid.permissionutilkt

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager

/**
 * @author Lin
 * @date 2019/4/12
 * @function
 * @Description
 */
private const val TAG = "PermissionHandler"

internal class PermissionHandler private constructor() {

    constructor(activity: FragmentActivity) : this() {
        getPermFragment(activity.supportFragmentManager)
    }

    constructor(fragment: Fragment):this(){
        getPermFragment(fragment.childFragmentManager)
    }

    constructor(fm: FragmentManager):this(){
        getPermFragment(fm)
    }

    private var permFragment: PermissionFragment? = null

    private fun getPermFragment(fm: FragmentManager): PermissionFragment {
        permFragment = fm.findFragmentByTag(TAG) as PermissionFragment?
        if (permFragment == null) {
            permFragment = PermissionFragment()
            fm.beginTransaction()
                .add(permFragment!!,TAG)
                .commitAllowingStateLoss()
            fm.executePendingTransactions()
        }
        return permFragment!!
    }

    fun request(vararg permissions:String,callback:(grantResults: IntArray, showRationales: BooleanArray) -> Unit){
        permFragment?.requestPermissions(permissions,callback)

    }



}