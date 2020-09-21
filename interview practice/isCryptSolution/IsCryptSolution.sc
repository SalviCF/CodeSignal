import scala.annotation.tailrec

def isCryptSolution(crypt: Array[String], solution: Array[Array[Char]]): Boolean = {
  @tailrec
  def decrypt(letter: Char, solution: Array[Array[Char]]): Char = {
    val pair = solution.head
    if (pair.head == letter) pair.last
    else decrypt(letter, solution.tail)
  }

  val decryptWord: String => String = word => word.map(decrypt(_, solution))
  val (word1, word2, word3) = (crypt(0), crypt(1), crypt(2))
  val dWord1 = decryptWord(word1)
  val dWord2 = decryptWord(word2)
  val invalidInput = (dWord1.startsWith("0") && dWord1.length > 1) || (dWord2.startsWith("0") && dWord2.length > 1)

  if (!invalidInput) {
    val code = dWord1.toLong + dWord2.toLong
    val imageCode = (code.toString.map(n => solution.exists(_.last == n))).forall(_ == true)
    (imageCode && decryptWord(word3) == code.toString)
  } else false
}
