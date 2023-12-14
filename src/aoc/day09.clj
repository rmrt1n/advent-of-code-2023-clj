(ns aoc.day09
  (:require
   [clojure.string :as str]))

(defn diffs [coll]
  (loop [coll coll
         acc  []]
    (if (every? zero? coll)
      (reduce + acc)
      (recur (map #(- %2 %1) coll (rest coll))
             (conj acc (last coll))))))

(defn part1 [inp]
  (->> inp
       (str/split-lines)
       (transduce
        (comp (map #(str/split % #" "))
              (map #(mapv parse-long %))
              (map diffs))
        +)))

(defn part2 [inp]
  (->> inp
       (str/split-lines)
       (transduce
        (comp (map #(str/split % #" "))
              (map #(mapv parse-long %))
              (map #(vec (reverse %)))
              (map diffs))
        +)))

#_(part1 (slurp (clojure.java.io/resource "day09.txt")))
#_(part2 (slurp (clojure.java.io/resource "day09.txt")))
