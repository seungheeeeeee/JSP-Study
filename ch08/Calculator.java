package ch08;

public class Calculator {
	private int n1;
	private int n2;
	private String op;

public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public int getN2() {
		return n2;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

public long calc() {
	long result = 0; //결과값을 지정할 변수 초기화
	switch(op) {
	case "+": result = n1+n2; break;
	case "-": result = n1-n2; break;
	case "/": result = n1/n2; break;
	case "*": result = n1*n2; break;
	}
	return result; //결과값 리턴
}
	
}
