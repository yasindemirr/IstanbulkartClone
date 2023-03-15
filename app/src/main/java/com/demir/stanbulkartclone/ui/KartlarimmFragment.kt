package com.demir.stanbulkartclone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.demir.stanbulkartclone.R
import com.demir.stanbulkartclone.adapter.KartlarimAdapter
import com.demir.stanbulkartclone.databinding.FragmentKartlarimmBinding


class KartlarimmFragment : Fragment() {
    private lateinit var binding: FragmentKartlarimmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding=FragmentKartlarimmBinding.inflate(layoutInflater,container,false)
        requireActivity().getWindow().setStatusBarColor(requireActivity().getColor(R.color.white))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val kartlarimAdapter=KartlarimAdapter()
        binding.kartRec.apply {
            adapter=kartlarimAdapter
            layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        }
    }
}