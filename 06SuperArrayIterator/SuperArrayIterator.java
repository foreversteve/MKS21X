
import java.util.Iterator;

	public class SuperArrayIterator implements Iterator{
			int current,stop;
			SuperArray SuperArrayy;
			public SuperArrayIterator(int start,int end,SuperArray a) {
				current = start;
				stop = end;
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
