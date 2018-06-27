
def uniquePaths(m: Int, n: Int): Int = {
  def goUniquePath(mstart: Int, nstart: Int): Int = {
    if (mstart >= m || nstart >= n)
      return 0
    else if (mstart == m - 1 && nstart == n - 1)
      return 1
    else goUniquePath(mstart + 1, nstart) + goUniquePath(mstart, nstart + 1)
  }

  goUniquePath(0, 0)
}

println(uniquePaths(7, 3))