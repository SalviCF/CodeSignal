import scala.annotation.tailrec

// Singly-linked lists are already defined with this interface:
class ListNode[T](x : T) {
  var value: T = x
  var next: Option[ListNode[T]] = None
}

def reverseNodesInKGroups(l: Option[ListNode[Int]], k: Int): Option[ListNode[Int]] = {

  @tailrec
  def reverse(orig: Option[ListNode[Int]], last: Option[ListNode[Int]], n: Int, init: Option[ListNode[Int]], flag: Boolean): (Option[ListNode[Int]], Option[ListNode[Int]], Option[ListNode[Int]]) = {
    orig match {
      case None       =>  if (n == k || flag) (last, init, None) else reverse(last, None, 0, last, true)
      case Some(node) =>  if (n == k) (last, init, orig)
      else {
        val next = node.next
        node.next = last
        reverse(next, orig, n + 1, init, flag)
      }
    }
  }

  @tailrec
  def link(end: Option[ListNode[Int]], cont: Option[ListNode[Int]]): Unit = {
    if (cont.isDefined) {
      val (s, e, c) = reverse(cont, None, 0, cont, flag = false)
      end.get.next = s
      link(e, c)
    }
  }

  val (start, end, cont) = reverse(l, None, 0, l, flag = false)
  link(end, cont)
  start
}
