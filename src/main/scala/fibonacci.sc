val n = 5

// 0 1 1 2 3 5 8

def fibo(num: Int): Int = {
  if (num <= 1)
    return 0
  else if (num == 2)
    return 1
  else return (fibo(n - 1) + fibo(n - 2))
}

def fiboTail(num: Int): Int = {
  def goFibo(num1: Int, num2: Int, acc: Int, nVal: Int): Int = {
    if (nVal == num)
      return acc
    goFibo(num2, num1 + num2, acc + num1, nVal + 1)
  }

  goFibo(0, 1, 1, 2)
}

fiboTail(6)