package com.example.bankingapp

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val accounts = ArrayList<Account>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buildDataSet()

        val bank_list_view = findViewById<ListView>(R.id.account_listView)
        val adapter = BankListAdapter(this@MainActivity, accounts)
        bank_list_view.adapter = adapter

        bank_list_view.setOnItemClickListener { adapterView, view, i, l ->
            val element: Account = adapter.getItem(i) as Account
            Toast.makeText(
                this@MainActivity, "Account Holder:\t ${element.name}\n" +
                        "Account Status:\t ${element.status.uppercase()}", Toast.LENGTH_LONG
            ).show()
        }
    }


    fun buildDataSet() {
        accounts.add(Account(accountNumber = 3498394, accountType = "Savings", name = "John Claude",
            balance = 1000020.0, status = "active"))
        accounts.add(Account(accountNumber = 765666, accountType = "Chequing", name = "John Claude",
            balance = 10020.0, status = "active"))
        accounts.add(Account(accountNumber = 21111, accountType = "Credit", name = "John Claude",
            balance = -222000.0, status = "active"))
        accounts.add(Account(accountNumber = 333233, accountType = "Savings", name = "John Claude",
            balance = 0.0, status = "inactive"))
        accounts.add(Account(accountNumber = 3494, accountType = "Investments",
            name = "John Claude and Maria Claude",
            balance = 1000020.0, status = "active"))
        accounts.add(Account(accountNumber = 34933334, accountType = "USD Investments",
            name = "John Claude and Maria Claude",
            balance = 4020.0, status = "inactive"))
        accounts.add(Account(accountNumber = 111194, accountType = "JPY Investments",
            name = "John Claude and Maria Claude",
            balance = 320.0, status = "active"))
    }
}