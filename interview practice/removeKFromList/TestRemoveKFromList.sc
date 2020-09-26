import $file.RemoveKFromList, RemoveKFromList._
import scala.annotation.tailrec

val a = Option(new ListNode[Int](3))
val b = Option(new ListNode[Int](1))
val c = Option(new ListNode[Int](2))
val d = Option(new ListNode[Int](3))
val e = Option(new ListNode[Int](4))
val f = Option(new ListNode[Int](5))

a.get.next = b
b.get.next = c
c.get.next = d
d.get.next = e
e.get.next = f
f.get.next = None

val ar = Option(new ListNode[Int](1))
val br = Option(new ListNode[Int](2))
val cr = Option(new ListNode[Int](4))
val dr = Option(new ListNode[Int](5))

ar.get.next = br
br.get.next = cr
cr.get.next = dr
dr.get.next = None

@tailrec
def compareLinkedList(xs: Option[ListNode[Int]], ys: Option[ListNode[Int]]): Boolean = {
  (xs, ys) match {
    case (None, None) => true
    case (Some(x), Some(y)) => if (x.value == y.value) compareLinkedList(x.next, y.next) else false
    case (Some(_), None) => false
    case (None, Some(_)) => false
  }
}

assert(pprint.log(compareLinkedList(removeKFromList(a, 3), ar)) == true)