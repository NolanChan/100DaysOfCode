// P05 (*) Reverse a list.
// Example:
// scala> reverse(List(1, 1, 2, 3, 5, 8))
// res0: List[Int] = List(8, 5, 3, 2, 1, 1)

def reverseList[A](l: List[A]):List[A] = l.reverse

println(reverseList(List(1,2,3)))

def reverseRecursive[A](l: List[A]):List[A] = l match {
	case init :: last => 
		println(init)
		println(last)
		println("---")
		reverseRecursive(last) :+ init
	case _ => List()
}

def reverseTailRecursive[A](l: List[A]):List[A] = {
	def reverseRecursiveHelper[A](result: List[A], curList: List[A]): List[A] = curList match {
		case head :: last => reverseRecursiveHelper(head :: result, last)
		case _ => result
	}
	reverseRecursiveHelper(List(), l)
}

println(reverseRecursive(List(9,8,7)))

println(reverseTailRecursive(List(5,6,7)))

println("\nreverse function\n")

def reverseFunction[A](l: List[A]): List[A] = l.foldLeft(List[A]()) 
	{ (a,b) => 
		println(a)
		println(b)
		println("---")
		b+:a
	}

println(reverseFunction(List(11,12,13)))


