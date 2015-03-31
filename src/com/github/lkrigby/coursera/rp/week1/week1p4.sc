package com.github.lkrigby.coursera.rp.week1

import JSON._

object week1p4 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val jsonList = List(exampleJsonData)            //> jsonList  : List[com.github.lkrigby.coursera.rp.week1.JObj] = List(JObj(Map(
                                                  //| firstName -> JStr(John), lastName -> JStr(Smith), address -> JObj(Map(street
                                                  //| Address -> JStr(ul. Chlewikowa 21), state -> JStr(Wielkopolska), postalCode 
                                                  //| -> JStr(60-123), city -> JStr(Chlewikowo))), phoneNumbers -> JSeq(List(JObj(
                                                  //| Map(type -> JStr(home), number -> JStr(21421212121))), JObj(Map(type -> JStr
                                                  //| (mobile), number -> JStr(464673757547))))))))

  for {
    JObj(bindings) <- jsonList
    JSeq(phones) = bindings("phoneNumbers")
    JObj(phone) <- phones
    JStr(digits) = phone("number")
    if digits startsWith "21"
  } yield (bindings("firstName"), bindings("lastName"))
                                                  //> res0: List[(com.github.lkrigby.coursera.rp.week1.JSON, com.github.lkrigby.co
                                                  //| ursera.rp.week1.JSON)] = List((JStr(John),JStr(Smith)))
  
}