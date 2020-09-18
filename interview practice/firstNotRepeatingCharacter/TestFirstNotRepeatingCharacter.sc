import $file.FirstNotRepeatingCharacter, FirstNotRepeatingCharacter._

assert(pprint.log(firstNotRepeatingCharacter("abacabad")) == 'c')
assert(pprint.log(firstNotRepeatingCharacter("abacabaabacaba")) == '_')
assert(pprint.log(firstNotRepeatingCharacter("z")) == 'z')
assert(pprint.log(firstNotRepeatingCharacter("bcb")) == 'c')
assert(pprint.log(firstNotRepeatingCharacter("bcccccccb")) == '_')
assert(pprint.log(firstNotRepeatingCharacter("abcdefghijklmnopqrstuvwxyziflskecznslkjfabe")) == 'd')
assert(pprint.log(firstNotRepeatingCharacter("zzz")) == '_')
assert(pprint.log(firstNotRepeatingCharacter("bcccccccccccccyb")) == 'y')
assert(pprint.log(firstNotRepeatingCharacter("xdnxxlvupzuwgigeqjggosgljuhliybkjpibyatofcjbfxwtalc")) == 'd')
assert(pprint.log(firstNotRepeatingCharacter("ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof")) == 'g')
