class Amount {
	
	private String currency;
	private int amount;

	public Amount(String currency,int amount){
		
		this.currency = currency;
		this.amount = amount;
	}
	
	public String toString() {
		return this.amount + " "+this.currency;
	}
	
	public Amount add(Amount amount) throws CurrenciesDoNotMatch  {
		
		if(this.currency != amount.currency) {
			throw new CurrenciesDoNotMatch("Currencies do not match");
		}
		this.amount += amount.amount;
		return this;
	}
}

class CurrenciesDoNotMatch extends Exception{
	
	public CurrenciesDoNotMatch(String msg) {
		// TODO Auto-generated constructor stub
	  super(msg);
	}
}

public class ExceptionandlingRunner {

	public static void main(String[] args) throws CurrenciesDoNotMatch  {
		// TODO Auto-generated met hod stub
        Amount amount1 = new Amount("USD",20);
        Amount amount2 = new Amount("EUR",30);
        amount1.add(amount2);
        System.out.println(amount1.toString());
	}

}
