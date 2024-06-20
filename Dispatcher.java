package genericWithInheritance;
import java.util.*;
public class Dispatcher {
	public static void main(String[] args) {
		Strauss[] s = {new Strauss(40), new Strauss(45)};
		Penguin[] p = {new Penguin(10), new Penguin(11), new Penguin(12)};
		List<Strauss> als = new ArrayList();
		List<Penguin> alp = new ArrayList();
		als.add(new Strauss(40));
		als.add(new Strauss(45));
		alp.add(new Penguin(10));
		alp.add(new Penguin(12));
		alp.add(new Penguin(11));
		goodForArrays(s);
//		badForArrays(s);
		goodForCollections(als);
		List<Bird> alb = new ArrayList();
		forCollectionsWithCanging(alb);
		
	}
	static void goodForArrays(Bird[] array) {
		int sum = 0;
		for(Bird temp : array) {
			sum += temp.weight;
		}
//		System.out.println(sum);
	}
	static void badForArrays(Bird[] array) {
		array[0] = new Strauss(35);
		array[1] = new Penguin(11);
	}
	static void goodForCollections(List<? extends Bird> list) {
		int sum = 0;
		for(Bird temp : list) {
			sum += temp.weight;
		}
		System.out.println(sum);
	}
	static void forCollectionsWithCanging(List<? super Bird> list) {
		list.add(new Strauss(35));
		list.add(new Penguin(11));
		System.out.println(list.size());
	}
}
class Bird{
	int weight;
	Bird(int weight){
		this.weight = weight;
	}
	void move() {
		
	}
}
class Strauss extends Bird{
	Strauss (int weight){
		super(weight);
	}
	void move() {
		System.out.println("Run");
	}
}
class Penguin extends Bird{
	Penguin(int weight){
		super(weight);
	}
	void move() {
		System.out.println("Swim");
	}
}