package org.mingtaoz.leetcode.toolbox.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class UndirectedGraph {

	public UndirectedGraphNode node;

	public static class UndirectedGraphNode {
		public int label;
		public List<UndirectedGraphNode> neighbors;

		public UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}

	public UndirectedGraphNode cloneGraph() {
		return cloneGraph(node);
	}

	public String serializeGraph() {
		return serializeGraph(node);
	}

	/**
	 * 
	 * Clone an undirected graph. Each node in the graph contains a label and a
	 * list of its neighbors.
	 * 
	 * @param node
	 * @return
	 */
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		
		return null;
	}

	/**
	 * 
	 * Nodes are labeled uniquely.
	 * 
	 * We use # as a separator for each node, and , as a separator for node
	 * label and each neighbor of the node. As an example, consider the
	 * serialized graph {0,1,2#1,0,2#2,0,1,2}.
	 * 
	 * The graph has a total of three nodes, and therefore contains three parts
	 * as separated by #.
	 * 
	 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2. Second
	 * node is labeled as 1. Connect node 1 to node 2. Third node is labeled as
	 * 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
	 * 
	 * @param node
	 * @return
	 */
	// TODO this is simple as the label is stored in each node
	public static String serializeGraph(UndirectedGraphNode node) {
		StringBuilder ret = new StringBuilder();

		Set<Integer> marked = new HashSet<Integer>();
		Queue<UndirectedGraphNode> toVisit = new LinkedList<UndirectedGraphNode>();
		toVisit.add(node);
		marked.add(node.label); // marked
		while (!toVisit.isEmpty()) {
			UndirectedGraphNode visiting = toVisit.poll();
			ret.append(visiting.label); // append to result
			for (UndirectedGraphNode neighbor : visiting.neighbors) {
				if (!marked.contains(neighbor.label)) {
					toVisit.add(neighbor);
					marked.add(neighbor.label); // marked
				}
				ret.append(",").append(neighbor.label); // append to result
			}
			ret.append("#");
		}

		if (ret.length() > 0) {
			// get rid off appended #
			return ret.substring(0, ret.length() - 1);
		} else {
			return ret.toString();
		}
	}
}
