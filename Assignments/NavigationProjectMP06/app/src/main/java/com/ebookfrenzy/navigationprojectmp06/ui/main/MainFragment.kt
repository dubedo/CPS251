package com.ebookfrenzy.navigationprojectmp06.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ebookfrenzy.navigationprojectmp06.R
import com.ebookfrenzy.navigationprojectmp06.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel


        binding.button1.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()

            action.setMsgArg(binding.img1.contentDescription.toString())
            action.setImgArg(R.drawable.android_image_1)

            Navigation.findNavController(it).navigate(action)
        }

        binding.button2.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()

            action.setMsgArg(binding.img2.contentDescription.toString())
            action.setImgArg(R.drawable.android_image_2)


            Navigation.findNavController(it).navigate(action)
        }

        binding.button3.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()

            action.setMsgArg(binding.img3.contentDescription.toString())
            action.setImgArg(R.drawable.android_image_3)

            Navigation.findNavController(it).navigate(action)
        }
    }

}