package com.lindroid.demo

import android.Manifest
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.lindroid.permissionutilkt.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("Tag","是否已获取电话权限=${isPermGranted(Manifest.permission.CALL_PHONE)}")
        btnCall.setOnClickListener {
         /*   permRequest(Manifest.permission.CALL_PHONE){grantResults, rationales ->
                Log.e("Tag","grantResults[0]=${grantResults[0]}")
                Log.e("Tag","rationales[0]=${rationales[0]}")
            }
            Log.e("Tag","是否已获取电话权限1=${isPermGranted(Manifest.permission.CALL_PHONE)}")*/

          /*  permRequest2(Manifest.permission.CALL_PHONE){granted, rationale ->
                Log.e("Tag","grantResults[0]=$granted")
                Log.e("Tag","rationales[0]=$rationale")
            }
            Log.e("Tag","是否已获取电话权限1=${isPermGranted(Manifest.permission.CALL_PHONE)}")*/





        }

        btnCombined.setOnClickListener {
            permRequestCombined(Manifest.permission.CALL_PHONE,Manifest.permission.CAMERA){granted, showRationale ->
                if (granted){
                    Toast.makeText(this,"你同意了所有的权限",Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}
