def removeKFromList(l: Option[ListNode[Int]], k: Int): Option[ListNode[Int]] = {
  l.flatMap(x => if (x.value == k) removeKFromList(x.next, k) else {
    x.next = removeKFromList(x.next, k)
    Option(x)
  })
}