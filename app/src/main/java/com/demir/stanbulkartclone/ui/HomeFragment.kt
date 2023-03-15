package com.demir.stanbulkartclone.ui

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.demir.stanbulkartclone.R
import com.demir.stanbulkartclone.adapter.FragmentAdapter
import com.demir.stanbulkartclone.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(layoutInflater,container,false)
        requireActivity().getWindow().setStatusBarColor(requireActivity().getColor(R.color.tool_bar))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoriesFragments= arrayListOf<Fragment>(
            AllFragment(),
            OffersFragment(),
            NewsFragment()
        )
        binding.viewPager.isUserInputEnabled=false
        val homeViewPagerAdepter=FragmentAdapter(categoriesFragments,childFragmentManager,lifecycle)
        binding.viewPager.adapter=homeViewPagerAdepter
        TabLayoutMediator(binding.tabLayout,binding.viewPager){tab,position->
            when(position){
                0-> tab.text="Tümü"
                1-> tab.text="Kampanyalar"
                2-> tab.text="Haberler"
            }

        }.attach()
        for (i in 0 until binding.tabLayout.getTabCount()) {
            val tab = (binding.tabLayout.getChildAt(0) as ViewGroup).getChildAt(i)
            val p = tab.layoutParams as MarginLayoutParams
            p.setMargins(15, 0, 15, 0)
            tab.requestLayout()
        }
        val tabCount = binding.tabLayout.tabCount
        for (i in 0 until tabCount) {
            val tab = binding.tabLayout.getTabAt(i)
            val tabView = tab?.view
            val layoutParams = tabView?.layoutParams as LinearLayout.LayoutParams
            layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT
            tabView.layoutParams = layoutParams
            val tabTextView = tab.customView as TextView?
            tabTextView?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10f)
            tab.customView = tabTextView
        }
    }


}