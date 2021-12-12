package com.ebookfrenzy.finalproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
            } else {
                Toast.makeText(activity, resources.getString(R.string.invalidAdd), Toast.LENGTH_LONG).show()
            }
        }



        binding.findButton.setOnClickListener {
            viewModel.findContact(binding.contactName.text.toString())
        }

        binding.ascButton.setOnClickListener {
            viewModel.sortASC()
        }

        binding.descButton.setOnClickListener {
            viewModel.sortDSC()
        }

    }

    private fun observerSetup() {

        viewModel.getAllContacts()?.observe(this, Observer { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        })

        viewModel.getSearchResults().observe(this, { contacts ->
            contacts?.let {

                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                }

            }

        })

        viewModel.sortASC().observe(this, { contacts ->
            contacts?.let {

                adapter?.setContactList(it)
            }
        })

        viewModel.sortDSC().observe(this, { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        })


    }

    private fun recyclerSetup() {

        adapter = ContactListAdapter((R.layout.card_layout))
        binding.cardRecycler.layoutManager = LinearLayoutManager(context)
        binding.cardRecycler.adapter = adapter

        adapter!!.settingListener(object : ContactListAdapter.OnGarbageClicked {
            override fun onGarbageClicked(id: String) {
                var contactId: Int = Integer.parseInt(id)
                viewModel.deleteContact(contactId)
            }
        })

    }


}