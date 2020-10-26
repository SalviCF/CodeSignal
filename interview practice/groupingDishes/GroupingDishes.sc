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
  val search: String => Array[String] = i => i +: (for (m <- recipes if m._2.contains(i)) yield m._1).toArray.sorted
  (for (i <- ingredients) yield search(i)).filter(_.length > 2).toArray
}
