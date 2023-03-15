package com.demir.stanbulkartclone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.demir.stanbulkartclone.R
import com.demir.stanbulkartclone.adapter.HomeAdapter
import com.demir.stanbulkartclone.databinding.FragmentBaseCategoryBinding


open class BaseCategoryFragment : Fragment() {
    private lateinit var binding: FragmentBaseCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentBaseCategoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val baseAdapter=HomeAdapter()
        binding.baseRec.apply {
            adapter=baseAdapter
          val layoutManagerx=GridLayoutManager(requireContext(),2,GridLayoutManager.VERTICAL,false)
            layoutManager=layoutManagerx



        }
    }
}