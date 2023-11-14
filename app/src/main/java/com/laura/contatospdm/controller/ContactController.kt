package com.laura.contatospdm.controller

import com.laura.contatospdm.model.Contact
import com.laura.contatospdm.model.ContactDao
import com.laura.contatospdm.model.ContactDaoSqlite
import com.laura.contatospdm.view.MainActivity

class ContactController(mainActivity: MainActivity) {
    private val contactDaoImpl: ContactDao = ContactDaoSqlite(mainActivity)

    fun insertContact(contact: Contact): Int = contactDaoImpl.createContact(contact)
    fun getContact(id: Int) = contactDaoImpl.retrieveContact(id)
    fun getContacts() = contactDaoImpl.retrieveContacts()
    fun editContact(contact: Contact) = contactDaoImpl.updateContact(contact)
    fun removeContact(id: Int) = contactDaoImpl.deleteContact(id)
}