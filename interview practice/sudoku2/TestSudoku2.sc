import $file.Sudoku2, Sudoku2._

assert(pprint.log(
  sudoku2(
    Array(
      Array('.','.','.','1','4','.','.','2','.'),
      Array('.','.','6','.','.','.','.','.','.'),
      Array('.','.','.','.','.','.','.','.','.'),
      Array('.','.','1','.','.','.','.','.','.'),
      Array('.','6','7','.','.','.','.','.','9'),
      Array('.','.','.','.','.','.','8','1','.'),
      Array('.','3','.','.','.','.','.','.','6'),
      Array('.','.','.','.','.','7','.','.','.'),
      Array('.','.','.','5','.','.','.','7','.')
    )
  )
) == true)