import scala.annotation.tailrec

// Singly-linked lists are already defined with this interface:
 class ListNode[T](x : T) {
   var value: T = x
   var next: Option[ListNode[T]] = None
 }

def rearrangeLastN(l: Option[ListNode[Int]], n: Int): Option[ListNode[Int]] = {
  @tailrec
  def traverse(curr:Option[ListNode[Int]], nBack:Option[ListNode[Int]], last:Option[ListNode[Int]],
               k:Int, size:Int, flag: Boolean): (Option[ListNode[Int]], Option[ListNode[Int]], Int) = {
    (curr, flag) match {
      case (None, _)           => (nBack, last, size)
      case (Some(node), true)  => traverse(node.next, nBack.get.next, curr, k, size+1, flag)
      case (Some(node), false) => if (k == n+1) traverse(node.next, nBack, curr, k, size+1, flag = true)
      else traverse(node.next, nBack, curr, k + 1, size+1, flag)
    }
  }

  if (n == 0) l else {
    val (first, last, size) = traverse(l, l, l, 1, 0, flag = false)
    if (size == n) l else {
      val init = first.get.next
      first.get.next = None
      last.get.next = l
      init
    }
  }
}
