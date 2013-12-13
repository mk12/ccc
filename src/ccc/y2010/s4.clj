;;; Copyright 2013 Mitchell Kember. Subject to the MIT License.
;;; 2010 Canadian Computing Competition: Senior Division
;;; Problem S4: Animal Farm

(ns ccc.y2010.s4
  (:require [clojure.set :as s]
            [clojure.contrib.seq :as q]))

;;; A "node" is an integer representing a point in an undirected graph.
;;; An "edge" is a collection of exactly two nodes, in increasing order.
;;; An "edge pen" is a collection of edges forming a closed polygon.
;;; A "vertex pen" is a collection of nodes that are conneced to form edges.
;;; (Vertex pen [1 2 3] and edge pen [[1 2] [2 3] [3 1]] are equivalent.)
;;; An "edge farm" is a collection of edge pens.
;;; A "vertex farm" is a collection of vertex pens.
;;; A "receipt" is a map from edges to integers that represent the cost of
;;; trampling (destroying) that edge.

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
  "Removes an edge from an edge farm. If the edge is shared, the two edge pens
  will be combined and the farm's length will decrease by one. The pens in the
  are assumed to be sets."
  [farm edge]
  (let [[[p1 p2] others] (q/separate #(contains? % edge) farm)
        combined (s/union (s/difference p1 p2) (s/difference p2 p1))]
    (conj others combined)))

(defn best-pen
  "Returns the pen in the farm that has the most connections to other pens. A
  pen has a single connectionw with another if they share one or more edges."
  [farm]
  nil)

(defn main
  "Determines the minimal cost that will allow all animals to gather in one pen
  or outside all the pens given a vertex farm and its receipt."
  [vert-farm receipt]
  (let [farm (map verts->edges vert-farm)]
    nil))
