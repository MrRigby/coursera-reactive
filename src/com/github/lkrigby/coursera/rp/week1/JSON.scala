package com.github.lkrigby.coursera.rp.week1

abstract class JSON
case class JSeq (elems: List[JSON]) extends JSON
case class JObj (bindings: Map[String, JSON]) extends JSON
case class JNum (num: Double) extends JSON
case class JStr (str: String) extends JSON
case class JBool (b: Boolean) extends JSON
case object JNull extends JSON

object JSON {
  
  def showJson(json: JSON): String = json match {
    case JSeq(elems) =>
      "[" + (elems map showJson mkString ", ") + "]"
    case JObj(bindings) =>
      val assocs = bindings map {
        case (key, value) => "\"" + key + "\": " + showJson(value)
      }
      "{" + (assocs mkString ", ") + "}"
    case JNum(num) => num.toString
    case JStr(str) => "\"" + str + "\""
    case JBool(b) => b.toString
    case JNull => "null"
  }

  val exampleJsonData = JObj(Map(
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
  ))                                              //> data  : com.github.lkrigby.coursera.rp.week1.JObj = JObj(Map(firstName -> JS

}
