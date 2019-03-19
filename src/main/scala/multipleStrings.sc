// Given two non-negative integers num1 and num2 represented as strings,
// return the product of num1 and num2, also represented as a string.

// Ex1
// Input: num1 = "2", num2 = "3"
// Output: "6"

// Ex2
// Input: num1 = "123", num2 = "456"
// Output: "56088"

// You must not use any built-in BigInteger library or convert the inputs to integer directly.

object Solution {
  def multiply(num1: String, num2: String): String = {
    (num1.toInt * num2.toInt).toString
  }

  def multiplyWithInt(num1: String, num2: String): String = {
    (num1.toInt * num2.toInt).toString
  }
}

