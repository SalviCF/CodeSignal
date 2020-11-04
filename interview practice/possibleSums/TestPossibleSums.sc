import $file.PossibleSums, PossibleSums._

assert(pprint.log(possibleSums(Array(10, 50, 100), Array(1, 2, 1))) == 9)
assert(pprint.log(possibleSums(Array(10, 50, 100, 500), Array(5, 3, 2, 2))) == 122)
assert(pprint.log(possibleSums(Array(1), Array(5))) == 5)
assert(pprint.log(possibleSums(Array(1, 1), Array(2, 3))) == 5)
assert(pprint.log(possibleSums(Array(1, 2), Array(50000, 2))) == 50004)