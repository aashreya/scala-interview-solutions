// main method in "Solution" will be run as your answer
object Solution {

  val clusterMap = Map()

  def main(args: Array[String]) {
    //Enter your code here. Read input from STDIN. Print output to STDOUT
    //val n = readInt
    val paths = Array("A B", "B C", "C D", "D E F", "F G")
    // println(findAllUniqueEvents(paths).mkString(","))
    val initialMap = initializeUniqueClusterMap(paths)
    // println(addAllElementsToMap("ABC",Array('A'),initialMap).mkString(","))
    val finalCluster = mergePathsInMap(paths, initialMap)
    // println(finalCluster.keys.mkString(","))
    val lenghths = finalCluster.values.map(x => x.length)
    val sortedLenghths = lenghths.toArray.sortWith(_ > _)
    sortedLenghths.map(x => println(x))
  }

  def findAllUniqueEvents(paths: Array[String]): Array[String] = paths.mkString(" ").split(" ").distinct

  def initializeUniqueClusterMap(paths: Array[String]): Map[Char, Array[Char]] = {
    val uniqueHeads = paths.map(x => x.head).distinct
    //println(uniqueHeads.mkString(","))

    return uniqueHeads.foldLeft(Map.empty[Char, Array[Char]])((a, b) => {
      val mer: Array[Char] = paths.filter(x => x.head == b).mkString(" ").toArray.filter(z => z != ' ')
      a + (b -> mer)
    })
  }

  def addAllElementsToMap(path: String, mergeString: Array[Char], clusterMap: Map[Char, Array[Char]]): Array[Char] = {
    if (path.isEmpty)
      return mergeString
    val currentElemenst = if (clusterMap.keySet.contains(path.head)) clusterMap(path.head) else Array[Char]()
    println()
    val newElemets = mergeString.union(currentElemenst).union(Array(path.head)).distinct.filter(x => x != ' ')
    println(path + " | " + newElemets.mkString(","))
    addAllElementsToMap(path.tail, newElemets, clusterMap)

  }

  def mergePathsInMap(paths: Array[String], clusterMap: Map[Char, Array[Char]]): Map[Char, Array[Char]] = {
    if (paths.isEmpty)
      return clusterMap
    val path = paths.head
    val allReachableEvents = if (clusterMap.keySet.contains(path.head))
      addAllElementsToMap(path, clusterMap(path.head), clusterMap)
    else Array[Char]()
    //println(allReachableEvents.mkString(","))
    val mergedMap = path.tail.foldLeft(clusterMap)((a, b) => if (a.keySet.contains(b)) a - b else a)
    val addedMap = if (allReachableEvents.isEmpty) mergedMap else mergedMap + (path.head -> allReachableEvents)
    mergePathsInMap(paths.tail, addedMap)
  }


}

Solution.main(Array(""));