package com.lindroid.permissionutilkt

import android.support.v4.app.FragmentActivity

/**
 * @author Lin
 * @date 2019/4/12
 * @function
 * @Description
 */
private const val TAG = "PermissionHandler"

internal class PermissionHandler private constructor() {
    constructor(activity: FragmentActivity) : this() {
        getPermFragment(activity)
    }

    private var permFragment: PermissionFragment? = null

    private fun getPermFragment(activity: FragmentActivity): PermissionFragment {
        permFragment = activity.supportFragmentManager.findFragmentByTag(TAG) as PermissionFragment?
        if (permFragment == null) {
            permFragment = PermissionFragment()
            activity.supportFragmentManager.beginTransaction()
                .add(permFragment!!,TAG)
                .commitAllowingStateLoss()
            activity.supportFragmentManager.executePendingTransactions()
        }
        return permFragment!!
    }

    fun request(vararg permissions:String,callback:(grantResults: IntArray, shouldShowRationales: BooleanArray) -> Unit){
        permFragment?.requestPermissions(permissions,callback)

    }



}