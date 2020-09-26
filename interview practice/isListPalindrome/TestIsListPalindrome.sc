import $file.IsListPalindrome, IsListPalindrome._

val a = Option(new ListNode[Int](1))
val b = Option(new ListNode[Int](0))
val c = Option(new ListNode[Int](1))

a.get.next = b
b.get.next = c
c.get.next = None

assert(pprint.log(isListPalindrome(a)) == true)