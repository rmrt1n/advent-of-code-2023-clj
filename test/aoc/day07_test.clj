(ns aoc.day07-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.java.io :as io]
            [aoc.day07 :as day07]
            [clojure.string :as str]))

(def example-inp
  ["32T3K 765"
   "T55J5 684"
   "KK677 28"
   "KTJJT 220"
   "QQQJA 483"])

(deftest day07
  (testing "day 7 - part 1"
    (is (= 6440
           (day07/part1 (str/join "\n" example-inp))))
    (is (= 250370104
           (day07/part1 (slurp (io/resource "day07.txt"))))))
  (testing "day 7 - part 2"
    (is (= 5905
           (day07/part2 (str/join "\n" example-inp))))
    (is (= 251735672
           (day07/part2 (slurp (io/resource "day07.txt")))))))
