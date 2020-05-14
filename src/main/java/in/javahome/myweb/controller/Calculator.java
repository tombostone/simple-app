package in.javahome.myweb.controller;
/*
 * 
 */
public class Calculator {
	
	void test() {
        int target = -5;
int num = 3;

target =- num;  // Noncompliant; target = -3. Is that really what's meant?
target =+ num; // Noncompliant; target = 3
	}
	/*
	 * @param i
	 * @param j
	 * @return int
	 */
	public int add(int i, int j){
		return i+j;
	}
	public int multiply(int i, int j){
		return i*j;
	}
	
	public int sub(int i, int j){
		return i-j;
	}
}
