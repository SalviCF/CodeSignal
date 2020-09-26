import scala.annotation.tailrec

// Singly-linked list
 class ListNode[T](x : T) {
   var value: T = x
   var next: Option[ListNode[T]] = None
 }

def removeKFromList(l: Option[ListNode[Int]], k: Int): Option[ListNode[Int]] = {
  @tailrec
  def remove(head: Option[ListNode[Int]], prev: Option[ListNode[Int]], curr: Option[ListNode[Int]]): Option[ListNode[Int]] = {
    (head, prev, curr) match {
      case (Some(h), Some(p), Some(c))    =>  if (h.value == k) remove(h.next, p.next, c.next)
                                              else if (c.value == k) {
                                                p.next = c.next
                                                remove(head, prev, c.next)
                                              }
                                              else remove(head, p.next, c.next)
      case (Some(h), _, None)             =>  if (h.value == k) None else head
      case (_, _, _)                      =>  head
    }
  }
  if (l.isEmpty) None else remove(l, l, l.get.next)
}
