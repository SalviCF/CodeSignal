def firstDuplicate(a: Array[Int]): Int = {
    def aux(list: List[Int], acc: Set[Int]): Int = list match {
        case Nil => -1
        case x::xs => if (acc.contains(x)) x
                      else aux(xs, acc + x)  
    }
    
    aux(a.toList, Set())
}