package com.lindroid.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.lindroid.permissionutilkt.PermissionUtil;
import com.lindroid.permissionutilkt.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;


public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        PermissionUtil.permRequestCombined(this, , new Function2<Boolean, Boolean, Unit>() {
            @Override
            public Unit invoke(Boolean aBoolean, Boolean aBoolean2) {
                return null;
            }
        });
    }
}
