package com.ebookfrenzy.navigationprojectmp06.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.ebookfrenzy.navigationprojectmp06.R

import com.ebookfrenzy.navigationprojectmp06.databinding.MainFragmentBinding
import androidx.navigation.Navigation

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

            action.setMsgArg("Image 1")
           // action.setImgArg(R.id.img1)

            Navigation.findNavController(it).navigate(action)
        }

        binding.button2.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()

            action.setMsgArg("Image 2")
           // action.setImgArg(binding.img1.id)


            Navigation.findNavController(it).navigate(action)
        }

        binding.button3.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()

            action.setMsgArg("Image 3")
          //  action.setImgArg(R.id.img3)

            Navigation.findNavController(it).navigate(action)
        }
    }

}