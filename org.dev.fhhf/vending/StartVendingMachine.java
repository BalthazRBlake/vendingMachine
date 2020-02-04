package vending;

public class StartVendingMachine {

	public static void main(String[] args) {
		
		ReadInput readInput = new ReadInput();
		//1,2,3,5,5;2,5,4,3,1;3,5,4,1,1;5,1,1,1,1
		//1,2,3,5,5,7;2,5,4,3,1,5;3,5,4,1,1;1,1,1,1,1
		//1,2,3,4,5
		try {
			
			VendingMachine model = readInput.readInput();
			//System.out.println("Products: " + model.getBuckets());
			
			/*Uncomment while to run till enter q*/
			//while(model.getOrder() != null) {
				
			model = readInput.readOrder();
			
			if(model.getOrder() != null) {
							
				model.createOrder();
	
				if( model.canBeVended() ) {
					model.excecuteOrder();
					System.out.println("Products: " + model.getBuckets());
				}else {
					System.out.println("IMPOSSIBLE");
				}
			}
			//}
		}
		catch(NumberFormatException ex) {
			System.out.println("Wrong input, please follow the format: \n"
					+ "<int_1>,<int_2>,...,<int_n>;<int_1>,<int_2>,...,<int_n> \n"
					+ "e.g. 1,2,1,3,4;5,2,3,3,3");
		}
		
	}

}
