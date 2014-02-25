import java.util.Scanner;

public class Client{
	public static void main(String args[]){
		int ch;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the size of the list you want to create: ");
		IntList list = new List(in.nextInt());
		while(true){
			System.out.print("1.Insert\n2.Delete\n3.Display\n4.Exit\nEnter your choice: ");
			ch=in.nextInt();
			System.out.println("__________________________________________");
			switch(ch){
				case 1:
				 System.out.print("Enter the key that you want to insert: ");
				 list.insert(in.nextInt());
				 break;
				case 2:
				 System.out.print("Enter the key that you want to delete: ");
				 list.delete(in.nextInt());
				 break;
				case 3:
				 list.display();
				 break;
				case 4:
				 System.exit(0);
				default:
				 System.out.print("Invalid\n");
			}
			System.out.println("__________________________________________");
		}
	}
}