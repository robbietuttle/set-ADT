
import java.util.Arrays;
/**
 * A class that creates a resizable array set
 * 
 * @author robbietuttle
 *
 */
public class ResizableArraySet implements SetInterface{
	
	//---------------------------------------------------------------- Properties	
	//should this be private or public
	
	private int[] data;
	private int numberOfEntries;
	
	
	//---------------------------------------------------------------- Constructors
		data = new int[10];
		numberOfEntries = 0;
	}
	
	public ResizableArraySet(int startingSize) {
		data = new int[startingSize];
		numberOfEntries = 0;
	}
	
	
	//---------------------------------------------------------------- Methods
	/**
	 * Gets the current number of entries in this set.
	 * 
	 * @return The integer number of entries currently in the set.
	 */
	@Override
	public int getSize() {
		return numberOfEntries;
	}

	
	/**
	 * Sees whether this set is empty.
	 * 
	 * @return True if the set is empty, or false if not.
	 */
	@Override
	public boolean isEmpty() {
		return (getSize()==0);
	}

	
	/**
	 * Adds a new entry to this set, avoiding duplicates.
	 * 
	 * @param newValue
	 *            The integer to be added as a new entry.
	 * @return True if the addition is successful, or false if the item already
	 *         is in the set.
	 */	
	@Override
	public boolean add(int newValue) {
		if(contains(newValue)) return false;
		if(numberOfEntries==data.length) {
			data = Arrays.copyOf(data, data.length*2);
		}
		data[numberOfEntries] = newValue;
		numberOfEntries++;
		return true;
		
	}

	
	/**
	 * Removes a specific entry from this set, if possible.
	 * 
	 * @param anEntry
	 *            The entry to be removed.
	 * @return True if the removal was successful, or false if not.
	 */
	@Override
	public boolean remove(int aValue) {
		if(getIndexOf(aValue)==-1) return false;
		data[getIndexOf(aValue)] = data[numberOfEntries-1]; 
		data[numberOfEntries-1] = 0;
		numberOfEntries--;
		return true;
	}

	
	/**
	 * Removes one unspecified entry from this set, if possible.
	 * 
	 * @return Either the removed entry, if the removal was successful, or Integer.MIN_VALUE.
	 */
	@Override
	public int remove() {
		if(numberOfEntries<=0) 
			return Integer.MIN_VALUE;
		int rtn = data[numberOfEntries-1];
		data[numberOfEntries-1] = 0;
		numberOfEntries--;
		return rtn;
	}

	/** Removes all entries from this set. */
	@Override
	public void clear() {
	int[] emptyData = new int[data.length];
	data=emptyData;
	numberOfEntries=0;
	}

	
	/**
	 * Tests whether this set contains a given entry.
	 * 
	 * @param anEntry
	 *            The entry to locate.
	 * @return True if the set contains anEntry, or false if not.
	 */
	@Override
	public boolean contains(int anEntry) {
		return (getIndexOf(anEntry) > -1);
	}

	/**
	 * Computes the union of this set with a given set
	 * 
	 * @param anotherSet
	 *            another set
	 * @return the union of this set with anotherSet
	 */
	@Override
	public SetInterface union(SetInterface anotherSet) {
		ResizableArraySet newSet = new ResizableArraySet();
		for(int i= 0 ; i<numberOfEntries ; i++) {
			newSet.add(data[i]);
		}
		for(int i : anotherSet.toArray()) {
			newSet.add(i);
		}
		return newSet;
	}

	/**
	 * Computes the intersection of this set with a given set
	 * 
	 * @param anotherSet
	 *            another set
	 * @return the intersection of this set with anotherSet
	 */
	@Override
	public SetInterface intersection(SetInterface anotherSet) {
		ResizableArraySet newSet = new ResizableArraySet();
		
		for(int i= 0 ; i<numberOfEntries ; i++) {
			if(anotherSet.contains(data[i])) {
				newSet.add(data[i]);
			}
		}
		return newSet;
	}

	/**
	* Computes the elements in this set except for those that are also in anotherSet
    *
	* @param anotherSet
	*            another set
	* @return the result of removing all elements of this set that are in anotherSet
	*/
	@Override
	public SetInterface difference(SetInterface anotherSet) {
	ResizableArraySet newSet = new ResizableArraySet();
		
		for(int i= 0 ; i<numberOfEntries ; i++) {
			if(!(anotherSet.contains(data[i]))) {
				newSet.add(data[i]);
			}
		}
		return newSet;
	}

	/**
	 * Retrieves all entries that are in this set.
	 * 
	 * @return A newly allocated array of all the entries in the set, where the
	 *         size of the array is equal to the number of entries in the set.
	 */
	@Override
	public int[] toArray() {
		int[] ret = new int[numberOfEntries];
		for(int i = 0 ; i<numberOfEntries ; i++) {
			ret[i] = data[i];
		}
		return ret;
	}
	
	
	
	
	/**
	 * 
	 * @param anEntry the value being searched for
	 * @return the index of the value, or -1 if the value isn't in the array
	 */
	private int getIndexOf(int anEntry) {
		int index = -1;
		for(int i = 0; i<data.length ; i++) {
			if(anEntry == data[i]) index = i;
		}
		return index;
	}
	
}
