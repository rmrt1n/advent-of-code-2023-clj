(ns aoc.day01-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.java.io :as io]
            [aoc.day01 :as day01]))

(deftest day01
  (testing "part 1"
    (is (= 55090
           (day01/part1 (slurp (io/resource "day01.txt"))))))
  (testing "part 2"
    (is (= 54845
           (day01/part2 (slurp (io/resource "day01.txt")))))))
