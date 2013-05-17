## Java Heap

### Overview
This is a implementation of a Heap in Java that uses an ArrayList coupled with recursion. 

### Why
Give insight to new users of Java who are trying to learn data structures.

### Use
First create a heap object:
```java
Heap h = new Heap();
```

Once the object has been instantiated, you can insert and delete:
```java
h.insert(TreeNode node);
h.delete();
h.printTree();
```

Deleting simply returns the max node.