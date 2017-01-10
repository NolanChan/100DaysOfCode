// P06 (*) Find out whether a list is a palindrome.
// Example:
// scala> isPalindrome(List(1, 2, 3, 2, 1))
// res0: Boolean = true

def reverseFunction[A](l: List[A]): List[A] = l.foldLeft(List[A]()) { (a,b) => b+:a }

def isPalindrome[A](l: List[A]): Boolean = l == l.reverse

println(isPalindrome(List(1,2,3,4,4,3,2)))