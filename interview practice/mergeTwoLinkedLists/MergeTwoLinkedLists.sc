import scala.annotation.tailrec

// Singly-linked lists are already defined with this interface:
 class ListNode[T](x : T) {
   var value: T = x
   var next: Option[ListNode[T]] = None
}

def mergeTwoLinkedLists(l1: Option[ListNode[Int]], l2: Option[ListNode[Int]]): Option[ListNode[Int]] = {
  @tailrec
  def trav(l1: Option[ListNode[Int]], l2: Option[ListNode[Int]], l3: Option[ListNode[Int]]): Unit = {
    (l1, l2) match {
      case (None, None)         =>
      case (None, Some(_))      =>  l3.get.next = l2
      case (Some(_), None)      =>  l3.get.next = l1
      case (Some(n1), Some(n2)) =>  if (n1.value < n2.value) { l3.get.next = l1; trav(n1.next, l2, l1) }
                                    else { l3.get.next = l2; trav(l1, n2.next, l2) }
    }
  }

  (l1, l2) match {
    case (None, None)          => None
    case (None, Some(_))       => l2
    case (Some(_), None)       => l1
    case (Some(n1), Some(n2))  => if (n1.value < n2.value) { trav(n1.next, l2, l1); l1 }
                                  else { trav(l1, n2.next, l2); l2 }
  }
}
