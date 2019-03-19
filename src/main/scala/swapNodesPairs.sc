// Given a linked list, swap every two adjacent nodes and return its head.
// Example
// Given 1->2->3->4, you should return the list as 2->1->4->3.


/**
  * Definition for singly-linked list.
  * class ListNode(var _x: Int = 0) {
  * var next: ListNode = null
  * var x: Int = _x
  * }
  */

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  def swapPairs(head: ListNode): ListNode = {
    if (head.next != null) {
      val temp = head.next.next
      head.next.next = head
      head.next = temp
      swapPairs(head.next.next)
    }
    else
      head
  }
}

val node1 = new ListNode(1)
val node2 = new ListNode(2)
node1.next = node2

