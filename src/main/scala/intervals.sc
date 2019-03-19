object Solution extends App {

  //  val listOfIntervals = List((10, 0.9), (13, 0.2), (19, 0.9), (20, 0.8), (30, 0.1))
  val threshold = 0.8

  def ckeckInInteval(b: List[(Int, Int)], a: (Int, Double)): List[(Int, Int)] = {
    if (b.isEmpty && a._2 >= threshold)
      return (a._1, -1) :: b
    if (a._2 >= threshold && b.last._2 == -1)
      b
    else if (a._2 < threshold && b.last._2 == -1)
      (b.last._1, a._1) :: b.take(b.length - 1)
    else if (a._2 >= threshold && b.last._2 != -1)
      (a._1, -1) :: b
    else
      b
  }

  // List(10,13),(19,30))


  def show(listOfIntervals2: List[(Int, Double)]) = {
    listOfIntervals2.foldLeft(List[(Int, Int)]())((a, b) => ckeckInInteval(a, b))
  }


  // list.foldLeft(0) { (count, _) => count + 1 }

}

val listOfIntervals = List((12, 0.2), (13, 0.9), (19, 0.9), (20, 0.8), (30, 0.1))
//val threshold = 0.8
//listOfIntervals.foldLeft(List[(Int, Int)]())((a, b) => Solution.ckeckInInteval(a, b))
val res = Solution.show(listOfIntervals)
println(res.mkString(","))
val s = "aabbcd"
val groupedList = s.toList.groupBy(x => x)