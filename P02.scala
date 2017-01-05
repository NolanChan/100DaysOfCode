// P02 (*) Find the last but one element of a list.
// Example:
// scala> penultimate(List(1, 1, 2, 3, 5, 8))
// res0: Int = 5

val mainList = List(7, 9,101)
val with4 =    4 :: mainList  // re-uses mainList, costs one :: instance
val with42 =   42 :: mainList // also re-uses mainList, cost one :: instance
val shorter =  mainList.tail  // cost

def penultimate[A](l: List[A]) = {
	if (l.length > 1) l.lastIndexOf(l.length-2)
	else "not long enough for penultimate"
}

println(with42)
println(penultimate(with42))
println(penultimate(List(1)))

