(ns aoc.day01
  (:require [clojure.string :as str]))

(def lookup
  {"one"   "1"
   "two"   "2"
   "three" "3"
   "four"  "4"
   "five"  "5"
   "six"   "6"
   "seven" "7"
   "eight" "8"
   "nine"  "9"})

(def re "one|two|three|four|five|six|seven|eight|nine")

(defn first-last-nums [s]
  (let [nums (re-seq #"\d" s)]
    (parse-long (str (first nums) (last nums)))))

(defn first-last-nums-2 [s]
  (let [f (re-find (re-pattern (str "\\d|" re)) s)
        l (->> s
               str/reverse
               (re-find (re-pattern (str "\\d|" (str/reverse re))))
               str/reverse)
        nf   (if (contains? lookup f) (lookup f) f)
        nl   (if (contains? lookup l) (lookup l) l)]
    (parse-long (str nf nl))))

(defn part1 [inp]
  (->> inp
       str/split-lines
       (transduce
        (map first-last-nums)
        +)))

(defn part2 [inp]
  (->> inp
       str/split-lines
       (transduce
        (map first-last-nums-2)
        +)))

#_(part1 (slurp (clojure.java.io/resource "day01.txt")))
#_(part2 (slurp (clojure.java.io/resource "day01.txt")))
