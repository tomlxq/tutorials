package www.tom.stringbuilderstringbuffer;

/**
 * StringBuffer is synchronized and therefore thread-safe. StringBuilder is compatible with StringBuffer API but with no guarantee of synchronization.
 * Because it's not a thread-safe implementation, it is faster and it is recommended to use it in places where there's no need for thread safety.
 * Simply put, the StringBuffer is a thread-safe implementation and therefore slower than the StringBuilder.
 *
 * In single-threaded programs, we can take of the StringBuilder. Yet, the performance gain of StringBuilder over StringBuffer may be too small to justify replacing it everywhere. It's always a good idea to profile the application and understand its runtime performance characteristics before doing any kind of work to replace one implementation with another.
 *
 * @author TomLuo
 * @date 2020/1/22
 */
public class StringBuilderStringBuffer {
    /**
     * ven though it may look like that we're modifying the same object by appending “def”,
     * we are creating a new one because String instances can't be modified.
     */
    public void immutableString() {
        String immutable = "abc";
        immutable = immutable + "def";
    }

    /**
     * In this case, there was no new object created. We have called the append() method on sb instance and modified its content.
     * StringBuffer and StringBuilder are mutable objects.
     */
    public void mutableString() {
        StringBuffer sb = new StringBuffer("abc");
        sb.append("def");
    }
}
