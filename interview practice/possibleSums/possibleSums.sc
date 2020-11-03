def possibleSums(coins: Array[Int], quantity: Array[Int]): Int = {
  coins
    .zip(quantity)
    .map(t => Range(0, t._2 + 1).map(_ * t._1))
    .reduce((xs, ys) => for { x <- xs; y <- ys } yield x + y)
    .distinct.size - 1
}