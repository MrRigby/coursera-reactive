package com.github.lkrigby.coursera.rp.week1

import JSON._

object week1p3 {
  
  showJson(exampleJsonData)                       //> res0: String = {"firstName": "John", "lastName": "Smith", "address": {"stree
                                                  //| tAddress": "ul. Chlewikowa 21", "state": "Wielkopolska", "postalCode": "60-1
                                                  //| 23", "city": "Chlewikowo"}, "phoneNumbers": [{"type": "home", "number": "214
                                                  //| 21212121"}, {"type": "mobile", "number": "464673757547"}]}

  /*
   *  Have some fun with the function definitions.
   */

  // This won't compile! - missing parameter type for the function
  // val fun = { case (key, value) => key + "\": " + value }
  
  // But these 2 will compile
  val anonymousFunction1: ((String, JSON) => String) = { case (key, value) => key + "\": " + value }
                                                  //> anonymousFunction1  : (String, com.github.lkrigby.coursera.rp.week1.JSON) =>
                                                  //|  String = <function2>
  
  type JBinding = (String, JSON)
  val anonymousFunction2: (JBinding => String) = { case (key, value) => key + "\": " + value }
                                                  //> anonymousFunction2  : com.github.lkrigby.coursera.rp.week1.week1p3.JBinding 
                                                  //| => String = <function1>
  
  // we can also use Function1
  val typeFunction1 = new Function1[JBinding, String] {
    def apply(x: JBinding) = x match {
      case (key, value) => key + "\": " + value
    }
  }                                               //> typeFunction1  : com.github.lkrigby.coursera.rp.week1.week1p3.JBinding => St
                                                  //| ring = <function1>
  
  val typeFunction2: Function1[JBinding, String] = { case (key, value) => key + "\": " + value }
                                                  //> typeFunction2  : com.github.lkrigby.coursera.rp.week1.week1p3.JBinding => St
                                                  //| ring = <function1>
  
  // or just use partial function
  val partialTypeFunction: PartialFunction[JBinding, String] = { case (key, value) => key + "\": " + value }
                                                  //> partialTypeFunction  : PartialFunction[com.github.lkrigby.coursera.rp.week1.
                                                  //| week1p3.JBinding,String] = <function1>
  
}