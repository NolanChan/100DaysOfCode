// P16 (**) Drop every Nth element from a list.
// Example:
// scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
// res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

// ugly non-functional version, although it does seem a lot simpler

// def drop[A](d: Int, l: List[A]): List[A] = {
// 	var newList: List[A] = List()
// 	for (i <- 1 to l.length) {
// 		if (i%d != 0) newList = newList :+ l(i-1)
// 	} 
// 	newList
// }


//println(drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

// tail recurisve version

def drop[A](d: Int, l: List[A]): List[A] = {
	def dropRecursive[A](counter: Int, l: List[A], answer: List[A]): List[A] = (counter,l) match {
		case (_ ,List()) => answer
		case (counter, l) if counter == 1 => dropRecursive(d, l.tail, answer)
		case (_ , _) => dropRecursive(counter - 1, l.tail, answer :+ l.head)
	}
	dropRecursive(d, l, List())
}

// case empty return list()
// case if d == 1 skip and reduce element
// case else add on element

// functional

println(drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

// practicing zipWithIndex and filter with two variables
println(List('a, 'b, 'c).zipWithIndex filter (e => e._2 == 1) flatMap (e => List(e._1)))

def dropFunctional[A](d: Int, l: List[A]) = 
	l.zipWithIndex filter (e => (e._2 + 1) % d != 0) map (_._1)

println(dropFunctional(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))	
