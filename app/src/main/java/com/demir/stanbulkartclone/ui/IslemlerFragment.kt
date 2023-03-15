package com.demir.stanbulkartclone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.demir.stanbulkartclone.R
class IslemlerFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        requireActivity().getWindow().setStatusBarColor(requireActivity().getColor(R.color.white))
        return inflater.inflate(R.layout.fragment_islemler, container, false)
    }
}