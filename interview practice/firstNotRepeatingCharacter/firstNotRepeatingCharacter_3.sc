def firstNotRepeatingCharacter(s: String): Char = {
    def aux(st: Seq[Char], seen: Set[Char]): Char = st match {       
        case Seq() => '_'
        case Seq(x, xs@_*) => if (!xs.contains(x) && !seen.contains(x)) x
                              else aux(xs, seen + x) 
    }  
    aux(s.toSeq, Set())
}