val stringToCheck = "melionyhlhas"

val dict = List("hello", "has", "my", "lion")


def substrings(input: String) = {
  def goSubString(inp: String, acc: String): Unit = {
    if (inp.isEmpty && dict.contains(acc)) {
      println(acc)
    }
    if (!input.contains(acc) || inp.isEmpty) {
      //      println(acc)
      return
    }
    goSubString(inp.tail, acc + inp.head)
    goSubString(inp.tail, acc)
  }

  goSubString(input, "")
}

substrings("melionyhlhas")