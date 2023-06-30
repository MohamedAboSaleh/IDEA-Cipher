package signature;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Verify {
	
	public long p,alpha,beta,m,r,s;
	
	public Verify(long a, long b,long c,long d, long e,long f){
		p=a;
		alpha=b;
		beta=c;
		m=d;
		System.out.println("dec = "+m);
		r=e;
		s=f;
	}
	
	long v1() {
		/*long ya=(long)Math.pow(beta,r);
		long yb=(long)(Math.pow(r, s));
		return (ya*yb)%p;*/
		return ((((long)Math.pow(beta,r))*((long)(Math.pow(r, s))))%p);
	}
	
	long v1(long b, long c,long d,long e) {
		long a=(((long)Math.pow(b, c))*((long)(Math.pow(d, e))));
		if(a<(long)Math.pow(2, 36)-1)
			return a%p;
		else//(a==(long)Math.pow(2, 36)-1)
			return (v1(b,c/2,d,e/2)*v1(b,c-c/2,d,e-e/2))%p;
	}
	
	long v2() {
		return (((long)Math.pow(alpha,m))%p);
	}
	
	long v2(long b, long c) {
		long a=((long)Math.pow(b, c));
		if(a<(long)Math.pow(2, 36)-1)
			return a%p;
		else//(a==(long)Math.pow(2, 36)-1)
			return (v2(b,c/2)*v2(b,c-c/2))%p;
	}
	
	public void verified() {
		if(v1()==v2()) {
			StringBuilder sb=new StringBuilder();
			sb.append("Signature verified using ElGamal.\n");
			sb.append("The value of v1 mod p: "+v1()+"\n");
			sb.append("The value of v2 mod p: "+v2());
			Alert a=new Alert(AlertType.INFORMATION);
			a.setHeaderText("verification");
			a.setContentText(sb.toString());
			a.show();
		}
		else {
			StringBuilder sb=new StringBuilder();
			sb.append("Signature missmatch.\n");
			sb.append("The value of v1 mod p: "+v1()+"\n");
			sb.append("The value of v2 mod p: "+v2());
			Alert a=new Alert(AlertType.INFORMATION);
			a.setHeaderText("verification");
			a.setContentText(sb.toString());
			a.show();
		}
	}
}
