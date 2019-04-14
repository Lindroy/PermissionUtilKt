package com.lindroid.demo

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.lindroid.permissionutilkt.R
import com.lindroid.permissionutilkt.Tag
import kotlinx.android.synthetic.main.activity_normal.*

private const val RC_CALL_PHONE = 100

class NormalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)
        button.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                //没有权限则申请
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), RC_CALL_PHONE)
            } else {
                callPhone()
            }
        }
    }

    private fun callPhone() {
        startActivity(with(Intent(Intent.ACTION_CALL)) {
            data = Uri.parse("tel:1008611")

            this
        })
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val rational =  ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)
        Log.e(Tag,"rational="+rational)
        if (requestCode == RC_CALL_PHONE) {
            when {
                grantResults[0] == PackageManager.PERMISSION_GRANTED -> callPhone()
                rational-> with(AlertDialog.Builder(this)) {
                    setMessage("需要权限，否则无法工作")
                    setPositiveButton("确定", { dialog, which ->

                    })
                    this
                }.show()
                else -> Toast.makeText(this, "你拒绝了权限，需要在设置中开启", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
