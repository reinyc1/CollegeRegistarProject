public class Person
{
	private String name;

	public Person	( )	
	{ 
		name = "No name yet";	
	}

	public Person (String initialName)
	{ 
		name = initialName; 	
	}

	public void setName (String newName)
	{ 
		name = newName;	
	}

	public String getName	()		
	{ 
		return name;		
	}

	public String writeOutput()
	{ 
		return "Name: " + name;	
	}

	public boolean hasSameName ( Person otherPerson)
	{ 
		return this.name.equalsIgnoreCase (otherPerson.name);	
	}
}      