;;; Copyright 2013 Mitchell Kember. Subject to the MIT License.
;;; 2010 Canadian Computing Competition: Senior Division
;;; Problem S4: Animal Farm

(ns ccc.y2010.s4)

;;; A "node" is an integer representing a point in an undirected graph.
;;; An "edge" is a collection of exactly two nodes, in increasing order.
;;; A "pen" is a collection of edges. The edges should form a closed polygon.
;;; A "vertex pen" is a collection of nodes that are conneced to form edges.
;;; For example, the pen [1 2 3] represents three edges connecting 1 and 2, 2
;;; and 3, and 3 and 1, forming a triangle.
;;; A "farm" is a collection of pens.
;;; A "vertex farm" is a collection of vertex pens.
;;; A "receipt" is a map from edges to integers representing the cost of
;;; trampling that edge.

(defn sort-edge
  "Sorts an edge so that the smaller node comes first."
  [[a b]]
  (if (< a b) [a b] [b a]))

(defn verts->edges
  "Converts a vertex pen to a pen."
  [verts]
  (let [rotated (take (count verts) (rest (cycle verts)))]
    (map (comp sort-edge vector) verts rotated)))

(defn trample
  "Removes an edge from a farm. If the edge is shared, the two pens will be
  combined and the farm's length will decrease by one."
  [farm edge]
  (let [[pen1 pen2] (filter #{edge} farm)]
    nil))

(defn main
  "Determines the minimal cost that will allow all animals to gather in one pen
  or outside all the pens given a vertex farm and its receipt."
  [vert-farm receipt]
  nil)
