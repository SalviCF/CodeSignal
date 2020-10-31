import $file.ContainsCloseNums, ContainsCloseNums._

val a = Array(0, 1, 2, 3, 5, 2, 3, 1, 0, 6, 1, 5, 6, 1)

assert(pprint.log(containsCloseNums(a, 2)) == false)