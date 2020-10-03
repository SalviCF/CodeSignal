import $file.AddTwoHugeNumbers, AddTwoHugeNumbers._

import scala.annotation.tailrec

val a = Option(new ListNode[Int](9876))
val b = Option(new ListNode[Int](5432))
val c = Option(new ListNode[Int](1999))
val n1 = List(a, b, c)

val d = Option(new ListNode[Int](1))
val e = Option(new ListNode[Int](8001))
val n2 = List(d, e)

val f = Option(new ListNode[Int](9876))
val g = Option(new ListNode[Int](5434))
val h = Option(new ListNode[Int](0))
val sum = List(f, g, h)

def link(nodes: List[Option[ListNode[Int]]]): Option[ListNode[Int]] = {
  for (i <- Range(0, nodes.length - 1)) nodes(i).get.next = nodes(i + 1)
  nodes.last.get.next = None
  nodes.head
}

val ll1 = link(n1)
val ll2 = link(n2)
val llSum = link(sum)

@tailrec
def makeList(ll: Option[ListNode[Int]], l: List[Int]): List[Int] = {
  if (ll.isEmpty) l
  else makeList(ll.get.next, l :+ ll.get.value)
}

assert(pprint.log(makeList(addTwoHugeNumbers(ll1, ll2), Nil)) == makeList(llSum, Nil))