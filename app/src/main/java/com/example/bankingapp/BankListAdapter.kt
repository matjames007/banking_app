package com.example.bankingapp

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Color.GRAY
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class BankListAdapter(context: Context, private val dataSource: ArrayList<Account>): BaseAdapter() {
    val context: Context;
    val accounts: ArrayList<Account>;

    init{
        this.context = context;
        this.accounts = dataSource;
    }

    override fun getCount(): Int {
        return this.accounts.size
    }

    override fun getItem(p0: Int): Any {
        return this.accounts[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("SetTextI18n", "ViewHolder", "DefaultLocale")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View

        if(p1 != null) {
            view = p1
        } else {
            view = LayoutInflater.from(this.context)
                .inflate(R.layout.account_list_item, p2, false)
        }

        val currentSelectedItem: Account = this.accounts[p0]
        view.findViewById<TextView>(R.id.account_type)?.text = currentSelectedItem.accountType
        view.findViewById<TextView>(R.id.account_number)?.text = "Account Number: " + currentSelectedItem.accountNumber.toString()
        view.findViewById<TextView>(R.id.account_name)?.text = currentSelectedItem.name
        val formattedCurrency: String = "$ \t" + String.format("%.2f", currentSelectedItem.balance)
        if(currentSelectedItem.status == "inactive") {
            view.setBackgroundColor(Color.GRAY)
        } else {
            view.setBackgroundColor(Color.WHITE)
        }
        view.findViewById<TextView>(R.id.balance)?.text = formattedCurrency

        if(currentSelectedItem.balance < 0) {
            view.findViewById<TextView>(R.id.balance)?.setTextColor(Color.RED)
        } else {
            view.findViewById<TextView>(R.id.balance)?.setTextColor(Color.BLUE)
        }

        return view
    }
}