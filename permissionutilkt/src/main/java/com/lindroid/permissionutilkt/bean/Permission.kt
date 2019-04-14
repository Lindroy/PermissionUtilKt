package com.lindroid.permissionutilkt.bean

/**
 * @author Lin
 * @date 2019/4/12
 * @function
 * @description
 */
data class Permission (
    val name:String,
    val granted:Boolean,
    val shouldShowRequestPermissionRationale:Boolean
){

}