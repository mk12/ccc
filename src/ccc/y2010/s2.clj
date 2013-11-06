;;; Copyright 2013 Mitchell Kember. Subject to the MIT License.
;;; 2010 Canadian Computing Competition: Senior Division
;;; Problem S2: Huffman Encoding

(ns ccc.y2010.s2)

;;; A "binary sequence" is a string containing only ASCII 0 and 1.
;;; A "Huffman code" is a map from binary sequences (representing individual
;;; codes) to strings (representing the decoded value).

(defn main
  "Decodes coded-message (a binary sequence) using huffman (a Huffman code)."
  [huffman coded-message]
  (loop [code coded-message, msg []]
    ;something
    nil))
