// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

// Example 1
// Input:
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// Output: [1,2,3,6,9,8,7,4,5]

// Example 2
// Input:
//  [
//    [1, 2, 3, 4],
//    [5, 6, 7, 8],
//    [9,10,11,12]
//  ]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]

object Solution {
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {

    def goSpiral(matrix: Array[Array[Int]], acc: List[Int], num: Int): List[Int] = {
      if (!matrix.exists(m => m.nonEmpty))
        return acc
      else {
        if (num == 0)
          goSpiral(matrix.tail, acc ::: matrix.head.toList, num + 1)
        else if (num == 1) {
          val lastElem = matrix.map(m => m.last).toList
          val matWithOutLast = matrix.map(m => m.take(m.length - 1))
          goSpiral(matWithOutLast, acc ::: lastElem, num + 1)
        }
        else if (num == 2)
          goSpiral(matrix.take(matrix.length - 1), acc ::: matrix.last.toList.reverse, num + 1)
        else {
          val firstElem = matrix.map(m => m.head).toList
          val matWithOutFirst = matrix.map(m => m.tail)
          goSpiral(matWithOutFirst, acc ::: firstElem, (num + 1 % 4))
        }
      }
    }

    goSpiral(matrix, List(), 0)
  }
}


val example1 = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))
val example2 = Array(Array(1, 2, 3, 4), Array(5, 6, 7, 8), Array(9, 10, 11, 12))
Solution.spiralOrder(example2)