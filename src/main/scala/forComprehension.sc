val l1 = List(1, 2, 3)
val l2 = List('a', 'b', 'c')
val l3 = List(7, 8, 9)

val loop = for (
  x <- l1;
  y <- l2
  if x < 3
) yield (x.toString + y.toString)

println(loop)

val loop2 = l1.filter(x => x < 3)
val loop3 = loop2.flatMap(x => l2.map(y => x.toString + y.toString))
println(loop3)

