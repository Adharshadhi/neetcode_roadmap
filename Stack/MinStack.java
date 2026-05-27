package Stack;

import java.util.Stack;

public class MinStack {
    // Problem Statement
    // Design a stack class that supports the push, pop, top, and getMin operations.
    // MinStack() initializes the stack object.
    // void push(int val) pushes the element val onto the stack.
    // void pop() removes the element on the top of the stack.
    // int top() gets the top element of the stack.
    // int getMin() retrieves the minimum element in the stack.
    // Each function should run in O(1) time.

    // Example 1:

    // Input: ["MinStack", "push", 1, "push", 2, "push", 0, "getMin", "pop", "top",
    // "getMin"]

    // Output: [null,null,null,null,0,null,2,1]

    // Explanation:
    // MinStack minStack = new MinStack();
    // minStack.push(1);
    // minStack.push(2);
    // minStack.push(0);
    // minStack.getMin(); // return 0
    // minStack.pop();
    // minStack.top(); // return 2
    // minStack.getMin(); // return 1

    // Constraints:
    // -2^31 <= val <= 2^31 - 1.
    // pop, top and getMin will always be called on non-empty stacks.

    // Approach is to use two stacks one for the main stack and the other for the
    // minimum values in the main stack
    Stack<Integer> mainStack;
    Stack<Integer> minimumStack;

    // Initialize the main stack and the minimum stack
    public MinStack() {
        mainStack = new Stack<>();
        minimumStack = new Stack<>();
    }

    // When we push a value to the main stack we check if the minimum stack is empty
    // or
    // if the value is less than or equal to the last inserted minimum value, if it
    // is, we push it to the minimum stack as well
    public void push(int val) {
        this.mainStack.push(val);
        if (minimumStack.isEmpty()) {
            this.minimumStack.push(val);
        } else {
            // equal to is important since we can have multiple (duplicate) minimum values
            // in the stack
            // and we want to keep track of all of them
            if (val <= minimumStack.peek()) {
                this.minimumStack.push(val);
            }
        }
    }

    // When we pop a value from the main stack we check if it is equal to the last
    // inserted minimum value, if it is, we pop it from the minimum stack as well
    public void pop() {
        if (mainStack.peek().equals(minimumStack.peek())) {
            this.minimumStack.pop();
        }
        this.mainStack.pop();
    }

    public int top() {
        return this.mainStack.peek();
    }

    public int getMin() {
        return this.minimumStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        System.out.println(minStack.getMin()); // return 0
        minStack.pop();
        System.out.println(minStack.top()); // return 2
        System.out.println(minStack.getMin()); // return 1
    }
}
