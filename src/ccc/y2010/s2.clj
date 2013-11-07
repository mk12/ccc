;;; Copyright 2013 Mitchell Kember. Subject to the MIT License.
;;; 2010 Canadian Computing Competition: Senior Division
;;; Problem S2: Huffman Encoding

(ns ccc.y2010.s2)

;;; A "binary sequence" is a string containing only ASCII 0 and 1.
;;; A "code" is a binary sequence that represents a value.
;;; A "value" is a char or a string.
;;; A "Huffman map" is a map from codes to values.

(defn decode-bit
  "Decodes a single bit using huff-map and [buf msg] where buf is a collection
  of bits that have not yet been decoded and msg is the decoded message so far."
  [huff-map [buf msg] bit]
  (let [new-buf (conj buf bit)]
    (if-let [value (huff-map (apply str new-buf))]
      [[] (conj msg value)]
      [new-buf msg])))

(defn main
  "Decodes bin-seq (a binary sequence) using huff-map (a Huffman map)."
  [huff-map bin-seq]
  (let [decode (partial decode-bit huff-map)]
    (->> (reduce decode [[] []] bin-seq)
         (second)
         (apply str))))
