package com.ebookfrenzy.lifecycledemomp05.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.lifecycledemomp05.DemoObserver
import com.ebookfrenzy.lifecycledemomp05.databinding.MainFragmentBinding

import android.widget.TextView
import androidx.lifecycle.Observer


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        lifecycle.addObserver(DemoObserver())

        val messageObserver = Observer<String> { result ->
            binding.message.text = result.toString()
        }

        viewModel.getMessage().observe(viewLifecycleOwner, messageObserver)
    }


}