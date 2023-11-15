package com.laura.contatospdm.controller

import android.os.Message
import androidx.room.Room
import com.laura.contatospdm.model.Constant
import com.laura.contatospdm.model.Contact
import com.laura.contatospdm.model.ContactDao
import com.laura.contatospdm.model.ContactDaoRtDbFb
import com.laura.contatospdm.model.ContactRoomDao
import com.laura.contatospdm.model.ContactRoomDaoDatabase
import com.laura.contatospdm.view.MainActivity

class ContactRtDbFbController(private val mainActivity: MainActivity) {
    private val contactDaoImpl: ContactDao = ContactDaoRtDbFb()

    fun insertContact(contact: Contact) {
        Thread {
            contactDaoImpl.createContact(contact)
        }.start()
    }

    fun getContact(id: Int) = contactDaoImpl.retrieveContact(id)

    fun getContacts() {
        Thread {
            val returnList = contactDaoImpl.retrieveContacts()

            mainActivity.updateContactListHandler.apply {
                sendMessage(Message().apply {
                    data.putParcelableArray(
                        Constant.CONTACT_ARRAY,
                        returnList.toTypedArray()
                    )
                })
            }

        }.start()
    }

    fun editContact(contact: Contact){
        Thread {
            contactDaoImpl.updateContact(contact)
        }.start()
    }

    fun removeContact(contact: Contact){
        Thread {
            contact.id?.also {
                contactDaoImpl.deleteContact(it)
            }
        }.start()
    }
}