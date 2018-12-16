// Given an Iterator class interface with methods: next() and hasNext(), 
// design and implement a PeekingIterator that support the peek() operation -- 
// it essentially peek() at the element that will be returned by the next call to next().

// Read the next Integer out beforehand, 
// so return true for hasNext() if nextInt is not null, 
// return nextInt for next() and read in the next Integer

// This method has one flaws:
// It doesn't work on generic types because null can be a legitimate element for generic type list.

class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer nextInt;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
        if (this.iterator.hasNext()) {
            nextInt = this.iterator.next();  
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextInt;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = nextInt;
        nextInt = iterator.hasNext() ? iterator.next() : null;
        return res;
	}

	@Override
	public boolean hasNext() {
	    return nextInt != null;
	}
}

// Runtime: 59ms



// Read the Integer in when peek(), then set the flag readIn to true, after next(), set it to false.

class PeekingIterator implements Iterator<Integer> {

    private boolean flag;
    private Iterator<Integer> iterator;
    private Integer nextInt;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (flag == true) {
            return nextInt;
        }
        nextInt = iterator.next();
        flag = true;
        return nextInt;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if (flag == true) {
            flag = false;
            return nextInt;
        } else {
            return iterator.next();
        }
	}

	@Override
	public boolean hasNext() {
        if (flag == true || iterator.hasNext()) {
            return true;
        }
        return false;
	}
}

// Runtime: 80ms