package com.zzz.permissionx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.zzz.library.PermissionX
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textview.setOnClickListener {
            PermissionX.init(this)
                .permissions(android.Manifest.permission.CALL_PHONE)
                .request { allGranted, grantedList, deniedList ->

                    if (allGranted) {
                        call();
                    } else {
                        Toast.makeText(this, "test", Toast.LENGTH_LONG).show();
                    }
                }

        }
    }

    private fun call() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Toast.makeText(this, "call", Toast.LENGTH_LONG).show();
    }
}
