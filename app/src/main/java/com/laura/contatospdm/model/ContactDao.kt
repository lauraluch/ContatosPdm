package com.laura.contatospdm.model

interface ContactDao {
    fun createContact(contact: Contact): Int
    fun retrieveContact(id: Int): Contact?
    fun retrieveContacts(): MutableList<Contact>
    fun updateContact(contact: Contact): Int
    fun deleteContact(id: Int): Int
}