Jeometry
========

A Java math library with an emphasis on geometry. It provides

- a variety of geometric primitives: vectors, polygons, etc.
- transformations such as rotations
- methods for generating bounding volumes
- methods for intersection testing

and so forth. It is designed with graphics and physics applications in mind.

All storage and computation currently uses (32 bit) float encoding. I may add options later for (64 bit) double encoding.


Coordinate System
-----------------

Joemetry assumes a right-handed coordinate system for operations such as cross products. Although orientation conventions are mixed (particularly in graphics), right-handedness is generally preferred in most fields.


Installation
------------

I plan to distribute this through maven, but haven't published any artifacts yet.

Java 8 is required to compile and run the code.

