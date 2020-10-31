def containsCloseNums(nums: Array[Int], k: Int): Boolean = {
  nums
    .zipWithIndex
    .groupBy(_._1)
    .values.filter(_.length > 1)
    .map(_.map(_._2))
    .map(a => a.zip(a.tail))
    .exists(_.exists(t => t._2 - t._1 <= k))
}