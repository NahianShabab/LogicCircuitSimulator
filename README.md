# Logic Circuit Simulator
**Simulates basic logic gates.
Given a logical circuit description in a text file, it outputs truth table.**

## Code Syntax
`input [input_name]` \
creates an input node labeled *input_name*

`output [output_name]` \
creates an output node labeled *output_name*

`gate [gate_type] [gate_name]` \
creates a gate node of type *gate_type* labeled *gate_name*.
supported types are *and, or, not, xor, xnor, nand, nor*

`connect [src] [target]`\
connects *src*'s output to *target*'s input slot

`# This is a comment`\
comments start with #

## Sample Code
This is a simple code for simulating a full adder

```
# Full Adder Circuit

# inputs
input a
input b
input cin

#outputs
output sum
output cout

# gates
gate xor xor1
gate and and1
gate and and2
gate and and3
gate or or1

# connections
connect a xor1
connect b xor1
connect cin xor1
connect xor1 sum
connect a and1
connect b and1
connect and1 or1
connect a and2
connect cin and2
connect and2 or1
connect cin and3
connect b and3
connect and3 or1
connect or1 cout
#done!
```

Program outputs a truth table: 
```
a       b       cin     ||      sum     cout
============================================
0       0       0       ||      0       0
0       0       1       ||      1       0
0       1       0       ||      1       0
0       1       1       ||      0       1
1       0       0       ||      1       0
1       0       1       ||      0       1
1       1       0       ||      0       1
1       1       1       ||      1       1
============================================
```
