import scala.annotation.tailrec

// Definition for singly-linked list:
 class ListNode[T](x : T) {
   var value: T = x
   var next: Option[ListNode[T]] = None
 }

def addTwoHugeNumbers(a: Option[ListNode[Int]], b: Option[ListNode[Int]]): Option[ListNode[Int]] = {

  @tailrec
  def reverse(orig: Option[ListNode[Int]], last: Option[ListNode[Int]]): Option[ListNode[Int]] = {
    if (orig.isEmpty) last else {
      val next = orig.get.next
      orig.get.next = last
      reverse(next, orig)
    }
  }

  def merge(a: Option[ListNode[Int]], b: Option[ListNode[Int]], overflow: Int): Option[ListNode[Int]] = {
    if (a.isEmpty && b.isEmpty) return if (overflow == 1) Option(new ListNode(1)) else None
    val sum   = a.map(_.value).getOrElse(0) + b.map(_.value).getOrElse(0) + overflow
    val node  = new ListNode(sum % 10000)
    node.next = merge(a.flatMap(_.next), b.flatMap(_.next), sum / 10000)
    Option(node)
  }

  reverse(merge(reverse(a,None),reverse(b,None),0),None)
}
