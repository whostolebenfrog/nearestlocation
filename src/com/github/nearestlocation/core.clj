(ns com.github.nearestlocation.core
  (:require [kdtree]
            [com.github.nearestlocation.types])

  (:import [com.github.nearestlocation.types Location])

  (:gen-class
   :name com.github.nearestlocation.Locator
   :state state
   :init init
   :constructors {[java.util.List] []}
   :methods [[getNearestLocation  [double double] com.github.nearestlocation.types.Location]
             [getNearestLocations [double double int] java.util.List]]))

(defn -init [locations]
  [[] (kdtree/build-tree (map #(with-meta
                                 (vector (.lat %) (.lng %))
                                 {:name (.name %)})
                              locations))])

(defn -getNearestLocations
  [this lat lng n]
  (map #(Location.
         (first (:point %))
         (second (:point %))
         (:name (meta %))) (kdtree/nearest-neighbor (.state this) [lat lng] n)))

(defn -getNearestLocation [this lat lng]
  (first (-getNearestLocations this lat lng 1)))
