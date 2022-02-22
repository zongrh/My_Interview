package cn.zong.wanandroid.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.kotlin.wanandroid.utils.Constant
import cn.zong.wanandroid.R


class ContentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_content, container, false)
    }

    companion object {
        fun newInstance(cid: Int): ContentFragment {
            var bundle = Bundle()
            bundle.putInt(Constant.id, cid)
            val fragment = ContentFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

}