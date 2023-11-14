package com.laura.contatospdm.controller

import android.os.AsyncTask
import android.os.Message
import androidx.room.Room
import com.laura.contatospdm.model.Constant.CONTACT_ARRAY
import com.laura.contatospdm.model.Contact
import com.laura.contatospdm.model.ContactRoomDao
import com.laura.contatospdm.model.ContactRoomDao.Companion.CONTACT_DATABASE_FILE
import com.laura.contatospdm.model.ContactRoomDaoDatabase
import com.laura.contatospdm.view.MainActivity

class ContactRoomController(private val mainActivity: MainActivity) {
    private val contactDaoImpl: ContactRoomDao by lazy {
        Room.databaseBuilder(
            mainActivity,
            ContactRoomDaoDatabase::class.java,
            CONTACT_DATABASE_FILE
        ).build().getContactRoomDao()
    }

    fun insertContact(contact: Contact) {
        Thread {
            contactDaoImpl.createContact(contact)
            getContacts()
        }.start()
    }

    fun getContact(id: Int) = contactDaoImpl.retrieveContact(id)

    fun getContacts() {
        Thread {
            val returnList = contactDaoImpl.retrieveContacts()

            mainActivity.updateContactListHandler.apply {
                sendMessage(Message().apply {
                    data.putParcelableArray(
                        CONTACT_ARRAY,
                        returnList.toTypedArray()
                    )
                })
            }

        }.start()
    }

    fun editContact(contact: Contact){
        Thread {
            contactDaoImpl.updateContact(contact)
            getContacts()
        }.start()
    }

    fun removeContact(contact: Contact){
        Thread {
            contactDaoImpl.deleteContact(contact)
            getContacts()
        }.start()
    }
}