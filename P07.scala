// P07 (**) Flatten a nested list structure.
// Example:
// scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
// res0: List[Any] = List(1, 1, 2, 3, 5, 8)

def flatten(l: List[Any]): List[Any] = l match {
	case List(i @ _*) :: j => flatten(i ++: j)
	case i :: j => i+:flatten(j)
	case _ => List()
}

// The problem is that you want to flatten lists, but you can't return lists inside the list
// Question: What does the type thing do for scala methods: flatten[A] vs flatten
// Question: why does i:::j return a seq in: List(List(i @ _*), j @ _*) => i:::j

// ++: is crucial because it uses the type of the righthand operand as the type of the returned expression

println(flatten(List(List("hi", "hi2"), "bye", List("mid"))))

for (i <- List(1,2,3,4)){
	println(i)
}