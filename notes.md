# ShopStream Notes

## Day 1 (Thu, Nov 5)
- Records are immutable because all fileds are final private by default
- start() vs run(): starts creates a new thread whereas run is just s normal method call
- The program exits when all non daemon threads have finished executiom

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


