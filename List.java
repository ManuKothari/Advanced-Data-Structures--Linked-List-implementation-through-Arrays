public class List implements IntList{
	private int freeHead,fillHead;
	private int key[];
	private int next[];
	List(){
		freeHead=0;
		fillHead=-1;
		key=new int[20];
		next=new int[20];
		for(int i=0;i<next.length-1;i++)	// All next nodes are free ...
			next[i]=i+1;							
		next[next.length-1]=-1;				
	}
	List(int size){
		freeHead=0;
		fillHead=-1;
		key=new int[size];
		next=new int[size];
		for(int i=0;i<next.length-1;i++)
			next[i]=i+1;
		next[next.length-1]=-1;
	}
	public void insert(int n){
		if(freeHead==-1)				// Create list of double size.... and copy.... (is it a good approach as follows):
										/*
										size*=2;
										k=new int[size];
										n=new int[size];
										copy elements of key and next respectively into it.....
										key=k;next=n;
										assign values and continue....
										*/
			System.out.println("No space available to add...");
		else{
			int t=freeHead;    		 	//Location to add the new Node in the array
			freeHead=next[freeHead];	//Points to the new free location
			key[t]=n;					//Enters key value into array at location t
			int prev=-1, pres=fillHead;
			if(pres==-1){				//First entry into the array
				fillHead=0;
				next[0]=-1;
			}
			else{
				while(pres!=-1 && key[t]>key[pres]){
					prev=pres;
					pres=next[pres];
				}
				if(prev==-1){			//Inserting at the beginning
					next[t]=pres;
					fillHead=t;
				}
				else{					//Insert at middle/end
					next[prev]=t;
					next[t]=pres;
				}
			}
		}
		display();
	}
	public void delete(int n){
		
		if(fillHead==-1)
			System.out.println("No elements in array...");    //Empty Array
		else{
			int prev=-1,pres=fillHead;
			while(pres!=-1 && key[pres]!=n){
				prev=pres;
				pres=next[pres];
			}
			if(pres==-1)
				System.out.println("Invalid key - not found ");
			else{
				int t=next[pres];						//Store the value , as this value is reqd later..
				next[pres]=freeHead;					//changing next[pres]
				freeHead=pres;
				if(prev==-1)							//Deletion at beginning
					fillHead=t;
				else									//Deletion at middle/end
					next[prev]=t;
			}
		}
		display();
	}
	public void display(){
		System.out.print("Display of keys: ");
		int temp=fillHead;
		while(temp!=-1){
			System.out.print(key[temp]+" ");
			temp=next[temp];
		}
		System.out.println();
		/*System.out.print("Key: ");					// Reqd for debugging program...
		for(int i=0;i<next.length;i++)
			System.out.print(key[i]+" ");
		System.out.println();
		System.out.print("Next: ");
		for(int i=0;i<next.length;i++)
			System.out.print(next[i]+" ");
		System.out.println();*/
	}
}