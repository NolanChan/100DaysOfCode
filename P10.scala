// P10 (*) Run-length encoding of a list.
// Use the result of problem P09 to implement the so-called run-length encoding data compression method. 
// Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates 
// of the element E.
// Example:

// scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
// res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

def encode(l: List[Any]): List[Any] = l match {
	case List() => List()
	case head +: _ => 
	 val takeList = l.takeWhile(a => (a == head))
	 List(takeList.length, head) +: encode(l.dropWhile(a => (a == head)))
}

assert(List(List(4, 'a), List(1, 'b), List(2, 'c), List(2, 'a), List(1, 'd), List(4, 'e))
 == encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))