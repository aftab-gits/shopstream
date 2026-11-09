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

## Day 3 (Sat, Nov 7)

### Track A: Optional
- Optional is a box that may or may not hold a value. The box itself is never null.
- Check isPresent() (or isEmpty()), not != null.
- Optional.get() on an empty Optional throws NoSuchElementException. Never call get() without checking.
- ifPresentOrElse runs one block if a value is there and another if not.
- map + orElse transforms the value if present, otherwise gives a fallback (no if needed).
- For an API, use orElseThrow when "not found" is an error. It becomes a 404 later in Spring Boot.
- findById and findByName return Optional<Product> instead of null.

### Track B: Race condition
- counter++ is 3 steps: read, increment, write.
- If both threads read the same value, both write the same result, so one update is lost.
  Example: both read 10, both write 11, expected 12.
- My results (expected 20000 with 10000 per thread): 15424, 13926, 16981, 20000, 13209. Different every run.
- With 1000 iterations I got 2000 every time. The loop finishes within one time slice (or before the other thread starts), so the threads never overlap.
- Small workloads hide race conditions. More iterations means more overlap and more lost updates.
- A correct result on one run doesn't prove the code is thread-safe.

## Day 4
Private fields plus returning copies means outside code can change data only through my methods.
Local variables live on each thread’s own stack, so they’re safe. Static fields and shared objects are shared, so they need protection.
Race conditions need shared and changeable data. Remove either one and the problem disappears.
synchronized lets only one thread at a time run the protected code. Without it, I got wrong totals again.

## Day 5
Added custom exceptions, tried  thorows, try catch 