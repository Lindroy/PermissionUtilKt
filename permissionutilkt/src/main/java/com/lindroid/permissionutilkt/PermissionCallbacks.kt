package com.lindroid.permissionutilkt

/**
 * @author Lin
 * @date 2019/4/12
 * @function 申请权限回调
 * @description
 */

interface PermissionCallbacks{


    fun onGranted()


    fun onDenied(permissions: Array<String>)


    fun onShowRationale()


    fun onNeverAskAgain()
}
