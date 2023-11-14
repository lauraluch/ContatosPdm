package com.laura.contatospdm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.laura.contatospdm.R
import com.laura.contatospdm.databinding.ActivityContactBinding
import com.laura.contatospdm.model.Constant.EXTRA_CONTACT
import com.laura.contatospdm.model.Constant.VIEW_CONTACT
import com.laura.contatospdm.model.Contact
import kotlin.random.Random

class ContactActivity : AppCompatActivity() {
    private val acb: ActivityContactBinding by lazy {
        ActivityContactBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(acb.root)

        setSupportActionBar(acb.toolbarIn.toolbar)
        supportActionBar?.subtitle = "Contact details"

        val receivedContact = intent.getParcelableExtra<Contact>(EXTRA_CONTACT)
        receivedContact?.let {_receivedContact ->
            val viewContact = intent.getBooleanExtra(VIEW_CONTACT, false)
            with (acb) {
                if (viewContact){
                    nameEt.isEnabled = false
                    addressEt.isEnabled = false
                    phoneEt.isEnabled = false
                    emailEt.isEnabled = false
                    saveBt.isVisible = false
                }
                nameEt.setText(_receivedContact.name)
                addressEt.setText(_receivedContact.address)
                phoneEt.setText(_receivedContact.phone)
                emailEt.setText(_receivedContact.email)

            }


        }

        with(acb) {
            saveBt.setOnClickListener {
                val contact: Contact = Contact(
                    receivedContact?.id?:generateId(),
                    nameEt.text.toString(),
                    addressEt.text.toString(),
                    phoneEt.text.toString(),
                    emailEt.text.toString()
                )

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_CONTACT, contact)
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }

    private fun generateId(): Int = Random(System.currentTimeMillis()).nextInt()
}