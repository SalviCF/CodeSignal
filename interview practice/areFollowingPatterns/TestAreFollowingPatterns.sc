import $file.AreFollowingPatterns, AreFollowingPatterns._

val strings = Array("ato",
                    "ato",
                    "jflywws",
                    "ato",
                    "ato",
                    "se",
                    "se",
                    "kiolm",
                    "wizdkdqke")
val patterns = Array("ofnmiqelt",
                    "ofnmiqelt",
                    "flqmwoje",
                    "ofnmiqelt",
                    "zdohw",
                    "jyk",
                    "ujddjtxt",
                    "s",
                    "kw")

assert(pprint.log(areFollowingPatterns(strings, patterns)) == false)