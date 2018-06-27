def maxi(x: Int, y: Int) = if (x >= y) x else y

def lengthOfLongestSubstring(s: String): Int = {
  def go(acc: String, original: String): Int = {
    if (original.isEmpty || acc.indexOf(original.head) != -1 || (acc.length != 1 && s.indexOf(acc + original.head) == -1)) {
      println(acc)
      return acc.length
    }
    maxi(go(acc + original.head, original.tail), go(acc, original.tail))
  }

  go("", s)
}

println(lengthOfLongestSubstring("abcabcbb"))