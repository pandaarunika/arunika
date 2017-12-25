package notSynchronised;

public class App {

	public static void main(String[] args) {
		A a= new A();
		B b=new B(a);
		C c = new C(a);
		b.start();
		c.start();
	}

}
class A {
	void print(int n){
		for(int i =1;i<=5;i++){
			System.out.println(i*n);
		}
	}
}
class B extends Thread{
	A a;
	public B(A a){
		this.a=a;
	}
	public void run(){
		a.print(10);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class C extends Thread{
	A a;
	public C(A a){
		this.a=a;
	}
	public void run(){
		a.print(100);
	}
}

