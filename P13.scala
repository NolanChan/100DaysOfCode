// P13 (**) Run-length encoding of a list (direct solution).
// Implement the so-called run-length encoding data compression method directly. 
// I.e. don't use other methods you've written (like P09's pack); do all the work directly.
// Example:

// scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
// res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

def encodeDirect(l: List[Any]): List[Any] = l match {
	case List() => List()
	case _ => 
		val (duplicate, tail) = l.span(a => a == l.head)
		List(duplicate.length, l.head) +: encodeDirect(tail)
		// List(split.head.length, split.head) +: encodeDirect(split.last)
}

println(encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
	


// The span method lets you split a stream into two parts, by providing a function that detects the dividing line where you want the split to occur. What this doesn’t let you do is to sift through the stream and move each record into the a or b side – you can’t use this to separate even and odd numbers, for instance.

// Example:

// scala> var (a, b) = Stream.from(1).span(_ < 10)
// a: scala.collection.immutable.Stream[Int] = Stream(1, ?)
// b: scala.collection.immutable.Stream[Int] = Stream(10, ?)

// To show that the even/odd filtering doesn’t work, see the example below. Since the first element is “1” (odd) it automatically goes to the “b” side, and you get an empty list for “a”.

// scala> var (a, b) = Stream.from(1).span(_ % 2 == 0)
// a: scala.collection.immutable.Stream[Int] = Stream()
// b: scala.collection.immutable.Stream[Int] = Stream(1, ?)