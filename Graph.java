/*
 * Class: CMSC204
 * Instructor: Professor Monshi
 * Description: Class that creates graphs made of vertexes called towns
 * 				and edges called roads and allows each vertex and edge to be added
 * Due: 05/06/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Asael-Meushar Funez-Medina
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road>
{
	
	// Fields
	
	private int numVertices;
	private ArrayList<LinkedList<Road>> adjacencyList;
	private ArrayList<Town> towns;
	
	// Constructors
	public Graph()
	{
		this.numVertices = 0;
		this.adjacencyList = new ArrayList<LinkedList<Road>>();
		this.towns = new ArrayList<Town>();
	}
	
	// Methods
	
	@Override
	public boolean addVertex(Town town)
	{
		// Runs only if town is not already in list
		if (town == null)
			throw new NullPointerException();
		
		if (towns.indexOf(town) == -1)
		{
			// Adds the town to the end of the town list
			// Adds the town as the head of an adjacency list
			// to keep track of roads
			int tempIndex = numVertices;
			towns.add(town);
			adjacencyList.add(new LinkedList<Road>());
			return true;
		}
		
		 return false;
	}
	
	@Override
	public Road addEdge(Town source, Town destination, int weight, String description)
	{
		if (source == null || destination == null)
			throw new NullPointerException();
		
		// Checks if the given towns exist in the graph, throws exception if not
		if ((towns.indexOf(source) == -1) || (towns.indexOf(destination) == -1))
			throw new IllegalArgumentException();
		
		// Towns exist, add road
		int sourceIndex = towns.indexOf(source);
		int destIndex = towns.indexOf(destination);
		Road tempRoad = new Road(source, destination, weight, description);
		
		// Check to see if road does not already exists in a town's
		// adjacency lists
		if (adjacencyList.get(sourceIndex).contains(tempRoad) ||
				adjacencyList.get(destIndex).contains(tempRoad))
			return null;
		else
		{
			// Adds the road to both sides of the adjacency list
			adjacencyList.get(sourceIndex).addLast(tempRoad);
			adjacencyList.get(destIndex).addLast(tempRoad);
			return tempRoad;
		}
	}
	
	@Override
	public Road getEdge(Town sourceTown, Town destinationTown)
	{
		// Case only runs if either of the towns are null or does not exist
		// in the graph
		if (sourceTown == null || destinationTown == null ||
				(towns.indexOf(sourceTown) == -1) ||
				(towns.indexOf(destinationTown) == -1))
			return null;
		
		// Find the Road
		Road tempRoad = new Road(sourceTown, destinationTown, "");
		LinkedList<Road> roads = adjacencyList.get(towns.indexOf(sourceTown));
		int roadIndex;
		Road returnedRoad = null;
		// Check the source of the road
		if (roads.contains(tempRoad))
		{
			roadIndex = roads.indexOf(tempRoad);
			returnedRoad = roads.get(roadIndex);
		}
		// If road is not in source's adjacency list, check if its in
		// the destination's adjacency list
		else if (adjacencyList.get(towns.indexOf(destinationTown)).contains(tempRoad))
		{
			roadIndex = adjacencyList.get(towns.indexOf(destinationTown)).indexOf(tempRoad);
			returnedRoad = adjacencyList.get(towns.indexOf(destinationTown)).get(roadIndex);
		}
		
		return returnedRoad;
	}
	
	@Override
	public boolean containsEdge(Town sourceTown, Town destinationTown)
	{
		// Case only runs if either of the towns are null or does not exist
		// in the graph
		if (sourceTown == null || destinationTown == null ||
				(towns.indexOf(sourceTown) == -1) ||
				(towns.indexOf(destinationTown) == -1))
			return false;
		
		// Stores the road and road lists
		Road tempRoad = new Road(sourceTown, destinationTown, "");
		LinkedList<Road> sourceRoads = adjacencyList.get(towns.indexOf(sourceTown));
		LinkedList<Road> destRoads = adjacencyList.get(towns.indexOf(destinationTown));
		// Check if road exists in source or destination adjacency lists
		if (sourceRoads.contains(tempRoad) || destRoads.contains(tempRoad))
		{
			return true;
		}
		
		return false;
	}

	@Override
	public boolean containsVertex(Town town) {
		// Town is not null and Town exists in the town list (index not -1)
		if (town != null && towns.indexOf(town) != -1)
			return true;
		
		return false;
	}

	@Override
	public Set<Road> edgeSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeVertex(Town v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Town> vertexSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		// TODO Auto-generated method stub
		
	}

}
