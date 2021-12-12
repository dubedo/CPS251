package com.ebookfrenzy.finalproject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDAO {

    @Insert
    fun insertContact(contact: Contact)

    @Query("SELECT * FROM contacts WHERE contactName LIKE '%' || :contactName || '%'")
    fun findContact(contactName: String): List<Contact>

    @Query("DELETE FROM contacts WHERE contactId = :id")
    fun deleteContact(id: Int)

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<Contact>>


    @Query("SELECT * FROM contacts ORDER BY contactName ASC")
    fun sortASC(): List<Contact>

    @Query("SELECT * FROM contacts ORDER BY contactName DESC")
    fun sortDSC(): List<Contact>


}