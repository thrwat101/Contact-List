package homeworks;
import java.util.*;
import java.io.*;
public class ContactList implements Iterable<Contact>{	
	public ContactList() {
		contactList = new ArrayList<>();
	}
	
	public ContactList(Contact[] contact) {
		sort(contact);
		contactList = new ArrayList<>(Arrays.asList(contact));
	}
	
	public Contact findByLastName(String last) {
		int start = 0, end = size()-1;
		
		while(start <= end) {
			int mid = (start + end)/2;
			if(last.equals(contactList.get(mid).getLast()))
				return get(mid);
			else if(last.compareTo(contactList.get(mid).getLast()) < 0)
				end = mid - 1;
			else start = mid + 1;
		}
		return null;	
	}
	
	public Contact findByPhoneNumber(String phone) {
		for(Contact c: contactList)
			  if(c.getPhonenumber().equalsIgnoreCase(phone))
				  return c;
		return null;
	}
	
	public ContactList findAllByLastInitial(char ch) {
		ContactList lastInitialList = new ContactList();
		for(Contact c: contactList) {
            if(c.getLast().toUpperCase().startsWith((ch+"").toUpperCase()))
            	lastInitialList.add(c);
		}
		return lastInitialList;
	}
	
	public ContactList findAllByCity(String city) {
		ContactList cityList = new ContactList();
		for(Contact c: contactList) {
			if (c.getCity().equalsIgnoreCase(city))
				cityList.add(c);
		}
		return cityList;
	}
	
	public  boolean add(Contact c) {
		int start = 0, end = size(), count = 0;

		while(start < end) {
			int mid = (start + end)/ 2;
			if(c.equals(get(mid)))
				return false;
			else if (c.compareTo(get(mid)) < 0)
				end = mid - 1;
			else
				start = mid + 1;
			
		}
		this.contactList.add(start, c);
		return true;			
	}
	
	public  int size() { return contactList.size(); }
	
	public  Contact remove(Object obj) {
		Contact c = (Contact) obj;
		return this.contactList.remove(this.contactList.indexOf(c));
	}
	
	public  Contact get(int index) {
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException();
		return this.contactList.get(index);
	}
	
	public  boolean equals(Object obj) {
		if(!(obj instanceof ContactList))
			return false;
		
		ContactList other = (ContactList) obj;
		
		if(contactList.size() != other.size())
			return false;
		
		Contact con1, con2;
		Iterator<Contact> iter1 = contactList.iterator();
		Iterator<Contact> iter2 = other.iterator();

		while(iter1.hasNext()) {
			con1 = iter1.next();
			con2 = iter2.next();
			if(!con1.equals(con2))
				return false;
		}
		
		return true;	
	}
	
	public String toString() {
        StringBuilder s = new StringBuilder();
        for (Contact c : contactList) {
            s.append(c.toString() + "\n");
        }

        return s.toString();
    }
	
	public void sort(Contact[] contact) {
		for(int i = 0; i < contact.length-1; i ++) 
			for(int j = 0; j < contact.length-1; j++)
				if(contact[j].compareTo(contact[j+1]) < 0) {
					Contact temp = contact[j];
					contact[j] = contact[j +1];
					contact[j+1] = temp;
		 		}
	}

	@Override
	public Iterator<Contact> iterator(){
		return contactList.iterator();
	}
	
	private ArrayList<Contact> contactList;

	public static void main(String[] args) {
		Contact c1 = new Contact("Ari", "Mermelstein", "1234567", "2900 Bedford Ave", "Brooklyn", "New York");
		Contact c2 = new Contact("Ari", "Mermelstein", "1234567", "2900 Bedford Ave", "Brooklyn", "New York");
		
		Contact c3 = new Contact("Beta", "Mermelstein", "1234567", "123 Fake St.", "Fakeville", "New York");
		
		Contact c4 = new Contact("Charlie", "Delta", "6666666", "123 Fake St.", "Fakeville", "New York");
		
		Contact c5 = new Contact("Delta", "Echo", "1234567", "123 Fake St.", "Fakeville", "New York");
		
		Contact c6 = new Contact("Foxtrot", "Gary", "1234567", "123 Fake St.", "Fakeville", "New York");

		Contact[] contactArray = {c1, c3,c4,c5};
		Contact[] contactArray2 = {c1,c3,c4,c5};
		Contact[] contactArray3 = {c1, c2, c3,c4,c5};

		ContactList contacts = new ContactList(contactArray);
		ContactList contacts2 = new ContactList(contactArray2);
		ContactList contacts3 = new ContactList(contactArray3);
		
			System.out.println(contacts3.toString());
			
			System.out.println("Removing and returning c2 from the contact list");
			System.out.println(contacts3.remove(c2));

	        System.out.println("findByLastName: Contacts with lastname Mermelstein.");
	        System.out.println(contacts.findByLastName("Mermelstein"));
	        
	        System.out.println("findByPhoneNumber: contact with phone number 6666666.");
	        System.out.println(contacts.findByPhoneNumber("6666666"));
	        
	        System.out.println("\nfindAllByCity: All contacts with the same city:");
	        System.out.println(contacts.findAllByCity("Fakeville").toString());
	        
	        System.out.println("\nfindAllByLastInitial: All contacts with the same last initial:");
	        System.out.println(contacts3.findAllByLastInitial('M'));
	        
	        System.out.println("\nAdding to the list: Returns false because attempting to add existing contact.");
	        System.out.println(contacts.add(c2));
	        
	        
	        System.out.println("\nChecking equality of two lists: Returns true because c1 and c2 are identical lists.");
	        System.out.println(contacts.equals(contacts2)); 
	}

}



