package dsa.tasks;

import java.util.NoSuchElementException;

class QueueNode<T> {
 T data;
 QueueNode<T> next;

 public QueueNode(T data) {
     this.data = data;
     this.next = null;
 }
}

public class Queue<T> {

 private QueueNode<T> front; 
 private QueueNode<T> rear;  
 private int size;           

 public Queue() {
     front = null;
     rear = null;
     size = 0;
 }

 public void enqueue(T data) {
     QueueNode<T> newNode = new QueueNode<>(data);
     if (isEmpty()) {
         front = newNode;
     } else {
         rear.next = newNode;
     }
     rear = newNode;
     size++;
 }

 public T dequeue() {
     if (isEmpty()) {
         throw new NoSuchElementException("Queue is empty. Cannot dequeue.");
     }
     T data = front.data;
     front = front.next;
     if (front == null) {
         rear = null;
     }
     size--;
     return data;
 }

 public T peek() {
     if (isEmpty()) {
         throw new NoSuchElementException("Queue is empty. Cannot peek.");
     }
     return front.data;
 }

 public boolean isEmpty() {
     return size == 0;
 }

 public int size() {
     return size;
 }

 public static void main(String[] args) {
     Queue<Integer> queue = new Queue<>();

     queue.enqueue(10);
     queue.enqueue(20);
     queue.enqueue(30);

     System.out.println("Queue size: " + queue.size()); 
     System.out.println("Queue elements:");
     while (!queue.isEmpty()) {
         System.out.println(queue.dequeue());
     }
     queue.enqueue(40);
     queue.enqueue(50);

     System.out.println("Front element: " + queue.peek()); 
 }
}