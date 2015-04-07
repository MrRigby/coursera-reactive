package com.github.lkrigby.coursera.rp.week2

object week2p1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val account = new BankAccount                   //> account  : com.github.lkrigby.coursera.rp.week2.BankAccount = com.github.lkr
                                                  //| igby.coursera.rp.week2.BankAccount@3b6eb2ec
  account deposit 50
  account withdraw 20                             //> res0: Int = 30
  account withdraw 20                             //> res1: Int = 10
  account withdraw 20                             //> java.lang.Error: Insufficient funds
                                                  //| 	at com.github.lkrigby.coursera.rp.week2.BankAccount.withdraw(BankAccount
                                                  //| .scala:16)
                                                  //| 	at com.github.lkrigby.coursera.rp.week2.week2p1$$anonfun$main$1.apply$mc
                                                  //| V$sp(com.github.lkrigby.coursera.rp.week2.week2p1.scala:10)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at com.github.lkrigby.coursera.rp.week2.week2p1$.main(com.github.lkrigby
                                                  //| .coursera.rp.week2.week2p1.scala:3)
                                                  //| 	at com.github.lkrigby.coursera.rp.week2.week2p1.main(com.github.lkrigby.
                                                  //| coursera.rp.week2.week2p1.scala)
  
}