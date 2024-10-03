package com.example.bankingapp

data class Account(val accountNumber: Int = 0, val balance: Double = 0.0,
                   val status: String = "inactive", val name: String,
                   val accountType: String)
