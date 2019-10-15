package com.embibe.app.embibetvapp.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.leanback.app.BrowseSupportFragment
import com.embibe.app.embibetvapp.R
import com.embibe.app.embibetvapp.databinding.FragmentAnalysisBinding

/**
 * A simple [Fragment] subclass.
 */
class AnalysisFragment : Fragment(), BrowseSupportFragment.MainFragmentAdapterProvider,
    View.OnFocusChangeListener {


    private lateinit var fragmentAnalysisBinding: FragmentAnalysisBinding

    private val mMainFragmentAdapter = BrowseSupportFragment.MainFragmentAdapter(this)

    override fun getMainFragmentAdapter(): BrowseSupportFragment.MainFragmentAdapter<AnalysisFragment> {
        return mMainFragmentAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        fragmentAnalysisBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_analysis, container, false)
        fragmentAnalysisBinding.root.onFocusChangeListener = this
        fragmentAnalysisBinding.root.findViewById<View>(R.id.chipOne).onFocusChangeListener = this
        return fragmentAnalysisBinding.root
    }


    override fun onFocusChange(v: View, hasFocus: Boolean) {
        when (v.id) {
            R.id.chipOne -> {
                Toast.makeText(activity, "chipOne", Toast.LENGTH_SHORT).show()
            }
            R.id.chipTwo -> {
                Toast.makeText(activity, "chipTwo", Toast.LENGTH_SHORT).show()
            }
            R.id.chipThree -> {
                Toast.makeText(activity, "chipThree", Toast.LENGTH_SHORT).show()
            }
            R.id.chipFour -> {
                Toast.makeText(activity, "chipFour", Toast.LENGTH_SHORT).show()
            }
            R.id.chipFive -> {
                Toast.makeText(activity, "chipFive", Toast.LENGTH_SHORT).show()
            }
            R.id.chipSix -> {
                Toast.makeText(activity, "chipSix", Toast.LENGTH_SHORT).show()
            }
            R.id.chipSeven -> {
                Toast.makeText(activity, "chipSeven", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
