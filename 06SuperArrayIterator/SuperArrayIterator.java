import java.util.Iterator;

	public class SuperArrayIterator implements Iterator<String>{
			int current,stop;
			SuperArray SuperArrayy;
			public SuperArrayIterator(int start,SuperArray a) {
				current = start;
				stop = a.getSize()-1;
				SuperArrayy = a;
			}
			public void remove(){
			throw new UnsupportedOperationException();
			}
			public String next(){
				if(hasNext()){
					current++;
				}else{
					System.exit(0);
				}

				return SuperArrayy.get(current-1);
			}
			public boolean hasNext(){
				return current <= stop;
			}
}
