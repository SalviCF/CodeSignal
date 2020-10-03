import scala.annotation.tailrec

// Singly-linked lists are already defined with this interface:
// class ListNode[T](x : T) {
//   var value: T = x
//   var next: Option[ListNode[T]] = None
// }
//
def addTwoHugeNumbers(a: Option[ListNode[Int]], b: Option[ListNode[Int]]): Option[ListNode[Int]] = {
  @tailrec
  def reverseLN(l: Option[ListNode[Int]], v: Vector[Int]): Vector[Int] = {
    l match {
      case None    => v
      case Some(x) => reverseLN(x.next, x.value +: v)
    }
  }

  def link(nodes: Vector[Option[ListNode[Int]]]): Option[ListNode[Int]] = {
    for (i <- nodes.indices){
      if (nodes(i).get.value > 9999 && i != nodes.length - 1) {
        nodes(i + 1).get.value = nodes(i + 1).get.value + 1
        nodes(i).get.value = nodes(i).get.value - 10000
      }
      if (i != 0) nodes(i).get.next = nodes(i - 1)
    }
    nodes.head.get.next = None

    if (nodes.last.get.value > 9999) {
      nodes.last.get.value = nodes.last.get.value - 10000
      val lastOne = Option(new ListNode(1))
      lastOne.get.next = nodes.last
      lastOne
    } else nodes.last
  }

  val pairs = reverseLN(a, Vector()).zipAll(reverseLN(b, Vector()), 0, 0)
  val nodes = for ((x, y) <- pairs) yield Option(new ListNode(x + y))

  link(nodes)
}
