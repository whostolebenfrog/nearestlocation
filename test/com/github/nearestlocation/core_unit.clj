(ns com.github.nearestlocation.core-unit
  (:require [midje.sweet :refer :all])
  (:import [com.github.nearestlocation Locator]
           [com.github.nearestlocation.types Location]))

(defn location [[lat lng] name]
  (Location. lat lng name))

(def locator
  (Locator. [(location [-3 -4] "a") (location [-3.1 -4.5] "b") (location [51 -2] "Bristol")]))

(fact-group :unit
            (fact "Can find nearest neighbour using Java interface"
                  (let [loc (.getNearestLocation locator -3 -4)]
                    (.lat loc) => -3.0
                    (.lng loc) => -4.0
                    (.name loc) => "a"))

            (fact "Can find nearest neighbour(s) using Java interface"
                  (let [[loc_1 loc_2 & rest] (.getNearestLocations locator -3 -4 2)]
                    (empty? rest) => true
                    (.lat loc_1)  => -3.0
                    (.name loc_1) => "a"
                    (.name loc_2) => "b"
                    (.lng loc_2)  => -4.5)))
