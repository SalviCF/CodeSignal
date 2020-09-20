def sudoku2(grid: Array[Array[Char]]): Boolean = {
  val rows = grid
  val columns = grid.transpose
  val squares = grid.grouped(3).map(_.transpose).flatMap(_.grouped(3)).map(_.flatten).toArray

  val valid: Array[Char] => Boolean = arr => arr.filter(_ != '.').distinct.length == arr.count(_ != '.')

  rows.map(valid).forall(_ == true) &&
  columns.map(valid).forall(_ == true) &&
  squares.map(valid).forall(_ == true)
}