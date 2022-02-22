package cn.my.interview.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import cn.my.interview.R
import cn.my.interview.ui.activity.OnTouchActivity
import cn.my.interview.ui.activity.ServiceActivity
import cn.my.interview.ui.activity.TestActivity
import cn.my.interview.ui.mvptest.TestMvpActivity
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.fragment_test.*


/**
 * A simple [Fragment] subclass.
 * Use the [TestFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.fragment_test, container, false)
        Log.e("BlankFragment", "onCreateView--->创建Fragment的布局。")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("BlankFragment", "onViewCreated--->onViewCreated。")
        initview()
    }

    private fun initview() {
        tv_activity_test.setOnClickListener {
            Log.e("BlankFragment", "setOnClickListener--->点击事件。")
            startActivity(Intent(context, TestActivity::class.java))
            Toast.makeText(context, "activity 事件练习 ", Toast.LENGTH_SHORT).show()
        }

        tv_service_test.setOnClickListener {
            Log.e("BlankFragment", "setOnClickListener--->点击事件。")
            Toast.makeText(context, "service 事件练习 ", Toast.LENGTH_SHORT).show()
            startActivity(Intent(context, ServiceActivity::class.java))
        }
        tv_mvp_test.setOnClickListener {
            Toast.makeText(context, "mvp 练习 ", Toast.LENGTH_SHORT).show()
            startActivity(Intent(context, TestMvpActivity::class.java))
        }
        tv_ontouch_test.setOnClickListener {
            Toast.makeText(context, "事件分发机制 ", Toast.LENGTH_SHORT).show()
            startActivity(Intent(context, OnTouchActivity::class.java))
        }
        tv_arouter_test . setOnClickListener {
            Toast.makeText(context, " ", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
//        arguments
        Log.e(
            "BlankFragment",
            "onAttach--->Fragment和Activity相关联时调用。可以通过该方法获取Activity引用，还可以通过getArguments()获取参数。"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("BlankFragment", "onCreate--->Fragment被创建时调用。")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("BlankFragment", "onActivityCreated--->当Activity完成onCreate()时调用。")
    }

    override fun onStart() {
        super.onStart()
        Log.e("BlankFragment", "onStart--->当Fragment可见时调用。")
    }

    override fun onResume() {
        super.onResume()
        Log.e("BlankFragment", "onResume--->当Fragment可见且可交互时调用")
    }

    override fun onPause() {
        super.onPause()
        Log.e("BlankFragment", "onPause--->当Fragment不可交互但可见时调用。")
    }

    override fun onStop() {
        super.onStop()
        Log.e("BlankFragment", "onStop--->当Fragment不可见时调用。")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("BlankFragment", "onDestroyView--->当Fragment的UI从视图结构中移除时调用。")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("BlankFragment", "onDestroy--->销毁Fragment时调用。")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("BlankFragment", "onDetach--->当Fragment和Activity解除关联时调用")
    }


}