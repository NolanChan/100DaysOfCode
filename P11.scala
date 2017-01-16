// P11 (*) Modified run-length encoding.
// Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
// Example:

// scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
// res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))


// originally forgot to include the match and got all these weird type errors...

def encodeModified(l: List[Any]): List[Any] = l match {
	case List() => List()
	case head +: _ => 
		val takeList = l.takeWhile(_ == head)
		if (takeList.length == 1)
			head +: encodeModified(l.dropWhile(_ == head))
		else
			List(takeList.length, head) +: encodeModified(l.dropWhile(_ == head))
}

println(encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))