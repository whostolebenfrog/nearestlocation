(ns com.github.nearestlocation.core
  (:require [kdtree]
            [com.github.nearestlocation.types])

  (:import [com.github.nearestlocation.types Location])

  (:gen-class
   :name com.github.nearestlocation.Locator
   :state state
   :init init
   :constructors {[java.util.List] []}
   :methods [[getNearestLocation [double double] com.github.nearestlocation.types.Location]]))

(defn -init [locations]
  [[] (kdtree/build-tree (map #(with-meta
                                 (vector (.lat %) (.lng %))
                                 {:name (.name %)})
                              locations))])

(defn -getNearestLocation [this lat lng]
  (let [result (kdtree/nearest-neighbor (.state this) [lat lng])]
    (Location.
     (first (:point result))
     (second (:point result))
     (:name (meta result)))))
