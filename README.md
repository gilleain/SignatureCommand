# SignatureCommand
Command line application for creating signatures from graphs

# Usage
Given a simple graph such as the path on 4 vertices like:

`0:1,1:2,2:3` 

we can find the maximal signature like:

`java -jar <jarfile> -c 0:1,1:2,2:3`

which will give:

```
Canonical Signature:
[.]([.]([.]([.])))  
```

## Symmetry classes
The symmetry classes of a graph can also be calulated with the `-s` flag. The height of the signatures used to label the classes can optionally be provided using `-h`. For example: 

`java -jar <jarfile> -s -h 2 "0:1,0:6,0:7,1:2,1:8,2:3,2:8,3:4,3:9,4:5,4:9,5:6,5:10,6:10,7:8,7:11,9:11,10:11"`

gives the symmetry classes of height 2 for the Frucht graph:

```
[0, 7] [.]([.]([.][.])[.]([.][.,0])[.]([.][.,0]))
[1, 8] [.]([.]([.][.,0])[.]([.][.,1])[.,1]([.,0]))
[2, 3, 4, 5, 6, 9, 10] [.]([.]([.][.])[.]([.][.,0])[.,0]([.]))
[11] [.]([.]([.][.])[.]([.][.])[.]([.][.]))
```

where the numbers in brackets are the members of the class, with the class signature following.
