package cn.my.interview.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import cn.my.interview.R

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        Log.e("TestActivity", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.e("TestActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("TestActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("TestActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("TestActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TestActivity", "onDestroy")
    }

}