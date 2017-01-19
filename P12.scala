// P12 (**) Decode a run-length encoded list.
// Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
// Example:

// scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
// res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)


// way too many areas with way too many things unknown. I need to read this part of the book before I try
// to do matching with multiple types and recurion

// def decode(l: List[(Int,Any)]): List[Any] = l match {
// 	case Nil => List()
// 	case head +: tail => 
// 		head.head +: decode(tail)
// 	case _ => List()
// }

// /Users/nolanchan/Code/99ProblemsInScala/P12.scala:12: error: value head is not a member of (Int, Any)
// 		head.head +: decode(tail)

// /Users/nolanchan/Code/99ProblemsInScala/P12.scala:11: warning: fruitless type test: a value of type (Int, Any) cannot also be a List[A]
// 	case List(a,b) :: tail => List(a,b) ++ decode(tail)

// scala.MatchError: List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)) (of class scala.collection.immutable.$colon$colon)


// http://stackoverflow.com/questions/9785655/why-doesnt-passing-nil-to-foldleft-work
// This post helped to discover part of my type inference problems...I really need to read the book

def decodeFunctional[A](l: List[(Int, A)]): List[A] = {
	l.foldLeft(List[A]()) {(a,b) => a ++ List().padTo(b._1, b._2)}
}

println(decodeFunctional(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))

// /Users/nolanchan/Code/99ProblemsInScala/P12.scala:29: error: type mismatch;
//  found   : List[Char]
//  required: List[Nothing]
// 	l.foldLeft(List()) {(a,b) => List().padTo(4, 'a')}

def decode[A](ls: List[(Int, A)]): List[A] =
    ls flatMap { e => List().padTo(e._1, e._2) }

println(decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))