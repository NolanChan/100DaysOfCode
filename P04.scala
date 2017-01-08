// P04 (*) Find the number of elements of a list.
// Example:
// scala> length(List(1, 1, 2, 3, 5, 8))
// res0: Int = 6

def length[A](l: List[A]): Int = {
	l.length
}

println(length(List(1,2,3,4)))

// gotta learn how to do recursion some time or another
// Thanks http://stackoverflow.com/documentation/scala/661/pattern-matching#t=201701080613186646654 !

def lengthRecursive[A](l: List[A]): Int = l match {
	case first +: tail => 1 + lengthRecursive(tail)
	case List() => 0
	case _ => -1
}

println(lengthRecursive(List(1,2,3,4)))

def lengthFunctional[A](ls: List[A]): Int = ls.foldLeft(0) { (c, _) => c + 1 }

println(lengthFunctional(List(1,2,3,4,5)))


// fooling around

def foldLeftExampleSum(l: List[Int]): Int = l.foldLeft(0) 
	{ (a,b) => 
		println("a is " + a);
		println("b is " + b);
		println("---")
		a + b
	}

println(foldLeftExampleSum(List(7,4,2)))