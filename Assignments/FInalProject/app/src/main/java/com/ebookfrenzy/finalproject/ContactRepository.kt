package com.ebookfrenzy.finalproject

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepository(application: Application) {

    val searchResults = MutableLiveData<List<Contact>>()
    private var contactDAO: ContactDAO?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    val allContacts: LiveData<List<Contact>>?

    init {
        val database: ContactRoomDatabase? = ContactRoomDatabase.getDatabase(application)
        contactDAO = database?.contactDao()

        allContacts = contactDAO?.getAllContacts()
    }

    private suspend fun asyncInsert(newContact: Contact) {
        contactDAO?.insertContact(newContact)
    }

    fun insertContact(newContact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newContact)
        }
    }

    private suspend fun asyncDelete(contactId: Int) {
        contactDAO?.deleteContact(contactId)
    }

    fun deleteContact(contactId: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(contactId)
        }
    }

    private suspend fun asyncFind(contactName: String): Deferred<List<Contact>?> = coroutineScope.async(Dispatchers.IO) {
        return@async contactDAO?.findContact(contactName)
    }

    fun findContact(contactName: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(contactName).await()
        }
    }

    private suspend fun asyncASC(): Deferred<List<Contact>?> = coroutineScope.async(Dispatchers.IO) {
        return@async contactDAO?.sortASC()
    }

    fun sortASC() {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncASC().await()
        }
    }

    private suspend fun asyncDSC(): Deferred<List<Contact>?> = coroutineScope.async(Dispatchers.IO) {
        return@async contactDAO?.sortDSC()
    }

    fun sortDSC() {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncDSC().await()
        }
    }

}