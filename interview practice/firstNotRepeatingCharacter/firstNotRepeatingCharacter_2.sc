def firstNotRepeatingCharacter(s: String): Char = {
    def aux(st: String, seen: Set[Char]): Char = {
        val elem = st.head
        val rest = st.tail
        if (!rest.contains(elem) && !seen.contains(elem)) elem
        else aux(rest, seen + elem) 
    }  
    aux(s :+ '_', Set())
}