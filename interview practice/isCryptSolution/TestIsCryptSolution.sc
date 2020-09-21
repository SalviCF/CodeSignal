import $file.IsCryptSolution, IsCryptSolution._

assert(pprint.log( isCryptSolution(Array("SEND",
                                         "MORE",
                                         "MONEY"),
                                   Array(Array('O','0'),
                                         Array('M','1'),
                                         Array('Y','2'),
                                         Array('E','5'),
                                         Array('N','6'),
                                         Array('D','7'),
                                         Array('R','8'),
                                         Array('S','9')))) == true)