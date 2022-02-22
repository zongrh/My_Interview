package cn.my.interview.ui.fragment

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 *
 * FileName: KotlinPagerAdapter
 * Author: nanzong
 * Date: 2022/2/13 8:30 下午
 * Description:
 * History:
 *
 */
class KotlinPagerAdapter(var mList: List<Fragment>, fm: FragmentManager?) :
    FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return mList.size
    }

    override fun getItem(p0: Int): Fragment {
        return mList[p0]
    }
}