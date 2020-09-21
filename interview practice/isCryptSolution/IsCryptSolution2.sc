def isCryptSolution(crypt: Array[String], solution: Array[Array[Char]]): Boolean = {
  val decrypt: (Char, Array[Array[Char]]) => Char = (c, sol) => (sol.find(_.head == c)).get.last

  val decryptWord: String => String = word => word.map(decrypt(_, solution))

  val (dWord1, dWord2) = (decryptWord(crypt(0)), decryptWord(crypt(1)))

  val invalidInput = (dWord1.startsWith("0") && dWord1.length > 1) || (dWord2.startsWith("0") && dWord2.length > 1)

  if (!invalidInput) {
    val code = dWord1.toLong + dWord2.toLong
    val imageCode = (code.toString.map(c => solution.exists(_.last == c))).forall(_ == true)
    (imageCode && decryptWord(crypt(2)) == code.toString)
  } else false
}
