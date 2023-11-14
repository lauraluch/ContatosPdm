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
import com.laura.contatospdm.controller.ContactRoomController
import com.laura.contatospdm.databinding.ActivityMainBinding
import com.laura.contatospdm.model.Constant.EXTRA_CONTACT
import com.laura.contatospdm.model.Constant.VIEW_CONTACT
import com.laura.contatospdm.model.Contact

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    //Data Source
    private val contactList: MutableList<Contact> = mutableListOf()

    // Controller
    private val contactController: ContactRoomController by lazy {
        ContactRoomController(this)
    }

    //Adapter
    private val contactAdapter: ContactAdapter by lazy {
        ContactAdapter(
            this,
            contactList
        )
    }

    //ARL
    private lateinit var carl: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        setSupportActionBar(amb.toolbarIn.toolbar)
        //fillContacts()
        amb.contatosLv.adapter=contactAdapter

        carl = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){result ->
            if (result.resultCode == RESULT_OK){
                val contact = result.data?.getParcelableExtra<Contact>(EXTRA_CONTACT)
                contact?.let { _contact ->
                    if(contactList.any { it.id == contact.id }){
                        contactController.editContact(_contact)
                    }else {
                        contactController.insertContact(_contact)
                    }
                }
            }
        }

        amb.contatosLv.setOnItemClickListener{ parent, view, position, id ->
            val contact = contactList[position]
            val viewContactIntent = Intent(this, ContactActivity::class.java)
                .putExtra(EXTRA_CONTACT, contact)
                .putExtra(VIEW_CONTACT,true)

            startActivity(viewContactIntent)
        }

        registerForContextMenu(amb.contatosLv)
        contactController.getContacts()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.addContactMi -> {
                carl.launch(Intent(this,ContactActivity::class.java))
                true
            }
            else -> true
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

        return when (item.itemId){
            R.id.removeContactMi -> {
                contactController.removeContact(contact)
                Toast.makeText(this,"Removido", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.editContactMi -> {
                val contactToEdit = contactList[position]
                val editContactIntent = Intent(this, ContactActivity::class.java)
                editContactIntent.putExtra(EXTRA_CONTACT, contactToEdit)
                carl.launch(editContactIntent)
                true
            }
            else -> {true}
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        unregisterForContextMenu(amb.contatosLv)
    }

    fun updateContactList(_contactList: MutableList<Contact>){
        contactList.clear()
        contactList.addAll(_contactList)
        contactAdapter.notifyDataSetChanged()
    }
}