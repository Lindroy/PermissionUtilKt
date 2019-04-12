package com.lindroid.permissionutilkt

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.content.ContextCompat

/**
 * @author Lin
 * @date 2019/4/12
 * @function 权限申请工具类
 * @Description
 */

fun Context.isPermGranted(permission: String): Boolean = Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
    PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, permission)
