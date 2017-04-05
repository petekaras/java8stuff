# Examples

## Streams

[Aggregate operations](./src/test/java/AggregateOperationsTest.java) filter, map, reduce, find, match, sorted

- collect(): no work is done before collect is invoked
- source: the source of a stream is a collection, array or I/O source
- pipeline: many stream functions return a stream, so they can be chained
