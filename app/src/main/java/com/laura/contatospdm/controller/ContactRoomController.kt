package com.laura.contatospdm.controller

import androidx.room.Room
import com.laura.contatospdm.model.Contact
import com.laura.contatospdm.model.ContactRoomDao
import com.laura.contatospdm.model.ContactRoomDao.Constant.CONTACT_DATABASE_FILE
import com.laura.contatospdm.model.ContactRoomDaoDatabase
import com.laura.contatospdm.view.MainActivity

class ContactRoomController(mainActivity: MainActivity) {
    private val contactDaoImpl: ContactRoomDao by lazy {
        Room.databaseBuilder(
            mainActivity,
            ContactRoomDaoDatabase::class.java,
            CONTACT_DATABASE_FILE
        ).build().getContactRoomDao()
    }

    fun insertContact(contact: Contact): Int = contactDaoImpl.createContact(contact)
    fun getContact(id: Int) = contactDaoImpl.retrieveContact(id)
    fun getContacts() = contactDaoImpl.retrieveContacts()
    fun editContact(contact: Contact) = contactDaoImpl.updateContact(contact)
    fun removeContact(contact: Contact) = contactDaoImpl.deleteContact(contact)
}