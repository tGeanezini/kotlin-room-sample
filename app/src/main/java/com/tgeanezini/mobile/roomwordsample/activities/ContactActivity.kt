package com.tgeanezini.mobile.roomwordsample.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.tgeanezini.mobile.roomwordsample.R
import com.tgeanezini.mobile.roomwordsample.util.EXTRA_REPLY
import kotlinx.android.synthetic.main.activity_contact.*

class ContactActivity : AppCompatActivity() {
    private lateinit var firstNameEdit: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        button_save.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(firstNameEdit.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val firstName = firstNameEdit.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, firstName)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }

        button_cancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED, Intent())
            finish()
        }
    }
}