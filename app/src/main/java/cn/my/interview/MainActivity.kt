package cn.my.interview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.util.Log
import cn.my.interview.ui.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {
    //    private val titles = arrayOf("java", "kotlin")
//    private val fragmentList: MutableList<Fragment> = ArrayList()

    var list = listOf<String>("JAVA", "KOTLIN", "C##", "ANDROID")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTab()
        setItem()
        initView()
    }

    private fun initView() {
        vp_main.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_main))
//        tab_main.tabTextColors = resources.getColorStateList(R.color.tab_color)
//        tab_main.setTabTextColors()
//        tab_main.setTabTextColors(
//            resources.getColor(R.color.black),
//            resources.getColor(R.color.tab_color)
//        )
    }

    private fun setItem() {
        tab_main.getTabAt(0)?.text = list[0]
        tab_main.getTabAt(1)?.text = list[1]
        tab_main.getTabAt(2)?.text = list[2]
        tab_main.getTabAt(3)?.text = list[3]
    }

    private fun setTab() {
        val tab1: TestFragment = TestFragment()
        val tab2: TestFragment2 = TestFragment2()
        val tab3: TestFragment3 = TestFragment3()
        val tab4: TestFragment4 = TestFragment4()
        var list = listOf<Fragment>(tab1, tab2, tab3, tab4)

        vp_main.adapter = KotlinPagerAdapter(list, supportFragmentManager)
        tab_main.setupWithViewPager(vp_main)
    }

    override fun onTabSelected(p0: TabLayout.Tab?) {
//        tab被选择时回调
        Log.e("addOnPageChangeListener", "tab被选择时回调: ")
        println("tab被选择时回调")
    }

    override fun onTabUnselected(p0: TabLayout.Tab?) {
//        tab未被选择时回调
        Log.e("addOnPageChangeListener", "tab未被选择时回调: ")
        println("tab未被选择时回调")
    }

    override fun onTabReselected(p0: TabLayout.Tab?) {
//        tab重新被选择时回调
        Log.e("addOnPageChangeListener", "tab重新被选择时回调: ")
        println("tab重新被选择时回调")
    }

}
