# ShopStream

5-week hands-on plan: Java, Spring Boot, microservices, and concurrency.
Started: Nov 5, 2026

## Progress
- [x] Day 1: setup, records, threads, sleep()
## Day 2 (Fri, Nov 6)

### Track A: Build
- A List (ArrayList) stores objects in order. I loop over it with for-each.
- findById loops through the list and returns the matching Product.
- null means "no object". findById returns null when nothing matches.
- Calling a method on null throws NullPointerException (I traced it with the debugger).
- Always use accessors (product.id()), not direct field access (product.id).
- Avoid magic numbers: use a named constant like LOW_STOCK_LIMIT.

### Track B: join()
- join() makes the calling thread wait until that one thread finishes.
- join() waits only for the thread I call it on.
- Without join(), main keeps going and its "done" message can be wrong.
- To wait for several threads: start them all first, then join() each one.
- join() right after start() makes threads run one after another (no parallelism).
- Sleep inside the loop vs after the loop changes the timing completely.
- The JVM exits when all non-daemon threads finish, not when main stops waiting.