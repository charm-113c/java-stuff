/**
 * Streams in Java are, first and foremost, a paradigm, Java's way to allow a declarative approach (as opposed to an imperative one).
 * Streams per se are data streams, data fluxes on which we can perform (intermediate and terminal) operations. Streams end with a terminal 
 * operation, preceded by one or more intermediate operations. The latter can either be stateful or stateless. Stateless operations can 
 * be parallelizable, and the order in which they are executed does not impact the final result, which is not the case for stateful operations. 
 * Java has a Stream<> interface which allows the declaration of streams. Streams can be built from collections, although they do not modify 
 * the collections they're built from, nor can they be reused once terminated. The data stream is generated lazily, that is to say, 
 * basically just-in-time; they're not created at compile-time, but only when they're actually needed.
 * While streams are generally faster than their imperative counterpart thanks to the paralellization, that's not always the case: when there are
 * too many blocking (read stateful) operators,   
 */

/**
  * Use streams to get the following results (do each exercise with both lambdas and reference to methods)
  * From a List<Title>, compute without using auxiliary data structures (i.e. in one line):
  * 1) The first 5 titles with at most one line
  * 2) The list of titles that are centered, in alphabetical order
  * 3) The map of alignments to list of titles
  * 4) The map of alignments to sets of titles
  * 5) The map of alignments to concatenations of strings of titles
  * 6) The map of alignments to lists of title strings
  * 7) The set of titles, each as a string
  * 8) The map of word counts of words in the title lines calculated above (hint: use flatMap)
    * using Collectors.groupBy
    * using Collectors.toMap 
  */

public class Stream {
    Title t1 = new Title(Alignment.CX);
    t1.add(new Line("Hello from t1", 0));
    t1.add(new Line("Line 1 from t1", 1));
    t1.add(new Line("Line 2from t1", 2));

    Title t2 = new Title(Alignment.DX);
    t2.add(new Line("Hello from t2", 0));
    t2.add(new Line("Line 1 from t2", 1));
    t2.add(new Line("Line 2from t2", 2));

    Title t3 = new Title(Alignment.RX);
    t3.add(new Line("Hello from t3", 0));
    t3.add(new Line("Line 1 from t3", 1));

    Title t4 = new Title(Alignment.CX);
    t4.add(new Line("Hello from t4", 0));
}