package com.github.lkrigby.coursera.rp.week1

object week1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  abstract class JSON
  case class JSeq (elems: List[JSON]) extends JSON
  case class JObj (bindings: Map[String, JSON]) extends JSON
  case class JNum (num: Double) extends JSON
  case class JStr (str: String) extends JSON
  case class JBool (b: Boolean) extends JSON
  case object JNull extends JSON
  
  val data = JObj(Map(
    "firstName" -> JStr("John"),
    "lastName" -> JStr("Smith"),
    "address" -> JObj(Map(
      "streetAddress" -> JStr("ul. Chlewikowa 21"),
      "state" -> JStr("Wielkopolska"),
      "postalCode" -> JStr("60-123"),
      "city" -> JStr("Chlewikowo")
    )),
    "phoneNumbers" -> JSeq(List(
      JObj(Map(
        "type" -> JStr("home"), "number" -> JStr("21421212121")
      )),
      JObj(Map(
        "type" -> JStr("mobile"), "number" -> JStr("464673757547")
      ))
    ))
  ))                                              //> data  : com.github.lkrigby.coursera.rp.week1.week1.JObj = JObj(Map(firstName
                                                  //|  -> JStr(John), lastName -> JStr(Smith), address -> JObj(Map(streetAddress -
                                                  //| > JStr(ul. Chlewikowa 21), state -> JStr(Wielkopolska), postalCode -> JStr(6
                                                  //| 0-123), city -> JStr(Chlewikowo))), phoneNumbers -> JSeq(List(JObj(Map(type 
                                                  //| -> JStr(home), number -> JStr(21421212121))), JObj(Map(type -> JStr(mobile),
                                                  //|  number -> JStr(464673757547)))))))
  
  def show(json: JSON): String = json match {
    case JSeq(elems) =>
      "[" + (elems map show mkString ", ") + "]"
    case JObj(bindings) =>
      val assocs = bindings map {
        case (key, value) => "\"" + key + "\": " + show(value)
      }
      "{" + (assocs mkString ", ") + "}"
    case JNum(num) => num.toString
    case JStr(str) => "\"" + str + "\""
    case JBool(b) => b.toString
    case JNull => "null"
  }                                               //> show: (json: com.github.lkrigby.coursera.rp.week1.week1.JSON)String
  
  show(data)                                      //> res0: String = {"firstName": "John", "lastName": "Smith", "address": {"stre
                                                  //| etAddress": "ul. Chlewikowa 21", "state": "Wielkopolska", "postalCode": "60
                                                  //| -123", "city": "Chlewikowo"}, "phoneNumbers": [{"type": "home", "number": "
                                                  //| 21421212121"}, {"type": "mobile", "number": "464673757547"}]}

  // This won't compile!
  // val fun = { case (key, value) => key + "\": " + value }
  
  // But this will compile
  type JBinding = (String, JSON)
  val anonymousFunction: (JBinding => String) = { case (key, value) => key + "\": " + value }
                                                  //> anonymousFunction  : com.github.lkrigby.coursera.rp.week1.week1.JBinding =>
                                                  //|  String = <function1>
  val typeFunction1 = new Function1[JBinding, String] {
    def apply(x: JBinding) = x match {
      case (key, value) => key + "\": " + value
    }
  }                                               //> typeFunction1  : com.github.lkrigby.coursera.rp.week1.week1.JBinding => Str
                                                  //| ing = <function1>
  
  val typeFunction2: Function1[JBinding, String] = { case (key, value) => key + "\": " + value }
                                                  //> typeFunction2  : com.github.lkrigby.coursera.rp.week1.week1.JBinding => Str
                                                  //| ing = <function1>
  
  val partialTypeFunction: PartialFunction[JBinding, String] = { case (key, value) => key + "\": " + value }
                                                  //> partialTypeFunction  : PartialFunction[com.github.lkrigby.coursera.rp.week1
                                                  //| .week1.JBinding,String] = <function1>
  
}