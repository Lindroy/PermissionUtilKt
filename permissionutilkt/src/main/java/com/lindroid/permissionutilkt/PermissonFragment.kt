package com.lindroid.permissionutilkt


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlin.random.Random

const val Tag = "Tag"
class PermissionFragment : Fragment() {

    @SuppressLint("UseSparseArrays")
    private val callbacks =
        HashMap<Int, (grantResults: IntArray, shouldShowRationales: BooleanArray) -> Unit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    fun requestPermissions(permissions: Array<out String>,callback:(grantResults: IntArray, shouldShowRationales: BooleanArray) -> Unit){
        val requestCode = createRequestCode()
        callbacks[requestCode] = callback
        requestPermissions(permissions,requestCode)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val shouldShowRationales = permissions.map {
            shouldShowRequestPermissionRationale(it)
        }.toBooleanArray()
        callbacks.remove(requestCode)?.invoke(grantResults, shouldShowRationales)
    }

    private fun createRequestCode(): Int {
        val random = Random
        while (true) {
            val code = random.nextInt(65536)
            if (!callbacks.containsKey(code)) {
                return code
            }
        }
    }

}
