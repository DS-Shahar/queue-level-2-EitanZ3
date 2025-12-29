public class Main
{
	public static Queue<Integer> ex1(Queue<Character> q)
	{
		Queue<Integer> newQ = new Queue<Integer>();
		if (q.isEmpty())
		{
			return newQ;
		}
		char current = q.remove();
		int count = 1;
		while (!q.isEmpty())
		{
			char ch = q.remove();
			if (ch == current)
			{
				count++;
			}
			else
			{
				newQ.insert(count);
				current = ch;
				count = 1;
			}
		}
		newQ.insert(count);
		return newQ;
	}


	public static boolean ex2(Queue<String> q)
	{
		Queue<String> help=new Queue<String>();
		int n=q.size();
		for (int i=0; i<n; i++)
		{
			String x=q.remove();
			if (q.isIn(x, help))
			{
				return true;
			}
			help.insert(x);
			q.insert(x);
		}
		return false;
	}

	public static Queue<Integer> ex3(Queue<Integer> q)
	{
		Queue<Integer> help = new Queue<Integer>();
		int n = q.size();
		for (int i = 0; i < n; i++)
		{
			int x = q.remove();
			if (!help.isIn(x, help))
			{
				help.insert(x);
			}
		}
		return help;
	}




	public static Queue<Integer> ex4(Queue<Integer> q) 
	{
		Queue<Integer> temp=new Queue<Integer>();
		Queue<Integer> sorted=new Queue<Integer>();
		while(!q.isEmpty()) 
		{
			int min=q.head();
			while(!q.isEmpty()) 
			{
				int val=q.remove();
				if(val<min)min=val;
				temp.insert(val);
			}
			boolean f=false;
			while(!temp.isEmpty()) 
			{
				int val=temp.remove();
				if(val==min&&!f) 
				{
					sorted.insert(val);
					f=true;
				} else {
					q.insert(val);
				}
			}
		}
		return sorted;
	}



	public static void main(String[] args)
	{
		Queue<Character> q = new Queue<Character>();
		q.insert('a');
		q.insert('a');
		q.insert('a');
		q.insert('b');
		q.insert('c');
		q.insert('c');
		System.out.println(ex1(q));
		Queue<String> q2 = new Queue<String>();
		q2.insert("ron");
		q2.insert("gus");
		q2.insert("tus");
		q2.insert("ron");
		System.out.println(ex2(q2));
		Queue<Integer> q3 = new Queue<Integer>();
		q3.insert(3);
		q3.insert(3);
		q3.insert(12);
		q3.insert(11);
		q3.insert(2);
		q3.insert(3);
		q3.insert(11);
		System.out.println(ex3(q3));
		Queue<Integer> q4 = new Queue<Integer>();
		q4.insert(17);
		q4.insert(7);
		q4.insert(6);
		System.out.println(ex4(q4));
	}
}
