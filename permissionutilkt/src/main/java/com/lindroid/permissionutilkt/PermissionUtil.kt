package com.lindroid.permissionutilkt

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.FragmentActivity
import android.support.v4.content.ContextCompat
import android.util.Log

/**
 * @author Lin
 * @date 2019/4/12
 * @function 权限申请工具类
 * @Description
 */


fun Context.isPermGranted(permission: String): Boolean = Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
        PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, permission)


fun Context.isPermGranted(vararg permissions: String): Boolean {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
        return true
    } else {
        for (permission in permissions) {
            if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, permission)) {
                return false
            }
        }
        return true
    }
}


fun FragmentActivity.permRequest(vararg permissions: String, callback: (granted: Boolean, rationale: Boolean) -> Unit) {
    arrayOf(*permissions).forEach {
        Log.e("Tag","回调1")
        PermissionHandler(this).request(it) { grantResults, shouldShowRationales ->
            Log.e("Tag","回调2")
            callback.invoke(grantResults[0] == PackageManager.PERMISSION_GRANTED, shouldShowRationales[0])
        }
    }

}

fun FragmentActivity.perRequestCombined(vararg permission: String,callback:(grantResults: IntArray, shouldShowRationales: BooleanArray) -> Unit){
    PermissionHandler(this).request(*permission,callback = callback)

}

