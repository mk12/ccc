;;; Copyright 2013 Mitchell Kember. Subject to the MIT License.
;;; 2010 Canadian Computing Competition: Senior Division
;;; Problem S4: Animal Farm

(ns ccc.y2010.s4
  (:require [clojure.set :as s]))

;;; A "corner" is a unique integer representing a corner of a pen.
;;; An "edge" is a collection of exactly two corners, in increasing order.
;;; A "pen" is a collection of corners, given in cyclical order, which are
;;; connected by edges to form a polygon.
;;; A "farm" is a collection of pens.
;;; A "receipt" is a map from edges to integers that represent the cost of
;;; trampling (destroying) that edge.

;;; A "node" is a unique integer representing a point on an undirected graph.
;;; (Each node corresponds to a pen, not to a corner.)
;;; An "link" is a collection of the form [a b c] where a and b are nodes and c
;;; is an integer representing the cost of joining a and b via the link.
;;; A "graph" is a collection of links, representing an undirected graph.

(defn sort-edge
  "Sorts an edge so that the smaller corner comes first."
  [[a b]]
  (if (< a b) [a b] [b a]))

(defn pen->edges
  "Converts a pen to a collection of edges."
  [pen]
  (let [rotated (take (count pen) (rest (cycle pen)))]
    (map (comp sort-edge vector) pen rotated)))

;(defn edge->link
;  "Converts an edge from edge-farm (a farm that has been mapped with
;  pen->edges) to a link and transfers it to the graph."
;  [edge-farm graph]
;  (let [edge (ffirst edge-farm)])
; ([[1 2] [2 3] [4 5]]   [[4 3] [6 7] [8 9]])
; ([0 [[1 2] [2 3] [4 5]]] ...)
; -> ([0 1 2] [0 2 3] [0 4 5])

; maybe just use this in farm->graph
; after indexed edges, combine like (rest %)s somehow.
; make [a b c] (lookup cost in receipt for c)
; use b=-1 for outside ? (does ab/ba order matter?)
;(defn farm->indexed-edges
;  ""
;  [farm]
;  (->> farm
;       (map-indexed
;        (fn [i pen] (map #(cons i %) (pen->edges pen))))
;       (apply concat)))
;(farm->indexed-edges [[1 2 3] [5 6 7]])

(defn helper
  ""
  [edge coll]
  (let [nodes (vec (map peek coll))
        cost (receipt edge)]))

(defn farm->graph
  "Converts a farm and its receipt to a graph."
  [farm receipt]
  (let [edge-farm (map pen->edges farm)
        add-index (fn [i edges] (map #(conj % i) edges))
        edges (apply concat (map-indexed add-index edge-farm))
        grouped (group-by drop-last)])
  (->> (map pen->edges farm)
       (map-indexed (fn [i edges] (map #(conj % i) edges)))
       (apply concat)
       (group-by drop-last)
       (map (fn [[edge coll]] (conj (vec (map peek coll)) (receipt edge))))))

(defn farm->graph
  "Converts a farm and its receipt to a graph."
  [farm receipt]
  (let [edge-farm (map pen->edges farm)
        indexed (map-indexed vector edge-farm)]
    (loop [ff indexed, graph []]
      (let [edges (second (first ff))]
        (cond
         (empty? ff) graph
         (empty? edges) (recur (rest ff) graph)
         :else
         (if-let [other (first (filter (comp #{(first edges)} second) (rest ff)))]
           nil
           nil))))))

(defn main
  "Determines the minimal cost that will allow all animals to gather in one pen
  or outside all the pens given a farm and its receipt."
  [farm receipt]
  nil)
