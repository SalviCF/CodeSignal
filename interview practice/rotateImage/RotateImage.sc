def rotateImage(a: Array[Array[Int]]): Array[Array[Int]] = {
  val t = a.transpose
  t.map(e => e.reverse) // t.map(_.reverse)
}