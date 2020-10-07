import $file.MergeTwoLinkedLists, MergeTwoLinkedLists._
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

val ll1 = link(List(1, 1, 2, 4))
val ll2 = link(List(0, 3, 5))
val res = link(List(0, 1, 1, 2, 3, 4, 5))

assert(pprint.log(compare(mergeTwoLinkedLists(ll1, ll2), res)) == true)