class BankAccount{
	private static String bankName="Global bank";
	private static int totalaccount=0;
	private double salary;
	private String accountHolderName;
	private final int accountNumber;
	public BankAccount(String accountHolderName,int accountNumber,double salary){
		this.accountHolderName=accountHolderName;
		this.accountNumber=accountNumber;
		this.salary=salary;
		totalaccount++;
	}
	public static void getTotalAccount(){
		System.out.println("total number of account details"+totalaccount);
	}
	public void displayAccountdetails(){
		if(this instanceof BankAccount){
		System.out.println("Bank Name"+bankName);
		System.out.println("salary"+salary);
		System.out.println("Account number"+accountNumber);
		System.out.println("Account holder name" + accountHolderName);
		}
		else{
			System.out.println("Invalid account details");
		}
	}
	public static void main(String[] args){
		BankAccount p1=new BankAccount("divya",455666,2200000);
		BankAccount p2=new BankAccount("shreya",344443,76378635);
		p1.displayAccountdetails();
		System.out.println("-------------------------------------------------");
		p2.displayAccountdetails();
		BankAccount.getTotalAccount();
	}
}
		