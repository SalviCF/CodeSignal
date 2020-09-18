import $file.FirstDuplicate, FirstDuplicate._

// It is not allowed that filename and function have thesame name
// execute using: amm TestFirstDuplicate.sc

assert(pprint.log(firstDuplicate(Array(2, 1, 3, 5, 3, 2))) == 3)
assert(pprint.log(firstDuplicate(Array(2, 2))) == 2)
assert(pprint.log(firstDuplicate(Array(2, 4, 3, 5, 1))) == -1)
assert(pprint.log(firstDuplicate(Array(1))) == -1)
assert(pprint.log(firstDuplicate(Array(5, 5, 5, 5, 5))) == 5)
assert(pprint.log(firstDuplicate(Array(2, 1))) == -1)
assert(pprint.log(firstDuplicate(Array(2, 1, 3))) == -1)
assert(pprint.log(firstDuplicate(Array(2, 3, 3))) == 3)
assert(pprint.log(firstDuplicate(Array(3, 3, 3))) == 3)
assert(pprint.log(firstDuplicate(Array(8, 4, 6, 2, 6, 4, 7, 9, 5, 8))) == 6)
assert(pprint.log(firstDuplicate(Array(10, 6, 8, 4, 9, 1, 7, 2, 5, 3))) == -1)
assert(pprint.log(firstDuplicate(Array(1, 1, 2, 2, 1))) == 1)

