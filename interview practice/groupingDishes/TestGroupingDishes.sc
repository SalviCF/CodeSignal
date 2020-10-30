import $file.GroupingDishes, GroupingDishes._
import scala.annotation.tailrec

val input = Array(
              Array("Salad","Tomato","Cucumber","Salad","Sauce"),
              Array("Pizza","Tomato","Sausage","Sauce","Dough"),
              Array("Quesadilla","Chicken","Cheese","Sauce"),
              Array("Sandwich","Salad","Bread","Tomato","Cheese"),
            )

val expected = Array(
                Array("Cheese","Quesadilla","Sandwich"),
                Array("Salad","Salad","Sandwich"),
                Array("Sauce","Pizza","Quesadilla","Salad"),
                Array("Tomato","Pizza","Salad","Sandwich")
               )

@tailrec
def compareDishes(d1: Array[Array[String]], d2: Array[Array[String]]): Boolean = {
  (d1, d2) match {
    case (Array(), Array()) => true
    case (Array(x, _*) , Array(y, _*)) => if (x.sameElements(y)) compareDishes(d1.tail, d2.tail)
                                          else false
  }
}

assert(pprint.log(compareDishes(groupingDishes(input), expected)) == true)
