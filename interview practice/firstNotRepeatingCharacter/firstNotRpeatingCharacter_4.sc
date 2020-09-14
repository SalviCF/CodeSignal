def firstNotRepeatingCharacter(s: String): Char = {
    val notRepeated = for (c <- s if s.indexOf(c) == s.lastIndexOf(c)) yield c
    if (!notRepeated.isEmpty) notRepeated.head
    else '_'
}