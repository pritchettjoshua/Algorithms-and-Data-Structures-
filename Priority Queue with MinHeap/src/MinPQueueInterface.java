import java.util.ArrayList;

/*
 a)	insert(T a)
Method that properly allows for input into the priority queue

b)	mimimum()
Method that properly returns the minimum element in the priority queue

c)	extractMin()
Method that returns and deletes the minimum element in the priority queue

d)	isEmpty()
Method that returns true or false if the priority queue is empty

e)	delete(T a) 
A method that allows for a parameter a, and if found and deleted returns true otherwise it returns false.

 */
public interface MinPQueueInterface<T> {

	int insert(T a);

	T minimum();

	T extractMin();

	boolean isEmpty();
    
	boolean delete(T a); 
    

}
