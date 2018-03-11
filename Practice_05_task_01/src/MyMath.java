
public class MyMath {
	static int abs(int x) {
		if(x < 0) {
			x = -x;
		}
		
		return x < 0 ? -x : x;
	}
}
