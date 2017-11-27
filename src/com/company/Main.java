package com.company;

import java.util.*;

        /*
        1. C

        2. A real world example of a stack is a lunch tray stack. Real world example of a queue is any line for anything

        3. When you push to a stack, that element is on top and when you pop the item it is the first one off

        4. When you add a queue, you are adding the element to the back. When you remove, you remove the front most element

        5. 3

        6. 1

        7. Queue<Integer> q = new LinkedList<Integer>();

        8. Stack<String> stack = new Stack<String>();
           stack.push("hello");
           stack.push("hi");
           stack.push("goodbye");
           stack.push("howdy");

        9. Stack<Integer> stack = new Stack<Integer>();
           for (int i = 100; i >= 0; i -= 2) {
               stack.push(i);
           }

        10. Queue<String> q = new LinkedList<String>();
                q.add("alpha");
                q.add("beta");
                q.add("gamma");
                q.add("delta");

        11. To access the middle elements, you have to remove or pop until you reach them. You should save the other elements you removed so you can use them again

        12. Stacks and queues are very functional because they are simple and because their operations are efficient

        13. The output would look like this:
            [you, are, how]

        14. The output would look like this:
            10
            7
            5
            false
            3
            8
            3

        15. The output would look like this:
            2
            10
            10
            4
            6
            6
            3

        16. The output would look like this:
            a. [1, 1, 6, 6, 2, 2]
            b. [9, 9, 15, 15, 4, 4, -3, -3, 42, 42]
            c. [40, 40, 50, 50, 60, 60, 10, 10, 20, 20, 30, 30]
    */

public class Main {

    public static void main(String[] args) {
	    Stack<Integer> myStack = new Stack<>();
	    Queue<Integer> myQueue = new LinkedList<>();
        myStack.push(2);
        myQueue.add(2);
        myStack.push(-7);
        myQueue.add(-7);
        myStack.push(8);
        myQueue.add(8);
        myStack.push(21);
        myQueue.add(21);
        myStack.push(-32);
        myQueue.add(-32);
        myStack.push(89);
        myQueue.add(89);
        myStack.push(-25);
        myQueue.add(-25);
        myStack.push(31);
        myQueue.add(31);
        myStack.push(72);

        num01(myStack);
    }

    public static void num01(Stack<Integer> stack){
        System.out.println(stack);
        splitStack(stack);
        System.out.println(stack);
    }

    public static void splitStack(Stack<Integer> stack){
        Queue<Integer> auxStorage = new LinkedList<>();

        int negativeNum = 0;

        while(!stack.isEmpty()){
            if(stack.peek() < 0){
                negativeNum ++;
            }
            auxStorage.add(stack.pop());
        }
        while(negativeNum > 0){
            if(auxStorage.peek() < 0){
                negativeNum --;
                stack.push(auxStorage.remove());
            }
            else{
                auxStorage.add(auxStorage.remove());
            }
        }
        while(!auxStorage.isEmpty()){
            stack.push(auxStorage.remove());
        }
    }

    public static void num02(Stack<Integer> stack){
        System.out.println(stack);
        stutter(stack);
        System.out.println(stack);
    }

    public static void stutter(Stack<Integer> stack){
        Queue<Integer> auxStorage = new LinkedList<>();
        while(!stack.isEmpty()){
            auxStorage.add(stack.pop());
        }

        while(!auxStorage.isEmpty()){
            stack.push(auxStorage.remove());
        }

        while (!stack.isEmpty()){
            auxStorage.add(stack.pop());
        }

        while(!auxStorage.isEmpty()){
            int num = auxStorage.remove();
            stack.push(num);
            stack.push(num);
        }
    }

    public static void num03(Stack<Integer> stack){
        System.out.println(stack);
        Stack<Integer> copy = copyStack(stack);
        System.out.println(stack);
        System.out.println(copy);
    }

    public static Stack<Integer> copyStack(Stack<Integer> stack){
        Stack<Integer> copy = new Stack<>();
        Queue<Integer> auxStore = new LinkedList<>();

        while(!stack.isEmpty()){
            auxStore.add(stack.pop());
        }

        while(!auxStore.isEmpty()){
            stack.push(auxStore.remove());
        }

        while (!stack.isEmpty()){
            auxStore.add(stack.pop());
        }

        while(!auxStore.isEmpty()){
            int num = auxStore.remove();
            stack.push(num);
            copy.push(num);
        }
        return copy;
    }

    public static void num04 (Stack<Integer> stack){
        System.out.println(stack);
        collapse(stack);
    }

    public static void collapse(Stack<Integer> stack){
        Queue<Integer> auxStore = new LinkedList<>();

        while(!stack.isEmpty()){
            auxStore.add(stack.pop());
        }

        System.out.println(auxStore);

        while(!auxStore.isEmpty()){
            stack.push(auxStore.remove());
        }

        System.out.println(stack);

        if(stack.size() % 2 == 0){
            while(!stack.isEmpty()){
                auxStore.add(stack.pop() + stack.pop());
            }
        }
        else{
            while(!stack.isEmpty()){
                int n = stack.pop();
                if(!stack.isEmpty()){
                    auxStore.add(n + stack.pop());
                }
                else{
                    auxStore.add(n);
                }
            }
        }
        System.out.println(auxStore);

        while(!auxStore.isEmpty()){
            stack.push(auxStore.remove());
        }
    }

    public static void num05(Stack<Integer> s1, Stack<Integer> s2){
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(equals(s1, s2));
        System.out.println(s1);
        System.out.println(s2);
    }

    public static boolean equals (Stack<Integer> s1, Stack<Integer> s2){
        Stack<Integer> auxStore = new Stack<>();
        boolean isEqual = true;

        if(s1.size() != s2.size()){
            isEqual = false;
        }

        while(!s1.isEmpty()){
            int n1 = s1.pop();
            int n2 = s2.pop();

            auxStore.push(n1);

            if(n1 != n2){
                isEqual = false;
                break;
            }
        }

        while(!auxStore.isEmpty()){
            int n = auxStore.pop();
            s1.push(n);
            s2.push(n);
        }

        return isEqual;
    }

    public static void num08(Queue <Integer> queue){
        System.out.println(isPalindrome(queue));
    }

    public static boolean isPalindrome(Queue<Integer> queue) {
        Stack<Integer> auxStore = new Stack<Integer>();
        int size = queue.size();
        boolean palindrome = true;

        for(int i = 0; i < size; i++) {
            int n = queue.remove();
            queue.add(n);
            auxStore.push(n);
        }

        for(int i = 0; i < size; i++) {
            int n1 = queue.remove();
            int n2 = auxStore.pop();

            if(n1 != n2)
                palindrome = false;

            queue.add(n1);
        }

        return palindrome;
    }

    public static void num09(Stack <Integer> stack){
        switchPairs( stack);
    }

    public static void switchPairs(Stack<Integer> stack) {
        Queue<Integer> auxStore = new LinkedList<Integer>();

        while(!stack.isEmpty())
            auxStore.add(stack.pop());

        while(!auxStore.isEmpty())
            stack.push(auxStore.remove());

        while(!stack.isEmpty()) {
            int n1 = stack.pop();

            if(stack.isEmpty()) {
                auxStore.add(n1);
                break;
            }

            int n2 = stack.pop();
            auxStore.add(n2);
            auxStore.add(n1);
        }

        while(!auxStore.isEmpty())
            stack.push(auxStore.remove());
    }



    public static void num10(){

    }

    public static void num15(Stack <Integer> stack){
        isSorted(stack);
    }

    public static boolean isSorted(Stack <Integer> stack){
        Queue<Integer> auxStore = new LinkedList<>();

        boolean test = true;
        while(!stack.isEmpty()){
            int x = stack.pop();
            auxStore.add(x);
        }
        int x = auxStore.remove();
        while(!auxStore.isEmpty()){
            int y = auxStore.remove();
            if(y > x){
                test = false;
            }
            stack.push(x);
            stack.push(y);
            x = y;
        }

        while (!stack.isEmpty()) {
            auxStore.add(stack.pop());
        }

        while (!auxStore.isEmpty()) {
            stack.push(auxStore.remove());
        }

        return test;
    }

    public static void num20(){

    }

    public static void project01(Queue <Integer> queue){
        primes(queue);
    }

    public static void primes(Queue <Integer> queue){
        Queue<Integer> auxStore = new LinkedList<Integer>();

        while(!queue.isEmpty()){
            int p = queue.remove();
            while(!queue.isEmpty()){
                int next = queue.remove();
                if(next % p != 0){
                    auxStore.add(next);
                }

            }

            while(!auxStore.isEmpty()){
                queue.add(auxStore.remove());
            }

        }
    }
}
