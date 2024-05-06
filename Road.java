/*
 * Class: CMSC204
 * Instructor: Professor Monshi
 * Description: Class that allows for the creation of roads that act as
 * 				an edge between vertexes in a class
 * Due: 02/06/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Asael-Meushar Funez-Medina
*/

public class Road implements Comparable<Road>
{
	
	// Fields
	
	private Town source;
	private Town destination;
	private int weight;
	private String name;
	
	// Constructors
	
	/**
	 * Creates a Road object
	 * @param source - One town on the road
	 * @param destination - Another town on the road
	 * @param weight - weight of edge/distance between towns
	 * @param name - name of the road
	 */
	public Road(Town source, Town destination, int weight, String name)
	{
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.name = name;
	}
	
	/**
	 * Creates a Road object with weight preset at 1
	 * @param source - One town on the road
	 * @param destination - Another town on the road
	 * @param name -
	 */
	public Road(Town source, Town destination, String name)
	{
		this(source, destination, 1, name);
	}
	
	/**
	 * Checks if the road is connected to a given town
	 * @param town - the road to check
	 * @return true only if the edge contains the given town
	 */
	public boolean contains(Town town)
	{
		return this.source.equals(town) || this.destination.equals(town);
	}
	 
	@Override
	public String toString()
	{
		return this.source + " " +
				this.destination + " " +
				this.weight + " " + 
				this.name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public Town getDestination()
	{
		return this.destination;
	}
	
	public Town getSource()
	{
		return this.source;
	}
	
	@Override
	public int compareTo(Road other)
	{
		return this.name.compareTo(other.name);
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	@Override
	public boolean equals(Object r)
	{
		Road other = (Road) r;
		boolean hasSameTowns = false;
		
		// Checks if the sources are the same
		if (this.source.equals(other.source))
		{
			// Same source, different destination, not the same
			if (this.destination.equals(other.destination))
				hasSameTowns = true;
		}
		// Checks if the source is opposite
		else if (this.source.equals(other.destination))
		{
			// Checks if towns are switched
			if (this.destination.equals(other.source))
			{
				hasSameTowns = true;
			}
		}
		
		return hasSameTowns;
	}

}
