// Singly-linked lists are already defined with this interface:
class ListNode[T](x : T) {
  var value: T = x
  var next: Option[ListNode[T]] = None
}

def mergeTwoLinkedLists(l1: Option[ListNode[Int]], l2: Option[ListNode[Int]]): Option[ListNode[Int]] = {
  (l1, l2) match {
    case (None, None)           =>  None
    case (None, Some(_))        =>  l2
    case (Some(_), None)        =>  l1
    case (Some(n1), Some(n2))   =>  if (n1.value < n2.value)
                                      { n1.next = mergeTwoLinkedLists(n1.next, l2); l1 }
                                    else
                                      { n2.next = mergeTwoLinkedLists(l1, n2.next); l2 }
  }
}
