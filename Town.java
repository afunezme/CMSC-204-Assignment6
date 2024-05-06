/*
 * Class: CMSC204
 * Instructor: Professor Monshi
 * Description: Class that allows for the creation of towns that act as
 * 				a vertex in a graph
 * Due: 02/06/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Asael-Meushar Funez-Medina
*/

import java.util.ArrayList;

public class Town implements Comparable<Town>
{

	// Fields
	
	private String name;
	private ArrayList<Town> adjacentTowns;
	
	// Constructors
	
	/**
	 * Creates a Town object with a name and zero default adjacent towns
	 * @param name - the name of the town
	 */
	public Town(String name)
	{
		this.name = name;
		this.adjacentTowns = new ArrayList<Town>();
	}
	
	/**
	 * Copy constructor that copies the name of a given town
	 * and assigns zero default adjacent towns
	 * @param otherTown - Townm to copy
	 */
	public Town(Town otherTown)
	{
		this(otherTown.name);
	}
	
	// Methods
	
	/**
	 * @return the town's name
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Sets the town's name to the set name
	 * @param name - the new name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setAdjacentTown(Town town)
	{
		this.adjacentTowns.add(town);
	}

	@Override
	public int compareTo(Town o)
	{
		return this.name.compareTo(o.name);
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
	
	@Override
	public int hashCode()
	{
		return this.name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Town temp = (Town) obj;
		return this.name.equals(temp.name);
	}
	
}
