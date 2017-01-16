// P09 (**) Pack consecutive duplicates of list elements into sublists.
// If a list contains repeated elements they should be placed in separate sublists.
// Example:

// scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
// res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

// def pack(l: List[Any]): List[Any] = {
// 	def recursivePack(l: List[Any], repeat: List[Any]): List[Any] = l match {
// 		case head +: tail if head == tail.head => recursivePack(l.tail, repeat:+head)
// 		case head +: tail => (repeat:+head) +: recursivePack(l.tail, List())
// 		case _ => List()
// 	}
// 	recursivePack(l, List())
// }

// println(pack(List('a')))

// O(n) time, though it requires two passes through the array instead of one
def pack(l: List[Any]): List[Any] = l match {
	case List() => List()
	case head +: _ => l.takeWhile(a => (a == head)) +: pack(l.dropWhile(a => (a == head)))
}

// One can also use the less verbose span method, but it's basically doing the same thing (just more functionally)

assert(pack(List(1,1,1,1,1,2,3,4,5,5,5,5)) == List(List(1, 1, 1, 1, 1), List(2), List(3), List(4), List(5, 5, 5, 5))
)