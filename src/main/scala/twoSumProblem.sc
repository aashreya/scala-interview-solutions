//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//  Example:
//
//  Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1]


object Solution {

  // Using for comprehension O(n^2)
  def twoSum(nums: Array[Int], target: Int): Array[Int] = for {
    x <- nums
    y <- nums
    if (x + y) == target
  } yield x

  // Using map and for each O(n^2)
  def twoSumFlatMap(nums: Array[Int], target: Int): Array[Int] = nums.flatMap(x => nums.filter(y => x + y == target))

  // Using a hash map O(n)
  def twoSumMap(nums: Array[Int], target: Int): Array[Int] = {
    val elementsAsMap2: Map[Int, Int] = nums.zipWithIndex.foldLeft(Map.empty[Int, Int])((a: Map[Int, Int], b: (Int, Int)) => a + (b._1 -> b._2))
    nums.filter(x => elementsAsMap2.getOrElse(target - x, -1) != -1)
  }

}


val arr1 = Array(2, 7, 11, 15, 6, 8, 19, 178, 9, 10, 87, 15, 121, 112)
val sum = 28
val t1 = System.nanoTime()
Solution.twoSum(arr1, sum)
val t2 = System.nanoTime()
println(t2 - t1)
val t3 = System.nanoTime()
Solution.twoSumFlatMap(arr1, sum)
val t4 = System.nanoTime()
println(t4 - t3)
val t5 = System.nanoTime()
Solution.twoSumMap(arr1, sum)
val t6 = System.nanoTime()
println(t6 - t5)