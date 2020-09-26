import scala.annotation.tailrec

// Singly-linked list
 class ListNode[T](x : T) {
   var value: T = x
   var next: Option[ListNode[T]] = None
 }

def isListPalindrome(l: Option[ListNode[Int]]): Boolean = {
  @tailrec
  def traverse(ls: Option[ListNode[Int]], xs: Vector[Int], xsr: Vector[Int]): Boolean = {
    ls match {
      case None       => xs == xsr
      case Some(node) => traverse(node.next, xs :+ node.value, node.value +: xsr)
    }
  }
  traverse(l, Vector(), Vector())
  // https://docs.scala-lang.org/overviews/collections-2.13/performance-characteristics.html#inner-main
}
