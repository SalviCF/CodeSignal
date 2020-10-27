def groupingDishes(dishes: Array[Array[String]]): Array[Array[String]] = {
  dishes
    .flatMap(a => a.drop(1).map(a.head -> _)) // drop(1) vs tail
    .groupBy(_._2)
    .mapValues(_.map(_._1).sorted)
    .filter(_._2.length > 1)
    .map { case (k,v) => Array(k) ++ v }
    .toArray.sortBy(_.head)
}
