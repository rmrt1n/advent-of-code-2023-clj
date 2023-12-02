(ns aoc.day02
  (:require [clojure.string :as str]))

(defn parse-colors [s]
  (letfn [(parse-str [color]
            (transduce (map parse-long)
                       max
                       0
                       (re-seq (re-pattern (str "\\d+(?= " color ")")) s)))
          (rgb-map [color]
            {(keyword color) (parse-str color)})]
    (into {} (mapv rgb-map ["red" "green" "blue"]))))

(defn part1 [inp]
  (let [m {:red 12 :green 13 :blue 14}]
    (->> inp
         str/split-lines
         (transduce
          (comp (map parse-colors)
                (keep-indexed #(when (and (<= (:red %2) (:red m))
                                          (<= (:green %2) (:green m))
                                          (<= (:blue %2) (:blue m)))
                                 (inc %1))))
          +))))

(defn part2 [inp]
  (->> inp
       str/split-lines
       (transduce
        (comp (map parse-colors)
              (map #(apply * (vals %))))
        +)))

#_(part1 (slurp (clojure.java.io/resource "day02.txt")))
#_(part2 (slurp (clojure.java.io/resource "day02.txt")))
