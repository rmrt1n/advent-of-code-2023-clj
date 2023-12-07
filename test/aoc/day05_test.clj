(ns aoc.day05-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.java.io :as io]
            [aoc.day05 :as day05]
            [clojure.string :as str]))

(def example-inp
  ["seeds: 79 14 55 13"
   ""
   "seed-to-soil map:"
   "50 98 2"
   "52 50 48"
   ""
   "soil-to-fertilizer map:"
   "0 15 37"
   "37 52 2"
   "39 0 15"
   ""
   "fertilizer-to-water map:"
   "49 53 8"
   "0 11 42"
   "42 0 7"
   "57 7 4"
   ""
   "water-to-light map:"
   "88 18 7"
   "18 25 70"
   ""
   "light-to-temperature map:"
   "45 77 23"
   "81 45 19"
   "68 64 13"
   ""
   "temperature-to-humidity map:"
   "0 69 1"
   "1 0 69"
   ""
   "humidity-to-location map:"
   "60 56 37"
   "56 93 4"])

(deftest day05
  (testing "day 4 - part 1"
    (is (= 35
           (day05/part1 (str/join "\n" example-inp))))
    (is (= 177942185
           (day05/part1 (slurp (io/resource "day05.txt"))))))

  (testing "day 4 - part 2"
    (is (= 46
           (day05/part2 (str/join "\n" example-inp))))
    ;; not working yet
    #_(is (= ???
             (day05/part2 (slurp (io/resource "day05.txt")))))))
