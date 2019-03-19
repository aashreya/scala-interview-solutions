class CSV {
  def parse(stringToParse: String): Array[Array[String]] = {
    return stringToParse.split("\n")
      .map(row => row.split(","))
  }

  def parse2(stringToParse: String, separator: String, quotedChar: String): Array[Array[String]] = {
    val doubleEscaped = checkForEscapedQuotedChar(stringToParse, quotedChar)
    val escapedString = escapeQuotedText(doubleEscaped, separator, quotedChar)
    return escapedString.split("\n")
      .map(row => row.split(separator).map(cell => cell.replace("\u03c0", "\n").replace("\u03c2", quotedChar).replace("\u03c4", ",")))
  }

  def escapeQuotedText(quotedString: String, separator: String, quotedCharacter: String): String = {
    if (quotedString.indexOf(quotedCharacter) == -1)
      quotedString
    else {
      val subStr = quotedString.substring(quotedString.indexOf(quotedCharacter) + 1, quotedString.length)
      val extracted = subStr.substring(0, subStr.indexOf(quotedCharacter))
      val replaced = extracted.replace("\n", "\u03c0").replace(quotedCharacter, "\u03c2").replace(separator, "\u03c4")
      escapeQuotedText(quotedString.replace(quotedCharacter + extracted + quotedCharacter, replaced), separator, quotedCharacter)
    }
  }

  def checkForEscapedQuotedChar(sentString: String, quotedChar: String): String = {
    sentString.replace(quotedChar + quotedChar, "\u03c2")
  }

}

object test {
  def main(args: Array[String]): Unit = {
    val example1 = "a,b,c\nd,e,f"
    val example2 = "one,\"two wraps,\nonto \"\"two\"\" lines\",three\n4,,6"
    val example3 = "|alternate|\t|\"quote\"|\n\n|character|\t|hint: |||"
    prettyPrinter(example1)
    prettyPrinter(example2)
    prettyPrinter(example3)
  }

  def prettyPrinter(example: String) = {
    val csvParser = new CSV()
    val parsedData = csvParser.parse2(example, "\t", "|")
    print("[")
    parsedData.foreach(data => println("[" + data.mkString(",") + "]"))
    print("]")
  }
}

//val example1 = "a,b,c\nd,e,f"
//val example2 = "one,\"two wraps,\nonto \"\"two\"\" lines\",three\n4,,6"
//val example3 = "|alternate|\t|\"quote\"|\n\n|character|\t|hint: |||"
//
//val csvParser = new CSV()
//def prettyPrinter(example: String) = {
//  val parsedData = csvParser.parse2(example, "\t", "|")
//  print("[")
//  parsedData.foreach(data => println("[" + data.mkString(",") + "]"))
//  print("]")
//}
//
////nicePrinter(example1)
////println(csvParser.escapeQuotedText(example2, "\""))
//prettyPrinter(example3)