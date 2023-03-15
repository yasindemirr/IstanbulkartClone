package com.demir.stanbulkartclone.ui

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.navigation.fragment.findNavController
import com.demir.stanbulkartclone.R
import com.demir.stanbulkartclone.databinding.FragmentPasswordBinding
import com.demir.stanbulkartclone.util.SharedPref

class PasswordFragment : Fragment() {
    private lateinit var binding:FragmentPasswordBinding
    private lateinit var sharedPref: SharedPref
    var isTime:Boolean=false
    var currentFocus: View? = null
    private var lastClickTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentPasswordBinding.inflate(layoutInflater, container, false)
        requireActivity().getWindow().setStatusBarColor(requireActivity().getColor(R.color.white))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.close.setOnClickListener {
            findNavController().navigateUp()
        }
        sharedPref= SharedPref(requireContext())
        binding.editText1.requestFocus()
        binding.editText2.apply {

            isClickable=false
        }
        binding.editText3.apply {

            isClickable=false
        }

        binding.editText4.apply {

            isClickable=false
        }

        binding.editText5.apply {

            isClickable=false
        }

        binding.editText6.apply {

            isClickable=false
        }

        val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.editText1, InputMethodManager.SHOW_IMPLICIT)
        paswordChange()
    }

    private fun paswordChange() {
        val editTextList= arrayListOf(binding.editText1,binding.editText2,binding.editText3,binding.editText4,
            binding.editText5,binding.editText6)
        for (i in 0 until editTextList.size) {
            editTextList[i].addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (before == 0 && count == 1) {
                        // Kullanıcı bir karakter yazdığında bir sonraki editText'e geç
                        if (i < editTextList.size - 1) {
                            editTextList[i + 1].requestFocus()
                        }else{
                            val password = binding.editText1.text.toString() + binding.editText2.text.toString() + binding.editText3.text.toString() +
                                    binding.editText4.text.toString() + binding.editText5.text.toString() + binding.editText6.text.toString()
                            editTextList.forEach{
                                it.text.clear()
                                it.setBackgroundResource(R.drawable.edit_text_backrooudn)
                                val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                                imm.hideSoftInputFromWindow(editTextList[i].windowToken, 0)
                            }
                            if(password=="314159"){
                                binding.highText.visibility=View.GONE
                                sharedPref.saveTime(System.nanoTime())
                                findNavController().navigate(R.id.action_passwordFragment_to_kartlarimFragment)
                            }else{
                                binding.highText.visibility=View.VISIBLE

                            }
                        }

                    }
                }
                override fun afterTextChanged(s: Editable?) {

                }
            })
            editTextList[i].setOnKeyListener(object : View.OnKeyListener {
                override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                    if (keyCode == KeyEvent.KEYCODE_DEL && event?.action == KeyEvent.ACTION_DOWN) {
                        // Backspace tuşuna basıldığında, önceki editText'e geç ve içeriğini sıfırla
                        if (i > 0) {
                            editTextList[i - 1].requestFocus()
                            editTextList[i - 1].setText("")
                        }
                    }
                    return false
                }
            })
        binding.editText1.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                binding.editText1.setBackgroundResource(R.drawable.edit_text_focus_backrooudn)
            } else {
                if (binding.editText1.text.toString().isNotEmpty()) {
                    binding.editText1.setBackgroundResource(R.drawable.edit_text_changed_backrooudn)
                } else {
                    binding.editText1.setBackgroundResource(R.drawable.edit_text_backrooudn)                }
            }
        }

        binding.editText2.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                binding.editText2.setBackgroundResource(R.drawable.edit_text_focus_backrooudn)
            } else {
                if (binding.editText2.text.toString().isNotEmpty()) {
                    binding.editText2.setBackgroundResource(R.drawable.edit_text_changed_backrooudn)
                } else {
                    binding.editText2.setBackgroundResource(R.drawable.edit_text_backrooudn)                }
            }
        }

        binding.editText3.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                binding.editText3.setBackgroundResource(R.drawable.edit_text_focus_backrooudn)
            } else {
                if (binding.editText3.text.toString().isNotEmpty()) {
                    binding.editText3.setBackgroundResource(R.drawable.edit_text_changed_backrooudn)
                } else {
                    binding.editText3.setBackgroundResource(R.drawable.edit_text_backrooudn)                }
            }
        }
        binding.editText4.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                binding.editText4.setBackgroundResource(R.drawable.edit_text_focus_backrooudn)
            } else {
                if (binding.editText4.text.toString().isNotEmpty()) {
                    binding.editText4.setBackgroundResource(R.drawable.edit_text_changed_backrooudn)
                } else {
                    binding.editText4.setBackgroundResource(R.drawable.edit_text_backrooudn)                }
            }
        }
        binding.editText5.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                binding.editText5.setBackgroundResource(R.drawable.edit_text_focus_backrooudn)
            } else {
                if (binding.editText5.text.toString().isNotEmpty()) {
                    binding.editText5.setBackgroundResource(R.drawable.edit_text_changed_backrooudn)
                } else {
                    binding.editText5.setBackgroundResource(R.drawable.edit_text_backrooudn)                }
            }
        }

        binding.editText6.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                binding.editText6.setBackgroundResource(R.drawable.edit_text_focus_backrooudn)
            } else {
                if (binding.editText6.text.toString().isNotEmpty()) {
                    binding.editText6.setBackgroundResource(R.drawable.edit_text_changed_backrooudn)
                } else {
                    binding.editText6.setBackgroundResource(R.drawable.edit_text_backrooudn)                }
            }
        }
    }
}
}