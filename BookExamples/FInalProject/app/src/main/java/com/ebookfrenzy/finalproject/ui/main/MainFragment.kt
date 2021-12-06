package com.ebookfrenzy.finalproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.finalproject.R

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.fragment.app.viewModels
import com.ebookfrenzy.finalproject.Contact

import java.util.*

import com.ebookfrenzy.finalproject.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var adapter: ContactListAdapter? = null
    val viewModel: MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!


    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        listenerSetup()
        observerSetup()
        recyclerSetup()
    }

    private fun clearFields() {
        // binding.contactName.text = "" NOT TEXT THEY'RE EDITABLE
        // binding.contactPhone.text = ""
    }

    private fun listenerSetup() {

        binding.addButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val number = binding.contactPhone.text.toString()

            if (name != "" && number != "") {
                val contact = Contact(name, number)
                viewModel.insertContact(contact)
               // clearFields() NOT SET UP CORRECTLY
            }

        }

        binding.findButton.setOnClickListener {
            viewModel.findContact(binding.contactName.text.toString())
        }

        //  binding.delete NEEDS THE INTERFACE AND EVERYTHING
        // NEED TO SET UP LOGIC FOR ASC AND DESC AS WELL

    }

    private fun observerSetup() {

        viewModel.getAllContacts()?.observe(this, Observer { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        })


    // MISSING A SECOND METHOD HERE

    }

    private fun recyclerSetup() {

        adapter = ContactListAdapter((R.layout.card_layout))
        binding.cardRecycler.layoutManager = LinearLayoutManager(context)
        binding.cardRecycler.adapter = adapter

    }




}