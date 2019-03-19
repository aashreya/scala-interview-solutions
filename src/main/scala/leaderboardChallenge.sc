

object Solution {

  // Complete the climbingLeaderboard function below.
  def climbingLeaderboard(scores: Array[Int], alice: Array[Int]): Array[Int] = {
    val ranked = createRankTuple(scores)
    alice.map(elem => findRanked(elem, ranked.toArray))
  }

  def findRanked(alicScore: Int, ranks: Array[(Int, Int)]): Int = {
    val filtered = ranks.filter(a => a._1 > alicScore)
    if (filtered.isEmpty) ranks.head._2 else filtered.last._2 + 1
  }

  def createRankTuple(scores: Array[Int]): List[(Int, Int)] = {
    scores.toList.tail.
      foldLeft(List((scores.head, 1)))((a, b) => if (a.last._1 == b) a :+ (b, a.last._2) else a :+ (b, a.last._2 + 1))
  }

  def compareTriplets(a: Array[Int], b: Array[Int]): Array[Int] = {
    a.zip(b).map(x => if (x._1 < x._2) (0, 1) else if (x._1 == x._2) (0, 0) else (1, 0))
      .fold(Array(0, 0))((a: Array[Int], b: (Int, Int)) => Array(a.head + b._1, a(1) + b._2))
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    //    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val scoresCount = stdin.readLine.trim.toInt

    val scores = Array(100, 100, 50, 40, 40, 20, 10)
    val alice = Array(5, 25, 50, 120)

    val result = climbingLeaderboard(scores, alice)

    println(result.mkString("\n"))

  }
}

val scores1 = Array(100, 100, 50, 40, 40, 20, 10)
val alice1 = Array(5, 25, 50, 120)
Solution.climbingLeaderboard(scores1, alice1)
//Solution.createRankTuple(scores1)
