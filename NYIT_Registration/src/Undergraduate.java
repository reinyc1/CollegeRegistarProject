import javax.swing.JOptionPane;
import java.util.Date;

class Undergraduate extends Student	//Derived class of Subclass)
{	
	private int level;		//1 for freshman, 2 for sophomore, 3 for junior, or 4 for senior.
	private String type;
	public Undergraduate()	
	{ 
		super( ); 	
		level = 1;	
		type = "U";
	}

	public Undergraduate(String initialName, int initStID, int initLevel)
	{  
		super(initialName, initStID);	
		setLevel(initLevel);	
	}
		
	public void reset (String newName, int newStID, int newLevel)
	{	
		reset(newName, newStID);	
		setLevel (newLevel);	
	}

	public int getLevel ()	
	{ 
		return level;			
	}

	public void setType (String newType)	
	{	
		type = newType;		
	}
	
	public void setLevel (int newLevel)	
	{	
		if (( 1 <= newLevel ) && (newLevel <= 4))
		level = newLevel;
	else
	{ 
		System.out.println("Illegal level!");	System.exit(0); }
	}
	
	public String writeOutput()
	{	
		super.writeOutput();
		
		String type2 = new String();
		if (type.equals("U"))
		{
			type2 = "Undergraduate";
		}else if (type.equals("G"))
		{
			type2 = "Graduate";
		}
		
		String messg = getStudentNumber() + "\t" + getName() + "\t" + level + "\t" + type2 + "\n";
		return messg;
	}
	
	public boolean equals(Undergraduate otherUndergraduate)
	{ 
		return equals (( Student)otherUndergraduate) && (this.level == otherUndergraduate.level); 					
	}
} 
