package signature;

public class signAlgo {
	
	public long p,alpha,yA,m,r,s,k;
	
	private long xA=16;
	 int primes[]= {2,3,5,7,11,13,17,19,23,27,29,31,37,47};
	public signAlgo(long a1, long b1,long c1){
		p=a1;
		alpha=b1;
		yA=((long)Math.pow(alpha, xA))%p;
		m=c1%20;
		System.out.println("enc = "+m);
		k=5;
		r=createS1(alpha,k);
		s=createS2();
	}
	
	long gcd(long a,long b) {
		if(a<b)
			return gcd(b,a);
		else if(a%b==0)
			return b;
		else
			return gcd(b,a%b);
	}
	
	long createK() {
		/*long a = 2*(p-1);
		while(gcd(a,p-1)!=1) {
			a = (long) (Math.random()*(p-1));
		}*/
		int index = (int) (Math.random()%primes.length);
		System.out.println("index = "+index);
		return primes[index];
	}
	
	long invK() {
		for (int x = 1; x < p-1; x++) 
	           if ((k * x) % (p-1) == 1) 
	              return x; 
	        return 1; 
	}
	
	long createS1(long b, long c) {
		long a=((long)Math.pow(b, c));
		if(a<(long)Math.pow(2, 36)-1)
			return a%p;
		else//(a==(long)Math.pow(2, 36)-1)
			return (createS1(b,c/2)*createS1(b,c-c/2))%p;
	}
	
	long createS2() {
		long a=(invK()*(m-xA*r))%(p-1);
		if(a>=0)
			return a;
		else
			return (a+p-1);
	}
	
	
}