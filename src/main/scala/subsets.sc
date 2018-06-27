val subsetList1 = List(4, 3, 2, 3, 5, 2, 1)
val subsetList3 = List(1, 3, 1, 4)
val subsetList2 = List(4, 3, 2, 3, 4, 1, 2, 1)
val subsetList4 = List(4, 2, 5, 1, 1)
val k = 6


def findSubsets(elementList: List[Int], value: Int, acc: List[Int]): List[Int] = {
  if (value == 0) acc
  else if (elementList.isEmpty || value < 0) List()
  else {
    findSubsets(elementList.tail, value - elementList.head, elementList.head :: acc) ::: findSubsets(elementList.tail, value, acc)
  }
}


findSubsets(subsetList4, k, List())