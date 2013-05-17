## Java Heap

### Overview
This is a simple implementation of a Heap. This simply uses an ArrayList coupled with recursion.

### Why
The main use for this tool is if you have to bootup or shutdown a network
in a particular order (example shutdown sequence: workstations then servers then 
domain controller then raids then switches). Simply ping each piece of hardware 
and decide what needs to be done accordingly.

### Use
Since the method is static, simply use the following call where `host` is a string with
the name or IP address of the machine you're trying to reach.
```java
Ping.isReachable(host);
```
If the machine is reachable, it will return true; else it will return false.

### How it works
This tool executes the ping command piped with find. It basically parses out the 
ping and looks for TTL. If TTL is present, we know the machine has been reached, else
it is not reachable.