/**
 * Tester class that prints out 
 * info proving the methods and 
 * constructors in ResizableArraySet
 * work correctly.
 * 
 * @author robbietuttle
 *
 */
public class SetTester {
	public static void main(String[] args) {

		//Creates 2 new sets
		ResizableArraySet x1 = new ResizableArraySet();
		ResizableArraySet x2 = new ResizableArraySet(5);
		ResizableArraySet xEmptySet = new ResizableArraySet();

		System.out.println("----------------Initial Test of isEmpty----------------");
		System.out.println("x1 = empty - true? : " +x1.isEmpty());
		System.out.println("x2 = empty - true? : " +x2.isEmpty());
		
		System.out.println("\n------------------Test of add method-------------------");
		//adds values to x1
		System.out.println("x1 add 1 - true? : "+ x1.add(1));
		System.out.println("x1 add 1 - false? : "+ x1.add(1));
		x1.add(2);
		x1.add(3);
		x1.add(4);
		x1.add(5);

		//adds values to x1
		x2.add(1);
		x2.add(6);
		x2.add(3);
		x2.add(7);
		x2.add(5);
		x2.add(8);
		x2.add(9);
		x2.add(10);
		x2.add(11);
		x2.add(12);
		x2.add(13);
		x2.add(14);
		
		System.out.println("\n----------------Updated Test of isEmpty----------------");
		System.out.println("x1 = empty - false? : " +x1.isEmpty());
		System.out.println("x2 = empty - false? : " +x2.isEmpty());
		
		
		System.out.println("\n----------------Initial Test of getSize----------------");
		System.out.println("x1 size = 5? : " +x1.getSize());
		System.out.println("x2 size = 12? : " +x2.getSize());
		
		System.out.println("\n----------------Test of remove method, with a value----------------");
		System.out.println("x2.remove(11) = true? : " +x2.remove(11));
		System.out.println("x2.remove(11) = false? : " +x2.remove(11));
		
		System.out.println("\n----------------Test of remove method, w/o a value----------------");
		System.out.println("x2.remove() = some value? : " +x2.remove());
		System.out.println("xEmptySet.remove() = min value? : " +xEmptySet.remove());
		
		
		
		System.out.println("\n-------------------Updated Test of getSize-------------------");
		System.out.println("x1 size = 5? : " +x1.getSize());
		System.out.println("x2 size = 10? : " +x2.getSize());
		
		System.out.println("\n----------------------Test of Contains-----------------------");
		System.out.println("x1 contains 1 = true? : " +x1.contains(1));
		System.out.println("x2 contains 99 = false? : " +x2.contains(99));
		
		System.out.println("\n-------------------Test of toArray for X1--------------------");		
		System.out.println("X1 contains: 1 2 3 4 5? ");
		for(int i : x1.toArray()) {
			System.out.print(i+"  ");
		}
		System.out.println("\n\n-------------------Test of toArray for X2--------------------");
		System.out.println("X2 contains: 1 6 3 7 5 8 9 10 14 12?");
		for(int i : x2.toArray()) {
			System.out.print(i+"  ");
		}

		System.out.println("\n\n-------------------Test of Union X1 - X2---------------------");
		System.out.println("Union: ");
		for(int i : x1.union(x2).toArray()) {
			System.out.print(i+"  ");
		}

		System.out.println("\n\n-------------------Test of Union X2 - X1---------------------");
		System.out.println("Union: ");
		for(int i : x2.union(x1).toArray()) {
			System.out.print(i+"  ");
		}

		System.out.println("\n\n----------------Test of Intersection X1 - X2-----------------");
		System.out.println("Intersection: ");
		for(int i : x1.intersection(x2).toArray()) {
			System.out.print(i+"  ");
		}

		
		System.out.println("\n\n----------------Test of Intersection X2 - X1-----------------");
		System.out.println("Intersection: ");
		for(int i : x2.intersection(x1).toArray()) {
			System.out.print(i+"  ");
		}

		System.out.println("\n\n-----------------Test of Difference X1 - X2------------------");
		System.out.println("Difference: ");
		for(int i : x1.difference(x2).toArray()) {
			System.out.print(i+"  ");
		}
		
		System.out.println("\n\n-----------------Test of Difference X2 - X1------------------");
		System.out.println("Difference: ");
		for(int i : x2.difference(x1).toArray()) {
			System.out.print(i+"  ");
		}
		
		
		
		System.out.println("\n\n------------------------Test of Clear------------------------");
		x1.clear();
		x2.clear();
		System.out.println("x1 size = 0? : " +x1.getSize());
		System.out.println("x2 size = 0? : " +x2.getSize());
	}

}
