package homeworks;
public class Contact implements Comparable<Contact>{
	public Contact(String first, String last, String phnum, 
			String street, String city, String state) {
		this.first = first;
		this.last = last;
		this.phnum = phnum;
		this.street = street;
		this.city = city;
		this.state = state;
	}
	
	public Contact(String first, String last, String phnum) {
		this(first, last, phnum, "", "", "");
	}
	
	public String getFirst() { return first; }
	public String getLast() { return last; }
	public String getPhonenumber() { return phnum; }
	public String getStreet() { return street; }
	public String getCity() { return city; }
	public String getState() { return state; }
	
	public void update(String first, String last, String phnum, 
			String street, String city, String state) {
		this.first = first;
		this.last = last;
		this.phnum = phnum;
		this.street = street;
		this.city = city;
		this.state = state;
	}
	
	public int compareTo(Contact another) {
		int compLast = last.compareTo(another.last);
		if(compLast == 0)
			return first.compareTo(another.first);
		else 
			return compLast;
		/*if(last.compareTo(another.last) > 0)
			return 1;
		if(last.compareTo(another.last) < 0)
			return -1;
		if(last.compareTo(another.last) == 0){
				if(first.compareTo(another.first) > 0)
					return 1;
				if(first.compareTo(another.first) < 0)
					return -1;
				else return 0;
		}
		return 0;*/
		
	}
	
	public boolean equals(Object obj) { //contact1.equals(c2)
		if(!(obj instanceof Contact))
			return false;
		
		Contact another = (Contact) obj;
		
		return compareTo(another) == 0;
	}
	
	public String toString() {
		return getFirst() + " " + getLast() + "\t\tPhone number:" 
	+ getPhonenumber() + "\n" + getStreet() + "\n" + 
	getCity() + ", " + getState() + "\n";
	}
	
	private String first, last, phnum,
	street, city, state;
	
	public static void main(String[] args) {
		
		Contact c1 = new Contact("Ari", "Mermelstein", "1234567", "2900 Bedford Ave", "Brooklyn", "New York");
		Contact c2 = new Contact("Ari", "Mermelstein", "1234567", "2900 Bedford Ave", "Brooklyn", "New York");
		
		Contact c3 = new Contact("Beta", "Charlie", "1234567", "123 Fake St.", "Fakeville", "New York");
		
		Contact c4 = new Contact("Charlie", "Delta", "6666666", "123 Fake St.", "Fakeville", "New York");
		
		Contact c5 = new Contact("Delta", "Echo", "1234567", "123 Fake St.", "Fakeville", "New York");
		
		System.out.println("Contact 1:\n" + c1.toString());
		System.out.println("Contact 2:\n" + c2.toString());
		System.out.println("Contact 3:\n" + c3.toString());
		System.out.println("Contact 4:\n" + c4.toString());
		System.out.println("Contact 5:\n" + c5.toString());

		System.out.println("The first two contacts are identical: " + c1.equals(c2)); 
		System.out.println("\nThe first two contacts share the same first and last name: " + c1.compareTo(c2)); 
		
		System.out.println("\nContact 3 is lexicographically first compared to Contact 1: " + c1.compareTo(c3));  
		
		c5.update("Updated Contact", "test", "1234567", "123 Fake St.", "Fakeville", "New York" );
		System.out.println("\n" + c5.toString());


		System.out.println("Contact 1 Name: " + c1.getFirst() + " " + c1.getLast());
		System.out.println("Contact 2 Name: " + c2.getFirst() + " " + c2.getLast());
		System.out.println("Contact 3 Name: " + c3.getFirst() + " " + c3.getLast());
		System.out.println("Contact 4 Name: " + c4.getFirst() + " " + c4.getLast());
		System.out.println("Contact 5 Name: " + c5.getFirst() + " " + c5.getLast());

		
		
		

		
	}
}
