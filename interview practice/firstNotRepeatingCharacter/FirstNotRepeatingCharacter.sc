def firstNotRepeatingCharacter(s: String): Char = {
    val distinct = s.distinct           
    val repeated = s diff distinct
    val nonRepeated = distinct diff repeated
    
    if (nonRepeated.isEmpty) '_'
    else nonRepeated.head
}