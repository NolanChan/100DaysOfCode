// Eliminate consecutive duplicates of list elements.
// If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
// Example:

// scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
// res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)

def compress(l: List[Any]): List[Any] = {
	l.foldLeft(List(l.head)) { 
		(a,b) => 
			if (b != a.last) a:+b 
			else a
	}
}

// println(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

def compressRecursive(l: List[Any]): List[Any] = l match {
	case List() => List()
	case List(item) => List(item)
	case head +: tail if head == tail.head => compressRecursive(tail.tail)
	case head +: tail => head +: compressRecursive(tail)
}

// ^ this version errors out on a list with a single element so another case had to be put in to check

println(compressRecursive(List('a))) // List('a, 'b)
println(compressRecursive(List('a, 'b))) // List('a, 'b)
println(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
