package com.ebookfrenzy.lifecycledemomp05.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModelProvider
import com.ebookfrenzy.lifecycledemomp05.DemoObserver
import com.ebookfrenzy.lifecycledemomp05.databinding.MainFragmentBinding

lateinit var owner: MainFragment

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private val lifecycleRegistry: LifecycleRegistry

    init {
        lifecycleRegistry = LifecycleRegistry(this)
        getLifecycle().addObserver(DemoObserver())
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }


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

        owner = MainFragment()

        owner.createOwner()
        owner.startOwner()
        owner.pauseOwner()
        owner.resumeOwner()
        owner.stopOwner()
        owner.destroyOwner()

    }

    private fun startOwner() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
        binding.message.text = viewModel.setTextStart().toString()
    }

    private fun stopOwner() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
        binding.message.text = viewModel.setTextStop().toString();
    }

    private fun destroyOwner() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        binding.message.text = viewModel.setTextDestroy().toString();
    }

    private fun resumeOwner() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        binding.message.text = viewModel.setTextResumed().toString();
    }

    private fun pauseOwner() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        binding.message.text = viewModel.setTextPaused().toString()
    }

    private fun createOwner() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
        binding.message.text = viewModel.setTextCreate().toString()
    }


}