(ns aoc.day04-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.java.io :as io]
            [aoc.day04 :as day04]
            [clojure.string :as str]))

(def example-inp
  ["Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"
   "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19"
   "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1"
   "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83"
   "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36"
   "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11"])

(deftest day04
  (testing "day 4 - part 1"
    (is (= 13
           (day04/part1 (str/join "\n" example-inp))))
    (is (= 19855
           (day04/part1 (slurp (io/resource "day04.txt"))))))

  (testing "day 4 - part 2"
    (is (= 30
           (day04/part2 (str/join "\n" example-inp))))
    (is (= 10378710
           (day04/part2 (slurp (io/resource "day04.txt")))))))
