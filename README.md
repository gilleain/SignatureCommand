# SignatureCommand
Command line application for creating signatures from graphs

# Usage
Given a simple graph such as the path on 4 vertices like:

`0:1,1:2,2:3` 

we can find the maximal signature like:

`java -jar <jarfile> -c 0:1,1:2,2:3`

which will give:

> Canonical Signature:
> [.]([.]([.]([.])))  

## Symmetry classes
The symmetry classes of a graph can also be calulated with the `-s` flag. The height of the signatures used to label the classes can optionally be provided using `-h`.
