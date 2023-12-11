(ns aoc.day06
  (:require [clojure.string :as str]))

(defn race-options [[t d]]
  (let [wins (transduce
              (comp (map #(* % (- t %)))
                    (filter #(> % d)))
              conj
              (range (inc (quot t 2))))]
    (if (odd? (last wins))
      (inc (* 2 (dec (count wins))))
      (* 2 (count wins)))))

(defn part1 [inp]
  (->> inp
       str/split-lines
       (mapv #(re-seq #"\d+" %))
       (apply mapv vector)
       (transduce
        (comp (map #(mapv parse-long %))
              (map race-options))
        *)))

(defn part2 [inp]
  (->> inp
       str/split-lines
       (transduce
        (comp (map #(re-seq #"\d+" %))
              (map str/join)
              (map parse-long))
        conj)
       race-options))

#_(part1 (slurp (clojure.java.io/resource "day06.txt")))
#_(part2 (slurp (clojure.java.io/resource "day06.txt")))
