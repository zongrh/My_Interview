package cn.zong.wanandroid.ui

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.support.v7.app.AppCompatActivity
import android.support.v4.app.Fragment
import cn.zong.wanandroid.R
import cn.zong.wanandroid.databinding.FragmentKnowledgeBinding

/**
 * An example full-screen fragment that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class KnowledgeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_knowledge, container, false)
    }

}