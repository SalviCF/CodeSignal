import $file.ReverseNodesInKGroups, ReverseNodesInKGroups._
import scala.annotation.tailrec

def link(l: List[Int]): Option[ListNode[Int]] = {
  l match {
    case Nil  =>  None
    case x+:xs => val n = Option(new ListNode(x))
      n.get.next = link(xs)
      n
  }
}

@tailrec
def compare(xs: Option[ListNode[Int]], ys: Option[ListNode[Int]]): Boolean = {
  (xs, ys) match {
    case (None, None)       => true
    case (Some(_), None)    => false
    case (None, Some(_))    => false
    case (Some(x), Some(y)) => if (x.value == y.value) compare(x.next, y.next) else false
  }
}

val ll = link(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
val res = link(List(3, 2, 1, 6, 5, 4, 9, 8, 7, 10, 11))

assert(pprint.log(compare(reverseNodesInKGroups(ll, 3), res)) == true)

