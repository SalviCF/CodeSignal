// Singly-linked list
class ListNode[T](x : T) {
  var value: T = x
  var next: Option[ListNode[T]] = None
}

def removeKFromList(l: Option[ListNode[Int]], k: Int): Option[ListNode[Int]] = {
  l.flatMap(x => if (x.value == k) removeKFromList(x.next, k) else {
    x.next = removeKFromList(x.next, k)
    Option(x)
  })
}