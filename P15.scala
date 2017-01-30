// P15 (**) Duplicate the elements of a list a given number of times.
// Example:
// scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
// res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

def duplicateN[A](i: Int, l: List[A]): List[A] = l flatMap (e => List.fill(i)(e))

println(duplicateN(3, List('a, 'b, 'c, 'c, 'd)))

// answer uses Object method `make` but I can't find it in the docs. `fill` works equally well

