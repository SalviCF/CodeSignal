import scala.annotation.tailrec

def groupingDishes(dishes: Array[Array[String]]): Array[Array[String]] = {
  @tailrec
  def menu(dishes: Seq[Array[String]], recipes: Map[String, Seq[String]], ingredients: List[String]):
  (Map[String, Seq[String]], List[String]) = {
    dishes match {
      case Seq() => (recipes, ingredients.distinct.sorted)
      case Seq(Array(d, di @ _*), xs @ _*) => menu(xs, recipes + (d -> di), ingredients ++ di)
    }
  }

  val (recipes, ingredients) = menu(dishes, Map(), Nil)
  //val search: String => Array[String] = i => i +: recipes.filter(_._2.contains(i)).keys.toArray.sorted
  val search: String => Array[String] = i => i +: (for (r <- recipes if r._2.contains(i)) yield r._1).toArray.sorted
  //ingredients.map(search(_)).filter(_.length > 2).toArray
  (for (i <- ingredients) yield search(i)).filter(_.length > 2).toArray
  //https://docs.scala-lang.org/tutorials/FAQ/yield.html
}
