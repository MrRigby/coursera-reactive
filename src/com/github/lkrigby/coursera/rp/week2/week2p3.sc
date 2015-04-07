package com.github.lkrigby.coursera.rp.week2

object week2p3 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  // WHILE loop definition
  def WHILE(condition: => Boolean)(command: => Unit): Unit = {
    if (condition) {
      command
      WHILE(condition)(command)
    } else {}
  }                                               //> WHILE: (condition: => Boolean)(command: => Unit)Unit

  // and WHILE loop usage
  var i = 3                                       //> i  : Int = 3
  WHILE(i > 0) {
    println(s"step: $i")
    i = i -1
  }                                               //> step: 3
                                                  //| step: 2
                                                  //| step: 1
  
  // REPEAT loop definition
  def REPEAT(command: => Unit)(condition: => Boolean): Unit = {
    command
    if (condition) {}
    else REPEAT(command)(condition)
  }                                               //> REPEAT: (command: => Unit)(condition: => Boolean)Unit
  
  // and REPEAT loop usage
  var j = 1                                       //> j  : Int = 1
  REPEAT {
    println(s"step: $j")
    j = j + 1
  }(j > 3)                                        //> step: 1
                                                  //| step: 2
                                                  //| step: 3
  
  // DO ... UNTIL ... loop definition
  class Repeater(command: => Unit) {
    final def UNTIL(condition: => Boolean) {
      command
      if (condition) UNTIL(condition)
    }
  }
  
  def DO(command: => Unit): Repeater = {
    new Repeater(command)
  }                                               //> DO: (command: => Unit)com.github.lkrigby.coursera.rp.week2.week2p3.Repeater
  
  // and DO ... UNTIL ... loop usage
  var k = 1                                       //> k  : Int = 1
  DO {
    println(s"step: $k")
    k = k + 1
  } UNTIL (k < 3)                                 //> step: 1
                                                  //| step: 2
  
  for (i <- 1 until 3; j <- "abc") println(s"$i $j")
                                                  //> 1 a
                                                  //| 1 b
                                                  //| 1 c
                                                  //| 2 a
                                                  //| 2 b
                                                  //| 2 c
  
}