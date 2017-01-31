// P17 (*) Split a list into two parts.
// The length of the first part is given. Use a Tuple for your result.
// Example:

// scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
// res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

def split[A](i: Int, l: List[A]) = l.splitAt(i)

def splitRec[A](i: Int, l: List[A]) = {
	def splitHelper[A](counter: Int, front: List[A], back: List[A]): (List[A], List[A]) = counter match {
		case 0 => (front, back)
		case _ => splitHelper(counter - 1, front :+ back.head, back.tail)
	}
	splitHelper(i, List(), l)
}

println(split(3, List(1,2,3,4,5,6,7)))
println(splitRec(3, List(1,2,3,4,5,6,7)))