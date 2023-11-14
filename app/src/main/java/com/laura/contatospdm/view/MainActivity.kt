package com.laura.contatospdm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.laura.contatospdm.R
import com.laura.contatospdm.adapter.ContactAdapter
import com.laura.contatospdm.controller.ContactController
import com.laura.contatospdm.databinding.ActivityMainBinding
import com.laura.contatospdm.model.Constant.EXTRA_CONTACT
import com.laura.contatospdm.model.Constant.VIEW_CONTACT
import com.laura.contatospdm.model.Contact

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    // Data source
    private val contactList: MutableList<Contact> by lazy {
        contactController.getContacts()
    }

    // Controller
    private val contactController: ContactController by lazy {
        ContactController(this)
    }

    // Adapter
    private val contactAdapter: ContactAdapter by lazy {
        ContactAdapter(
            this,
            contactList
        )
    }

    private lateinit var contactActivityResultLauncher:
            ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        setSupportActionBar(amb.toolbarIn.toolbar)
        supportActionBar?.subtitle = "Contact list"

        amb.contatosLv.adapter = contactAdapter

        contactActivityResultLauncher =
            registerForActivityResult(ActivityResultContracts
                .StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val contact = result.data?.getParcelableExtra<Contact>(EXTRA_CONTACT)
                    contact?.let { _contact ->
                        if (contactList.any{ it.id == _contact.id }) {
                            val position = contactList.indexOfFirst {  it.id == _contact.id  }
                            contactList[position] = _contact
                            contactController.editContact(_contact)
                        }
                        else {
                            val newId = contactController.insertContact(_contact)
                            val newContact = Contact (
                                newId,
                                _contact.name,
                                _contact.address,
                                _contact.phone,
                                _contact.email
                            )
                            contactList.add(newContact)
                        }
                        contactList.sortBy { it.name }
                        contactAdapter.notifyDataSetChanged()
                    }
                }

            }

        amb.contatosLv.setOnItemClickListener{parent,view, position,id ->
            val contact = contactList[position]
            val viewContactIntent = Intent(this, ContactActivity::class.java)
                .putExtra(EXTRA_CONTACT, contact)
                .putExtra(VIEW_CONTACT,true)

            startActivity(viewContactIntent)
        }

        registerForContextMenu(amb.contatosLv)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.addContactMi -> {
                contactActivityResultLauncher.launch(Intent(this, ContactActivity::class.java))
                true
            }

            else -> false
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.context_menu_main, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val position = (item.menuInfo as AdapterContextMenuInfo).position
        val contact = contactList[position]

        return when (item.itemId) {
            R.id.removeContactMi -> {
                contactController.removeContact(contact.id)
                contactList.removeAt(position)
                contactAdapter.notifyDataSetChanged()
                Toast.makeText(this, "Contact removed.", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.editContactMi -> {
                val contactToEdit = contactList[position]
                val editContactIntent = Intent(this, ContactActivity::class.java)
                editContactIntent.putExtra(EXTRA_CONTACT, contactToEdit)
                contactActivityResultLauncher.launch(editContactIntent)
                true
            }
            else -> {false}

        }
    }

    private fun fillContacts() {
        for (i in 1..50) {
            contactList.add(
                Contact(
                    i,
                    "Nome $i",
                    "Endereço $i",
                    "Telefone $i",
                    "Email $i"
                )

            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterForContextMenu(amb.contatosLv)
    }
}