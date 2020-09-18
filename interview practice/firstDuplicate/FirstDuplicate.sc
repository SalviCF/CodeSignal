def firstDuplicate(a: Array[Int]): Int = {
    def aux(arr: Array[Int], acc: Set[Int]): Int = {
        val elem = arr.head
        if (acc.contains(elem)) elem
        else aux(arr.tail, acc + elem)
    }
    
    aux(a ++ Array(-1, -1), Set())
}