import unittest

# 1. Find a given number num in a sorted array arr:
# arr = [2, 4, 5, 9, 12, 17] 

# 2. If the sorted array arr is shifted left by an unknown offset and you don't have 
# a pre-shifted copy of it, how would you modify your method to find a number in the shifted array?
# shiftArr = [9, 12, 17, 2, 4, 5]

def BinarySearch(arr, num):
	start = 0
	end = len(arr)
	while (start <= end):
		mid = (start+end)/2
		if arr[mid] == num:
			return mid
		elif arr[mid] > num:
			end = mid
		else:
			start = mid +1
	return -1

# go through the array using binary search
# if num in array is less than head, end = that position
# if num in array is greater than head, start = that position

def LeftOffsetFinder(arr):
	head = arr[0]
	start = 0
	end = len(arr) - 1
	while (start < len(arr)):
		mid = (start + end)/2
		if arr[mid] < head:
			end = mid
		elif arr[mid] > head: 
			start = mid + 1
		if arr[mid] < arr[mid -1]:
			return mid
	return 0

# get offset
# if num is greater than list-end-number, do binary search on subset 1, else subset 2
# if subset 1 is chosen, then position is returned value
# if subset 2 is chosen, then returned value + offset

def BinarySearchOffset(arr, num):
	offset = LeftOffsetFinder(arr)
	if (num > arr[-1]):
		return BinarySearch(arr[0:offset], num)
	else:
		return BinarySearch(arr[offset:], num) + offset


class Test(unittest.TestCase):

	def test_example(self):
   		self.assertEqual(1,1)

   	def test_BinarySearchOffsetTest(self):
   		# print("Binary Search Offset")
   		self.assertEqual(5, BinarySearchOffset([3,4,5,6,1,2], 2))
   		self.assertEqual(0, BinarySearchOffset([2,3,4,5,6,1], 2))
   		self.assertEqual(1, BinarySearchOffset([1,2,3,4,5,6], 2))

   	def test_LeftOffsetFinder(self):
		self.assertEqual(4, LeftOffsetFinder([3,4,5,6,1,2]))
		self.assertEqual(5, LeftOffsetFinder([2,3,4,5,6,1]))
		self.assertEqual(0, LeftOffsetFinder([1,2,3,4,5,6])) 

	def test_BinarySearch(self):
		self.assertEqual(0, BinarySearch([10,11,12,13,14,15,16,17,18,19],10))
		self.assertEqual(1, BinarySearch([10,11,12,13,14,15,16,17,18,19],11))
		self.assertEqual(2, BinarySearch([10,11,12,13,14,15,16,17,18,19],12))
		self.assertEqual(3, BinarySearch([10,11,12,13,14,15,16,17,18,19],13))
		self.assertEqual(4, BinarySearch([10,11,12,13,14,15,16,17,18,19],14))
		self.assertEqual(5, BinarySearch([10,11,12,13,14,15,16,17,18,19],15))
		self.assertEqual(6, BinarySearch([10,11,12,13,14,15,16,17,18,19],16))
		self.assertEqual(7, BinarySearch([10,11,12,13,14,15,16,17,18,19],17))
		self.assertEqual(8, BinarySearch([10,11,12,13,14,15,16,17,18,19],18))
		self.assertEqual(9, BinarySearch([10,11,12,13,14,15,16,17,18,19],19))


if __name__ == '__main__':
    unittest.main()



