// Generate Pascals Triangle


object Solution {
  def generate(numRows: Int): List[List[Int]] = {
    val rangeList = (1 to numRows).toList

    val data = rangeList.tail.foldLeft(List(List(1)))((a, b) => newRowBasedOnPrevious(b, a))
    println(data)
    data
  }

  def newRowBasedOnPrevious(a: Int, b: List[List[Int]]): List[List[Int]] = {
    val prev = b.last
    if (b.length <= 1)
      b :+ List(1, 1)
    else {
      val data = for {
        (x, i) <- prev.zipWithIndex
        if (i != 0)
      } yield (prev(i - 1) + x)
      val newRow = 1 :: data
      val newRow2 = newRow :+ 1
      b :+ newRow2
    }
  }
}

val ex1 = 5
Solution.generate(ex1)