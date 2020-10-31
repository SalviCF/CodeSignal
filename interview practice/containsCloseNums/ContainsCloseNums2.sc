def containsCloseNums(nums: Array[Int], k: Int): Boolean = {
  nums
    .zipWithIndex.groupBy(_._1).values.exists{a =>
    a.length > 1 && {
      val ix = a.map(_._2)
      ix.zip(ix.tail).exists(t => t._2 - t._1 <= k)
    }
  }
}