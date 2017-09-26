package lesson11.labs.prob7.mystream_lab;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStream<T> {
	private List<T> elements;
	public static <T> MyStream<T> of(List<T> aList) {
		//implement
		return new MyStream<T>(aList) ;
	}
	private MyStream(List<T> aList) {
		//implement
		this.elements = aList;
	}
	
	public static <S> MyStream<S> concat(MyStream<S> s1, MyStream<S> s2) {
		//implement
		List<S> list = s1.asList();
		list.addAll(s2.asList());
		return MyStream.of(list) ;
	}
	
	public <R> MyStream<R> flatMap(Function<T, MyStream<R>> mapper) {
		//implement
		MyStream<R> myStream = null;
		for(T t : elements) {
			MyStream<R> r = mapper.apply(t);
			if(myStream == null)
				myStream = r;
			else
				myStream = MyStream.concat(myStream, r);
		}
		return myStream;
	}
	
	public List<T> asList() {
		//implement
		return elements;
	}
	
	public <R> MyStream<R> map(Function<T,R> mapper) {
		//implement
		List<R> list = new ArrayList<R>(); 
		for(T t : elements) {
			R r = mapper.apply(t);
			list.add(r);
		}
		return MyStream.of(list);
	}
	
	public MyStream<T> filter(Predicate<T> predicate) {
		//implement
		List<T> list = new ArrayList<T>(); 
		for(T t : elements) {
			if(predicate.test(t))
				list.add(t);
		}
		return MyStream.of(list) ;
	}
}
