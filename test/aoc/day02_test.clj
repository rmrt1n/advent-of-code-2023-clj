(ns aoc.day02-test
  (:require [clojure.test :refer [deftest testing is]]
            [clojure.java.io :as io]
            [aoc.day02 :as day02]
            [clojure.string :as str]))

(def example-inp
  ["Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
   "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"
   "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"
   "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"
   "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"])

(deftest day02
  (testing "part 1"
    (is (= 8
           (day02/part1 (str/join "\n" example-inp))))
    (is (= 2164
           (day02/part1 (slurp (io/resource "day02.txt"))))))

  (testing "part 2"
    (is (= 2286
           (day02/part2 (str/join "\n" example-inp))))
    (is (= 69929
           (day02/part2 (slurp (io/resource "day02.txt")))))))
