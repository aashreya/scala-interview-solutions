//The set [1,2,3,...,n] contains a total of n! unique permutations.
//
// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
//
// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.
//
//Note:
//
// Given n will be between 1 and 9 inclusive.
// Given k will be between 1 and n! inclusive.

// Ex1
// Input: n = 3, k = 3
// Output: "213"

//Ex2
// Input: n = 4, k = 9
// Output: "2314"

object Solution {
  def getPermutation(n: Int, k: Int): String = {
    //val rangeList = Range(1 to n)
    val num = Math.pow(2, k - 1) - 1
    val index = Math.abs(n / num)
    println(index)
    ""
  }

  def permutations(orgList: List[Int], plist: List[Int]): Unit = {
    if (orgList.isEmpty) {
      println(plist)
      return
    }
    val fst = orgList.head
    val swapped = orgList.map(x => {
      val idx = orgList.indexOf(x)
      val newLst = orgList.take(idx) :+ fst
      val newLst2 = x :: newLst.tail ::: orgList.drop(idx + 1)
      newLst2
    })
    swapped.foreach(x => permutations(x.tail, plist :+ x.head))
  }
}

val n = 3
val k = 3

val n1 = 3
val k1 = 3

val p1 = List(1, 2, 3)
val p2 = List(1, 2, 3, 4)

//Solution.permutations(p1, List.empty)
Solution.permutations(p2, List.empty)
//Solution.getPermutation(n1, k1)