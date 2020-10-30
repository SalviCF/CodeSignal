def areFollowingPatterns(strings: Array[String], patterns: Array[String]): Boolean = {
  val t: Array[(String, String)] => Boolean = c => !(c.distinct.groupBy(_._1).exists(_._2.size > 1))
  t(strings.zip(patterns)) && t(patterns.zip(strings))
}