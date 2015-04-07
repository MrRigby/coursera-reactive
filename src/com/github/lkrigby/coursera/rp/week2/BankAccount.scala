package com.github.lkrigby.coursera.rp.week2

class BankAccount {

  private var balance = 0
  
  def deposit(amount: Int) {
    if (amount > 0) balance = balance + amount
  }
  
  def withdraw(amount: Int): Int = {
    if (amount > 0 && amount <= balance) {
      balance = balance - amount
      balance
    } else {
      throw new Error("Insufficient funds")
    }
  }
  
}