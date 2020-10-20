import $file.RearrangeLastN, RearrangeLastN._
import scala.annotation.tailrec

def link(l: List[Int]): Option[ListNode[Int]] = {
  l match {
    case Nil   => None
    case x+:xs => val n = Option(new ListNode(x))
                  n.get.next = link(xs)
                  n
  }
}

@tailrec
def compareLinkedList(xs: Option[ListNode[Int]], ys: Option[ListNode[Int]]): Boolean = {
  (xs, ys) match {
    case (None, None) => true
    case (Some(x), Some(y)) => if (x.value == y.value) compareLinkedList(x.next, y.next) else false
    case (Some(_), None) => false
    case (None, Some(_)) => false
  }
}

val ll1 = link(List(1, 2, 3, 4, 5))
val res1 = link(List(3, 4, 5, 1, 2))
assert(pprint.log(compareLinkedList(rearrangeLastN(ll1, 3), res1)) == true)

val ll2 = link(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
val res2 = link(List(7, 8, 9, 10, 1, 2, 3, 4, 5, 6))
assert(pprint.log(compareLinkedList(rearrangeLastN(ll2, 4), res2)) == true)