val sum = 12

val coins = List(1, 2, 5)
val coins2 = List(25, 5)


def findCount(coinList: List[Int], value: Int): Int = {
  if (value == 0) 1
  else if (coinList.isEmpty || value < 0) 0
  else findCount(coinList, value - coinList.head) + findCount(coinList.tail, value)
}

findCount(coins, sum)