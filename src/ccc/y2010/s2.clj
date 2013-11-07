;;; Copyright 2013 Mitchell Kember. Subject to the MIT License.
;;; 2010 Canadian Computing Competition: Senior Division
;;; Problem S2: Huffman Encoding

(ns ccc.y2010.s2)

;;; A "binary sequence" is a string containing only ASCII 0 and 1.
;;; A "Huffman code" is a collection of strings of the form
;;;     [code val code val code val ...]
;;; where code is a binary sequence and val is the value that it represents.

(defn sort-huffman
  "Sorts a Huffman code by the length of its codes."
  [huffman]
  (apply hash-map huffman))
  ;; (apply sorted-map-by #(<= (count %1) (count %2))
  ;;        huffman))

(defn main
  "Decodes bin-seq (a binary sequence) using huffman (a Huffman code)."
  [huffman bin-seq]
  (let [huff (sort-huffman huffman)]
    (loop [more bin-seq, code [], msg []]
      (if-let [value (first (map huff code))]
        (recur (rest more) [(first more)] (conj msg value))
        (recur (rest more) (conj code (first more)) msg)))))
